package Encryption;

import org.junit.Test;

import java.io.*;
import java.util.Date;
import java.util.function.LongPredicate;

public class Encryption1 {

    @Test
    public void encryption(){
        File file3 = new File("C:\\Users\\12709\\Desktop\\key.txt");
        if(!file3.exists()){
            try(OutputStream outKeys = new FileOutputStream("C:\\Users\\12709\\Desktop\\key.txt" , false)
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


        File file = new File("C:\\Users\\12709\\Desktop\\1.mp4");
        File file2 = new File("C:\\Users\\12709\\Desktop\\1_bak.mp4");
        try(InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(file2)

            ) {
            byte[] bytes = new byte[1024 * 1024];
            int length = -1;
            while((length = inputStream.read(bytes)) != -1){
                lock(bytes , getKey());
                outputStream.write(bytes , 0 , length);
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        file.delete();
        file2.renameTo(new File("C:\\Users\\12709\\Desktop\\1.mp4"));
    }
    public static byte[] lock(byte[] bytes , long key){
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= key;
        }
        return bytes;
    }
    public static long getKey(){

        long key = 0;
        try (Reader reader = new FileReader("C:\\Users\\12709\\Desktop\\key.txt")) {

            char[] array = new char[1024];

            int length = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((length = reader.read(array)) != -1) {
                String str = new String(array, 0, length);
                stringBuilder.append(str);
            }
            String s = stringBuilder+"";
            key += Long.parseLong(s);


        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return key;

    }

}
