// package com.websocket.fullversion;
 
// import com.po.People;
// import org.springframework.http.server.ServerHttpRequest;
// import org.springframework.http.server.ServerHttpResponse;
// import org.springframework.http.server.ServletServerHttpRequest;
// import org.springframework.web.socket.WebSocketHandler;
// import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
 
// import javax.servlet.http.HttpSession;
// import java.util.Map;
 
// /**
//  * @Description TODO
//  * @Author yuki
//  * @Date 2018/9/10 9:30
//  * @Version 1.0
//  **/
// public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
//     @Override
//     public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
//         if (request instanceof ServletServerHttpRequest){
//             ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) request;
//             HttpSession session = servletServerHttpRequest.getServletRequest().getSession(false);
//             if(session != null){
//                 //从session中获取当前用户
//                 People people = (People) session.getAttribute("people");
//                 map.put("people",people);
//             }
//         }
//         return true;
//     }
//     @Override
//     public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
//         super.afterHandshake(serverHttpRequest,serverHttpResponse,webSocketHandler,e);
//     }
// }