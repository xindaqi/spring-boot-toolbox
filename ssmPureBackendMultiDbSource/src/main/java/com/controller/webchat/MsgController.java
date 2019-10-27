package com.controller.webchat;
 
import com.datasource.po.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import javax.servlet.http.HttpServletRequest;

// import com.websocket.fullversion.MsgSocketHandle;
import com.websocket.MsgSocketHandle;
 
@RequestMapping("/websocket")
@Controller
public class MsgController {
    @Autowired
    private MsgSocketHandle msgSocketHandle;
    @RequestMapping("/index")
    public String login(){
        return "websocket/login";
    }

    @RequestMapping("/login")
    public String login(People people, HttpServletRequest request){
        System.out.format("name:"+people.getUserName());
        request.getSession().setAttribute("people",people);
        return "websocket/chat";
    }
    @ResponseBody
    @RequestMapping(value = "/sendMsg",produces = "application/json; charset=utf-8")
    public String sendMsgToUser(String content,String toUserName){
        People people = new People();
        people.setUserName(toUserName);
        TextMessage textMessage = new TextMessage(content);
        msgSocketHandle.sendMessageToUser(people,textMessage);
        return "发送成功";
    }
    @ResponseBody
    @RequestMapping(value = "/sendMsg2",produces = "application/json; charset=utf-8")
    public String sendMsgToAll(String content) throws Exception {
        TextMessage textMessage = new TextMessage(content);
        msgSocketHandle.sendMsgToAllUsers(textMessage);
        return "发送成功";
    }
}