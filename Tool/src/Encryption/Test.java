package Encryption;

import java.io.*;
import java.util.Date;


public class Test {
    public static void main(String[] args) {



            File file = new File("C:\\Users\\12709\\Desktop\\123.txt");
            if(!file.exists()){
                try(OutputStream outKeys = new FileOutputStream("C:\\Users\\12709\\Desktop\\123.txt" , false)
                ) {
                Date date = new Date();
                long key = date.getTime();
                String string;
                string = key + "";
                outKeys.write(string.getBytes());
                outKeys.flush();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }






    }
}

