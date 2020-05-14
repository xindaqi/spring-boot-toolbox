package basic.datatype.dataprocess;

import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
// import org.apache.commons.codec.binary.Base64;

public class GenerateSingature {
    static Base64.Encoder b64Encoder = Base64.getEncoder();
    public static String generateSignatrue(String header, String appKey, String url, String appSecret){
        try{
            String spliceData = header + appKey + url;
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(appSecret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            String signature = b64Encoder.encodeToString(sha256_HMAC.doFinal(spliceData.getBytes()));
            return signature;
        }catch(Exception e){
            e.printStackTrace();
        }
        return "ERROR";
        
    }

    public static void main(String[] args){
        String header = "POST\n*/*\napplication/json\n";
        String appKey = "x-ca-key:20769288\n";
        String url = "/artemis/api/cfas/v2/passengerFlow/allGroup";
        String appSecret = "LaOWdgn64UQCzZhuIaUo";
        String signature = GenerateSingature.generateSignatrue(header, appKey, url, appSecret);
        System.out.println("signature:"+signature);

    }

}