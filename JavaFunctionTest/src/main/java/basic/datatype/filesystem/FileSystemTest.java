package basic.datatype.filesystem;

import java.util.Arrays;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSystemTest{
    /**
     * 获取文件名及文件路径
     * @param path
     */
    public void getFileName(String path){
        File file = new File(path);
        if(!file.exists()){
            System.out.format("文件夹不存在,我要新建它\n");
            file.mkdir();
            System.out.format("新建完毕");
        }else{
            File filePath[] = file.listFiles();
            String s[] = file.list();
            System.out.format("file list:"+s+"\n");
            for(int i=0;i<s.length;i++){
                System.out.format("file path:"+filePath[i]+"\n");
                System.out.format("file name by get:"+filePath[i].getName()+"\n");
                System.out.format("file name by list:"+s[i]+"\n");
            } 
        }  
    }


    public void readFile(String path){
        File file = new File(path);
        File fileLi[] = file.listFiles();
        for(int i=0;i<fileLi.length;i++){
            System.out.format("文件名:"+fileLi[i].getName()+"\n");
            System.out.format("文件路径:"+fileLi[i]+"\n");
            File fileData = new File(fileLi[i].toString());
            try{
                FileInputStream fis = new FileInputStream(fileData);
                int n = 0;
                byte[] bytes = new byte[1024];
                while(n!=-1){
                    n = fis.read(bytes);
                    // System.out.format("Arrays data:"+Arrays.toString(bytes)+"\n");
                    // System.out.format("String data:"+new String(bytes)+"\n");
                }
                fis.close();
                System.out.format("String data:"+new String(bytes)+"\n");
            }catch(Exception e){
                e.printStackTrace();
            }
            
        } 
    }

    public void writeFileByInt(String path){
        File file = new File(path);
        try{
            file.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            FileOutputStream fos = new FileOutputStream(file, false);
            String str = "hello world!";
            for(int i=0;i<str.length();i++){
                int b = (int)str.charAt(i);
                fos.write(b);
            }
            fos.close();
            System.out.format("写入完成!\n");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void writeFileByBytes(String path){
        File file = new File(path);
        try{
            file.createNewFile();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            FileOutputStream fos = new FileOutputStream(file, true);
            String str = "hello world!";
            fos.write(str.getBytes(), 1, 3);
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void copyFile(String path1, String path2){
        File sourceFile = new File(path1);
        File desFile = new File(path2);
        try{
            desFile.createNewFile();
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(desFile);
            byte[] bufferBytes = new byte[fis.available()];
            fis.read(bufferBytes);
            fos.write(bufferBytes);
            fos.flush();
            fos.close();
            fis.close();
            System.out.format("复制成功!");
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public static void main(String[] args){
        String path = "/home/xdq/xinPrj/java/javaTest/JavaFunctionTest/src/main/resources/files";
        String path1 = "/home/xdq/xinPrj/java/javaTest/JavaFunctionTest/src/main/resources/newfiles";
        String path2 = "/home/xdq/xinPrj/java/javaTest/JavaFunctionTest/src/main/resources/newfiles/test.txt";
        String path3 = "/home/xdq/xinPrj/java/javaTest/JavaFunctionTest/src/main/resources/newfiles/testOne.txt";
        String path4 = "/home/xdq/xinPrj/java/javaTest/JavaFunctionTest/src/main/resources/files/en_words.txt";
        String path5 = "/home/xdq/xinPrj/java/javaTest/JavaFunctionTest/src/main/resources/newfiles/en_words.txt";
        FileSystemTest fst = new FileSystemTest();
        fst.getFileName(path1);
        fst.readFile(path);
        fst.writeFileByInt(path2);
        fst.writeFileByBytes(path3);
        fst.copyFile(path4, path5);
    }
}