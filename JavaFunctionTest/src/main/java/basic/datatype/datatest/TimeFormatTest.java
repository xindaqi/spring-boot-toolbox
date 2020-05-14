package basic.datatype.datatest;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeFormatTest{
    static final Logger logger = LoggerFactory.getLogger(TimeFormatTest.class);
    public long dateTest(Date date){
        System.out.println("date directly output:"+date);
        long seconds = date.getTime();
        String dateSeconds = String.valueOf(date.getTime());
        System.out.format("time seconds:"+dateSeconds+"\n");
        System.out.println("toString test:"+date.toString());
        logger.info("Date test");
        return seconds;
    }
    public void simpleDateTest(Date date, String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateOut = sdf.format(date);
        System.out.println("data format:"+dateOut);
    }
    public void secondsToDHMFormat(long seconds){
        long days = seconds/(1000*60*60*24);
        long hours = (seconds%(1000*60*24))/(1000*60*60);
        long minutes = (seconds%(1000*60*60))/(1000*60);
        System.out.println(days+"天"+hours+"时"+minutes+"分");
    }
    public void secondsToYMDFormat(long seconds, String dateFormat){
        Date date = new Date(seconds);
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String dateOut = sdf.format(date);
        System.out.println("date:"+dateOut);
    }

    public static void main(String[] args){
        Date date = new Date();
        long milliseconds = date.getTime();
        System.out.format("time: "+date+"\n");
        TimeFormatTest timeFormatTest = new TimeFormatTest();
        timeFormatTest.dateTest(date);
        timeFormatTest.simpleDateTest(date, "yyyy-MM-dd HH:mm:ss");
        timeFormatTest.simpleDateTest(date, "yyyyMMddHHmmss");
        timeFormatTest.secondsToDHMFormat(timeFormatTest.dateTest(date));
        timeFormatTest.secondsToYMDFormat(milliseconds, "yyyy-MM-dd HH:mm:ss");
        // logger.info("time:{}", timeFormatTest.dateTest()+"\n");
        // long nowTime = date.getTime();
        // System.out.format("now time secondes:"+nowTime+"\n");
        // System.out.format("time seconds: "+date.getTime()+"\n");
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // System.out.format("Date: "+sdf.format(date)+"\n");
        // String data = sdf.format(date);
        // String dateFromSource = "2019-09-25  16:55:09";
        // System.out.format("Date from source: "+dateFromSource+"\n");
        // String beginTime = "";
        // System.out.format("being time lenght: "+beginTime.length()+"\n");
        // if (beginTime!=null && beginTime.length()>0){
        //     System.out.format("datas:"+beginTime+"\n");
        // }else{
        //     System.out.format("String is empty\n");
        // }
        // try{
        //     Date dateDat = sdf.parse(dateFromSource);
        //     System.out.format("Parse time: "+dateDat+"\n");
        //     long diff = date.getTime() - dateDat.getTime();
        //     System.out.format("time difference: "+diff+"\n");
        //     long days = diff/(1000*60*60*24);
        //     long hours = (diff%(1000*60*24))/(1000*60*60);
        //     long minutes = (diff%(1000*60*60))/(1000*60);
        //     long seconds = (diff%(1000*60))/1000;
        //     System.out.format(days+"天"+hours+"小时"+minutes+"分"+seconds+"秒"+"\n");
            
        // }catch(Exception e){
        //     e.printStackTrace();
        // }
    }
}