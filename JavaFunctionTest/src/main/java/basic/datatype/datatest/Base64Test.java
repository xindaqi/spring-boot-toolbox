package basic.datatype.datatest;

import java.util.Base64;

public class Base64Test{
    static Base64.Encoder b64Encoder = Base64.getEncoder();
    static Base64.Decoder b64Decoder = Base64.getDecoder();

    public static void main(String[] args) throws Exception{
        String dataSource = "client:123456";
        byte[] dataBytes = dataSource.getBytes("UTF-8");
        String dataEncoder = b64Encoder.encodeToString(dataBytes);
        System.out.format("Data encoder:"+dataEncoder+"\n");
        String dataDecoder = new String(b64Decoder.decode(dataEncoder), "UTF-8");
        System.out.format("Data decoder:"+dataDecoder+"\n");

        
    }
}

