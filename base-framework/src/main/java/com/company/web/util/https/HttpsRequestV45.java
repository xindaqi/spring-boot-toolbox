package com.company.web.util.https;


import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder; 
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public abstract class HttpsRequestV45 extends HttpClientBuilder{
    private CloseableHttpClient client;
    protected ConnectionSocketFactory connectionSocketFactory;

    public CloseableHttpClient init() throws Exception{
        this.prepareCertificate();
        this.regist();
        return this.client;
    }

    public abstract void prepareCertificate() throws Exception;
    protected void regist(){
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
        .register("http", PlainConnectionSocketFactory.INSTANCE)
        .register("https", this.connectionSocketFactory)
        .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        HttpClients.custom().setConnectionManager(connManager);
        this.client = HttpClients.custom().setConnectionManager(connManager).build();
    }

}