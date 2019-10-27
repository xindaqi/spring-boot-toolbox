package com.websocket;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
 
/**
 * @Description 
 * @Author Nobody
 * @Date 2019/10/18 14:19
 * @Version 1.0
 **/
@Configuration
@EnableWebMvc
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer{
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        System.out.println("===========================注册websocket================");
        webSocketHandlerRegistry.addHandler(msgSocketHandle(),"/websocket")
                .addInterceptors(new WebSocketHandshakeInterceptor());
        webSocketHandlerRegistry.addHandler(msgSocketHandle(),
                "/sockjs/websocket").
                addInterceptors(new WebSocketHandshakeInterceptor())
                .withSockJS();
    }
    @Bean(name = "msgSocketHandle")
    public WebSocketHandler msgSocketHandle(){
        return new MsgSocketHandle();
    }
}