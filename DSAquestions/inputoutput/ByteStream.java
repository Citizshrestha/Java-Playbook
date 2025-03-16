package letsgoDSA.inputoutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStream {
    public static void main(String[] args) {
      try{
        FileInputStream in = new FileInputStream("input.text");
        FileOutputStream out = new FileOutputStream("output.txt");
        int c;
        while ((c = in.read())!= -1) {
          out.write(c);
        }
        in.close();
        out.close();
        System.out.println("File copied successfully");
      } catch(IOException e){
        System.err.println("Error copying file" + e.getMessage());
      }
    }

}
