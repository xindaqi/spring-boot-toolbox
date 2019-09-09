package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TAG = "Input message";
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "hello");
        btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                new Thread(new Runnable(){
                    @Override
                    public void run(){
//                        getWebInfo();
                        String userInfo = sendPost();
//                        sendPostRequest();
                    }
                }).start();
            }
        });

    }
    private void getWebInfo(){
        String urlPath = "http://localhost:8090/api/test/facebase/user/search";
        String urlTest = "https://www.baidu.com";
        try{
            URL url = new URL(urlTest);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream inputStream = conn.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            StringBuffer buffer = new StringBuffer();
            String temp = null;
            while((temp=bufferedReader.readLine()) != null){
                buffer.append(temp);
            }
            bufferedReader.close();
            reader.close();
            inputStream.close();
            Log.e("MAIN", buffer.toString());
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.v(TAG, message);
        System.out.println("Input message:"+message);
    }

//    public static void sendPostRequest(View view){
//        System.out.println("test output:"+testOutput());
//
////        sendPost();
////        Intent intent = new Intent(this, PostTestActivity.class);
////        EditText editText = (EditText) findViewById(R.id.editText);
////        String message = editText.getText().toString();
////        String message = "hello world";
////        postIntent.putExtra(EXTRA_MESSAGE, message);
////        startActivity(postIntent);
////        Log.v(TAG, message);
////        System.out.println("Input message:"+message);
//
//
//
//    }

    public static String testOutput(){
        String output = "hello world";
        return output;
    }

    public String sendPost(){
        Intent intent = new Intent(this, PostTestActivity.class);

        String result = "";
        try{
            JSONObject body = new JSONObject();
            body.put("u_id", "1");
            body.put("u_name", "小一");
            body.put("u_phone", "13956013120");
            String urlPath = "http://192.168.0.168:8090/api/test/facebase/user/search";
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(10000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            String content = String.valueOf(body);
            System.out.println("body:"+content);
            //
            conn.connect();
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.append(content);
            out.flush();
            out.close();
            //
//            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//
//            os.writeBytes(content);
//            os.flush();
//            os.close();
            System.out.println("code: "+conn.getResponseCode());
            if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStreamReader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader bf = new BufferedReader(in);
                String receiveData = null;
                while((receiveData = bf.readLine()) != null){
                    result += receiveData+"\n";
                }
                in.close();
                conn.disconnect();
//                intent.putExtra(EXTRA_MESSAGE, result);
//                startActivity(intent);
                System.out.println("received data: "+result);
            }
        }catch(JSONException e){
//            System.out.println("Error");
            e.printStackTrace();
        }catch(IOException io){
//            System.out.println("Error");
            io.printStackTrace();
        }
        intent.putExtra(EXTRA_MESSAGE, result);
        startActivity(intent);
        return result;
    }

    /**
     * Post test
     * @param
     */
    public void sendPostRequest(){
        Intent postIntent = new Intent(this, PostTestActivity.class);
        String strUrlPath = "http://192.168.0.168:8090/api/test/facebase/user/search";
        Map<String, String> params = new HashMap<>();
        params.put("u_name", "小一");
        params.put("u_id", "string");
        params.put("u_phone", "string");
        String encode = "UTF-8";
        byte[] data = getRequestData(params, encode).toString().getBytes();
        String message = "";
        try{
            URL url = new URL(strUrlPath);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 超连接时间
            httpURLConnection.setConnectTimeout(10000);
            // Get data from server by opening input stream
            httpURLConnection.setDoInput(true);
            // Submit data to server by opening output stream
            httpURLConnection.setDoOutput(true);
            // Set request method: POST
            httpURLConnection.setRequestMethod("POST");
            // Do not use cache
            httpURLConnection.setUseCaches(false);
            // content-type
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data);
            int response = httpURLConnection.getResponseCode();
            if(response == HttpURLConnection.HTTP_OK){
                InputStream inputStream = httpURLConnection.getInputStream();
                message = dealResponseResult(inputStream);
                postIntent.putExtra(EXTRA_MESSAGE, message);
                startActivity(postIntent);
                System.out.println("request message: "+message);
            }
        }catch (IOException e){
            e.printStackTrace();
        }



    }


    /**
     * Package request body
     * @param params:reqeuest body
     * @param encode:encode type
     * @return
     */
    public static StringBuffer getRequestData(Map<String, String> params, String encode){
        StringBuffer stringBuffer = new StringBuffer();
        try{
            for(Map.Entry<String, String> entry: params.entrySet()){
                stringBuffer.append(entry.getKey())
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(), encode))
                        .append("&");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuffer;
    }

    public static String dealResponseResult(InputStream inputStream){
        String resultData = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        try{
            while((len = inputStream.read(data)) != -1){
                byteArrayOutputStream.write(data, 0, len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        resultData = new String(byteArrayOutputStream.toByteArray());
        return resultData;
    }

}
