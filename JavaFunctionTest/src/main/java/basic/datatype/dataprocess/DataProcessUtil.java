package basic.datatype.dataprocess;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DataProcessUtil {
    public static String[] splitString(String symbol, String datas){
        String[] splitStr = null;
        if(symbol.equals("")){
            splitStr = datas.split("\\");
            return splitStr;
        }else{
            splitStr = datas.split("\\"+symbol);
            return splitStr;
        }
    }

    public static void splitStringIterator(String[] datas){
        for(int i=0;i<datas.length;i++){
            System.out.println("data:"+datas[i]);
        }
    }

    public static void main(String[] args){
        String dataStr1 = "Hello|world";
        String dataStr2 = "Hello,world";
        String[] resStr1 = splitString("|", dataStr1);
        String[] resStr2 = splitString(",", dataStr2);
        splitStringIterator(resStr1);
        splitStringIterator(resStr2);
        Integer num1 = 9,num2 = 4, remainder=0, freq=0;
        remainder=num1%num2;
        if(remainder==0){
            freq = num1/num2;
        }else{
            freq = num1/num2+1;
        }
        System.out.println("frequency:"+freq);
        for(int i=1;i<=freq;i++){
            System.out.println("i:"+i);
        }
        List<String> listExtract = Arrays.asList("name", "address", "sex", "position", "salary", "height", "age");
        System.out.println("substract list:"+listExtract.subList(2, 4));
        Scanner inputData = new Scanner(System.in);
        System.out.println("Please input your name:");
        // String format
        String name = inputData.nextLine();
        System.out.println("Name:"+name);
        // Integer format
        System.out.println("Please input your age:");
        Integer age = inputData.nextInt();
        System.out.println("Age:"+age);
        // Double format
        System.out.println("Please input your salary:");
        Double salary = inputData.nextDouble();
        System.out.println("Salary:"+salary);
        



    }

}