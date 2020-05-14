package com.company.web.util.https;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Iterator;
import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.entity.StringEntity;

public class HttpsRequestV45Util {
    /**
     * Post请求
     * @param httpClient
     * @param url
     * @param paramHeader
     * @param paramBody
     * @return
     * @throws Exception
     */
    public static String doPost(HttpClient httpClient, String url, Map<String, String> paramHeader,
    String paramBody) throws Exception{
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        setHeader(httpPost, paramHeader);
        if(paramBody !=null){
            StringEntity entity = new StringEntity(paramBody, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
        }
        HttpResponse response = httpClient.execute(httpPost);
        // Header[] locationArr = response.getHeaders("Location");
        // String locationStr = locationArr[0].getValue();
        // System.out.println("locationStr:"+locationStr);
        if(response != null){
            HttpEntity resEntity = response.getEntity();
            if(resEntity != null){
                result = EntityUtils.toString(resEntity, "UTF-8");
            }
        }
        return result;
    }

    public static String doDelete(HttpClient httpClient, String url, Map<String, String> paramHeader) throws Exception{
        String result = null;
        HttpDelete httpDelete = new HttpDelete(url);
        setHeader(httpDelete, paramHeader);
        HttpResponse response = httpClient.execute(httpDelete);
        if(response != null){
            HttpEntity resEntity = response.getEntity();
            if(resEntity != null){
                result = EntityUtils.toString(resEntity, "UTF-8");
            }
        }
        return result;
    }

    public static String doPut(HttpClient httpClient, String url, Map<String, String> paramHeader,
    String paramBody) throws Exception{
        String result = null;
        HttpPut httpPut = new HttpPut(url);
        setHeader(httpPut, paramHeader);
        if(paramBody != null){
            StringEntity entity = new StringEntity(paramBody, ContentType.APPLICATION_JSON);
            httpPut.setEntity(entity);
        }
        HttpResponse response = httpClient.execute(httpPut);
        if(response != null){
            HttpEntity resEntity = response.getEntity();
            if(resEntity != null){
                result = EntityUtils.toString(resEntity, "UTF-8");
            }
        }
        return result;
    }

    public static String doGet(HttpClient httpClient, String url, Map<String, String> paramHeader,
    Map<String, String> paramBody) throws Exception{
        String result = null;
        HttpGet httpGet = new HttpGet(url);
        setHeader(httpGet, paramHeader);
        HttpResponse response = httpClient.execute(httpGet);
        if(response != null){
            HttpEntity resEntity = response.getEntity();
            if(resEntity != null){
                result = EntityUtils.toString(resEntity, "UTF-8");
            }
        }
        return result;
    }

    private static void setHeader(HttpRequestBase request, Map<String, String> paramHeader){
        if(paramHeader != null){
            Set<String> keySet = paramHeader.keySet();
            for(String key:keySet){
                request.addHeader(key, paramHeader.get(key));
            }
        }
    }

    private static void setBody(HttpPost httpPost, Map<String, String> paramBody, String charset) throws Exception{
        if(paramBody != null){
            List<NameValuePair> list = new ArrayList<>();
            Set<String> keySet = paramBody.keySet();
            for(String key:keySet){
                list.add(new BasicNameValuePair(key, paramBody.get(key)));
            }
            if(list.size()>0){
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
        }
    }

}