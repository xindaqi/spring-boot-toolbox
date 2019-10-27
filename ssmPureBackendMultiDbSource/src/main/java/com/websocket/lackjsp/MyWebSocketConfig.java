// package com.websocket;

// import javax.annotation.Resource;

// import org.springframework.stereotype.Component;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// import org.springframework.web.servlet.config.annotation.WebMvcCoinfigurerAdapter;
// import org.springframework.web.socket.config.annotation.EnableWebSocket;
// import org.springframework.web.socket.config.annotation.WebSocketCongigurer;
// import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

// @Component 
// @EnableWebMvc 
// @EnableWebSocket 
// public class MyWebSocketConfig extends WebMvcConfiggurerAdapter implements WebSocketConfigurer{
//     @Resource 
//     MyWebSocketHandler handler;

//     @Override 
//     public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
//         System.out.format("注册socket");
//         registry.addHandler(handler, "/wsMy").addInterceptors(new HandShake());
//         registry.addHandler(handler, "/wsMy/sockjs").addInterceptors(new HandShake()).withSockJS();
//     }
// }