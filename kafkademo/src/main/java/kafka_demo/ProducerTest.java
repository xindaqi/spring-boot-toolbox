package kafka_demo;

public class ProducerTest {
    public static void main(String[] args){
        for(int i=0;i<10;i++){
            String data = "Data:"+i;
            ProducerDemo.sendMessage(data, "localhost:9092", "topic-demo");
            System.out.print(data+"\n");
        }
    }
}
