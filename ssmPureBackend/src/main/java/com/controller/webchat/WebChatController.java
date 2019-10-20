// package com.controller.webchat;

// import java.io.IOException;
// import java.util.Date;
// import java.util.List;

// import javax.annotation.Resource;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.context.request.RequestContextHolder;
// import org.springframework.web.context.request.ServletRequestAttributes;
// import org.springframework.web.servlet.ModelAndView;
// import org.springframework.web.socket.TextMessage;
// import org.springframework.web.bind.annotation.CrossOrigin;

// import com.google.gson.GsonBuilder;
// import com.po.Goods;
// import com.websocket.MyWebSocketHandler;

// @CrossOrigin(origins="*", maxAge=3600)
// @Controller 
// public class WebChatController {
//     @Resource 
//     MyWebSocketHandler myWebSocketHandler;
//     @RequestMapping(value="WebChatController/webChat", method={RequestMethod.GET, RequestMethod.POST})
//     @ResponseBody 
//     public String webChat() throws IOException {
//         myWebSocketHandler.sendMessageToJsp(new TextMessage(new GsonBuilder().create().toJson("\"number\":\""+"WebChatController/webChat"+"\"")), "AAA");
//         return "1";
//     }
// }


