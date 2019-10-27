// package com.websocket;

// import java.util.Map;

// import org.springframework.http.server.ServerHttpRequest;
// import org.springframework.http.server.ServerHttpResponse;
// import org.springframework.http.server.ServletServerHttpRequest;
// import org.springframework.web.socket.WebSocketHandler;
// import org.springframework.web.socket.server.HandshakeInterceptor;

// public class HandShake implements HandshakeInterceptor{
//     @Override 
//     public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//     Map<String, Object> attributes) throws Exception{
//         String jspCode = ((ServletServerHttpRequest) request).getServletRequest().getParameter("jspCode");
//         // mark user
//         // String userId = (String) session.getAttribute("userId");
//         if(jspCode != null){
//             attributes.put("jspCode", jspCode);
//         }else{
//             return false;
//         }
//         return true;
//     }

//     @Override 
//     public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
//     Exception exception){
//         // TODO
//     }
// }