package StreamsFilesAndDirectories.Exercises;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAPicture {
    public static void main(String[] args) {

        try(FileInputStream input = new FileInputStream("C:\\Users\\TuberG_\\AppData\\Local\\Temp.download.jpg");
            FileOutputStream output = new FileOutputStream("src/Resources/picture-copy.jpg")){

            byte[] buffer = new byte[1024];

            int byt = input.read();

            for (int i = 0; i < buffer.length; i++) {
                if (byt == -1){
                    break;
                }
                buffer[i] = (byte) byt;
                System.out.println(Integer.toBinaryString(byt));

                byt = input.read();
            }

            output.write(buffer);
        }catch (IOException ignored){
        }
    }
}
