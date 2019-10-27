// package com.websocket;

// import java.io.IOException;
// import java.util.HashMap;
// import java.util.Iterator;
// import java.util.Map;
// import java.util.Map.Entry;

// import org.springframework.stereotype.Component;
// import org.springframeowrk.web.socket.CloseStatus;
// import org.springframework.web.socket.TextMessage;
// import org.springframework.web.socket.WebSocketHandler;
// import org.springframework.web.socket.WebSocketMessage;
// import org.springframework.web.socket.WebSocketSession;

// import com.google.gson.GsonBuilder;

// @Component 
// public class MyWebSocketHandler implements WebSocketHandler{
//     public static final Map<String, WebSocketSession> userSocketSessionMap;
//     static {
//         userSocketSessionMap = new HashMap<String, WebSocketSession>();
//     }

//     @Override 
//     public void afterConnectionEstablished(WebSocketSession session) throws Exception{
//         String jspCode = (String) session.getHandshakeAttributes().get("jspCode");
//         if(userSocketSessionMap.get(jspCode) == null){
//             userSocketSessionMap.put(jspCode, session);
//         }
//         for(int i=0; i<10; i++){
//             session.sendMessage(new TextMessage(new GsonBuilder().create().toJson("\"nubmer\":\""+i+"\"")));
//         }
//     }

//     @Override 
//     public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception{
//         session.sendMessage(message);
//     }

//     @Override 
//     public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception{
//         if (session.isOpen()){
//             session.close();
//         }
//         Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
//         while (it.hasNext()){
//             Entry<String, WebSocketSession> entry = it.next();
//             if(entry.getValue().getId().equals(session.getId())){
//                 userSocketSessionMap.remove(entry.getKey());
//                 System.out.format("Socket会话已移除:用户ID"+entry.getKey());
//                 break;
//             }
//         }
//     }

//     @Override 
//     public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception{
//         System.out.format("WebSocket:" + session.getId() + "已经关闭");
//         Iterator<Entry<String, WebSocketSession>> entry = userSocketSessionMap.entrySet().iterator();
//         while (it.hasNext()){
//             Entry<String, WebSocketSession> entry = it.next();
//             if (entry.getValue().getId().equals(session.getId())){
//                 userSocketSessionMap.remove(entry.getKey());
//                 System.out.format("socket会话已经移除:用户ID"+entry.getKey());
//                 break;
//             }
//         }
//     }

//     @Override 
//     public boolean supportPartialMessages(){
//         return false;
//     }

//     public void broadcast(final TextMessage message) throws IOException{
//         Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
//         while (it.hasNext()){
//             final Entry<String, WebSocketSession> entry = it.next();
//             if (entry.getValue().isOpen()){
//                 new Thread(new Runnable(){
//                     public void run(){
//                         try{
//                             if(entry.getValue().isOpen()){
//                                 entry.getValue().sendMessage(message);
//                             }
//                         }catch(IOException e){
//                             e.printStackTrace();
//                         }
//                     }
//                 }).start();
//             }
//         }
//     }

//     public void sendMessageToJsp(final TextMessage message, String type) throws IOException{
//         Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
//         while (it.hasNext()){
//             final Entry<String, WebSocketSession> entry = it.next();
//             if(entry.getValue().isOpen() && entry.getKey().contains(type)){
//                 new Thread(new Runnable(){
//                     public void run(){
//                         try{
//                             if (entry.getValue().isOpen()){
//                                 entry.getValue().sendMessage(message);
//                             }
//                         }catch (IOException e){
//                             e.printStackTrace();
//                         }
//                     }
//                 }).start();
//             }
//         }
//     }
// }

