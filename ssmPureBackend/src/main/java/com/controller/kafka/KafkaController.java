package com.controller.kafka;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import com.kafka.KafkaConsumerDemo;
import com.kafka.KafkaProducerDemo;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;

import com.websocket.MsgSocketHandle;

@Controller 
@RequestMapping("/kafka")
public class KafkaController{
    @Resource(name="kafkaProducerDemo")
    // @Autowired
    private KafkaProducerDemo producer;

    @Resource(name="kafkaConsumerDemo")
    // @Autowired
    private KafkaConsumerDemo consumer;

    @Autowired 
    private MsgSocketHandle msgSocketHandle;

    @RequestMapping(value="/welcome")
    @ResponseBody
    // public String welcome(){
    public ModelAndView welcome(){
        System.out.format("-------welcome-------\n");
        // return "kafka";
        ModelAndView mv = new ModelAndView();
        mv.setViewName("kafka/welcome");
        return mv;
    }

    @RequestMapping(value="/sendmessage", method=RequestMethod.GET)
    public ModelAndView sendMessge(){
        System.out.format("-----sendmessage-----\n");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = sdf.format(date);

        ModelAndView mv = new ModelAndView();
        mv.addObject("time", now);
        mv.setViewName("kafka/kafka_send");
        return mv;
    }

    @RequestMapping(value="/onsend", method=RequestMethod.POST)
    public ModelAndView onsend(@RequestParam("message") String msg) throws Exception{
        System.out.format("-----onsend-----\n");
        producer.sendMessage(msg);
        String msgFromProducer = consumer.receive();
        System.out.format("Message from producer: "+msgFromProducer+"\n");
        TextMessage textMessage = new TextMessage(msgFromProducer);
        msgSocketHandle.sendMsgToAllUsers(textMessage);
        System.out.format("Send message by websocket: "+textMessage+"\n");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("kafka/welcome");
        return mv;
    }

    @RequestMapping(value="/receive")
    public ModelAndView receive(){
        System.out.format("-----receive------\n");
        String msg = consumer.receive();

        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", msg);
        mv.setViewName("kafka/kafka_receive");
        return mv;
    }

}