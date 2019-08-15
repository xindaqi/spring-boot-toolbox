package kafka_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class ProducerDemo {
    public static boolean sendMessage(String msg, String url, String topicName){
        KafkaProducer<String, String> producer = null;
        boolean flag = false;
        try{
            Properties props = init(url);
            producer = new KafkaProducer<String, String>(props);
            producer.send(new ProducerRecord<String, String>(topicName, msg));
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(producer != null){
                producer.close();
            }
        }
        return flag;
    }

    public static boolean sendMessage(List<String> listMsg, String url, String topicName){
        KafkaProducer<String, String> producer = null;
        boolean flag = false;
        try{
            Properties props = init(url);
            producer = new KafkaProducer<String, String>(props);
            for(String msg : listMsg){
                producer.send(new ProducerRecord<String, String>(topicName, msg));

            }
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(producer != null){
                producer.close();
            }
        }
        return flag;
    }

    public static boolean sendMessage(List<String> listMsg, String urls, String topicName, int num) throws Exception{
        KafkaProducer<String, String> producer = null;
        boolean flag = false;
        try{
            Properties props = init(urls);
            producer = new KafkaProducer<String, String>(props);
            List<String> listMsg2 = new ArrayList<String>();
            for(int i=1, j=listMsg.size(); i<=j;i++){
                listMsg2.add(listMsg.get(i-1));
                if(i%num == 0 || i==j){
                    producer.send(new ProducerRecord<String, String>(topicName, listMsg2.toString()));
                    listMsg2.clear();
                }
            }
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(producer != null){
                producer.close();
            }
        }
        return flag;
    }

    private static Properties init(String urls){
        Properties props = new Properties();
        props.put("bootstrap.servers", urls);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16834);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        return props;
    }
}
