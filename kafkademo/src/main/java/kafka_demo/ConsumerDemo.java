package kafka_demo;

import java.util.Collections;
import java.util.Properties;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.consumer.ConsumerConnector;

public class ConsumerDemo {
    public static void main(String[] args){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "topic-demo");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        consumer.subscribe(Collections.singletonList("topic-demo"));
        try{
            while(true){
                ConsumerRecords<String, String> records = consumer.poll(100);
                for(ConsumerRecord<String, String> record : records){
                    System.out.println("topic:"+record.topic()+"\tparition:"+record.partition()
                    +"\toffset:"+record.offset()+"\tkey:"+record.key()+"\tvalue:"+record.value());
                }
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            consumer.commitSync();
            consumer.close();
        }

    }
}

