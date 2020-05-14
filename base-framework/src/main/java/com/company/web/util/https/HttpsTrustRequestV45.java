package com.company.web.util.https;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;

public class HttpsTrustRequestV45 extends HttpsRequestV45{
    public HttpsTrustRequestV45(){

    }

    @Override 
    public void prepareCertificate() throws Exception{
        SSLContext ctx = SSLContext.getInstance("TLS");
        X509TrustManager tm = new X509TrustManager(){
            @Override 
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException{

            }

            @Override 
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException{

            }

            @Override 
            public X509Certificate[] getAcceptedIssuers(){
                return null;
            }

        };
        ctx.init(null, new TrustManager[] {tm}, null);
        this.connectionSocketFactory = new SSLConnectionSocketFactory(ctx);
    }

}