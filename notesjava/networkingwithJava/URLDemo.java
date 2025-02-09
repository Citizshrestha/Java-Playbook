package notesjava.networkingwithJava;

import java.io.InputStream;
import java.io.IOException;  // Added import for IOException
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class URLDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.foliagesoft.com");
            URLConnection ucon = url.openConnection();

            // Get Date
            long d = ucon.getDate();
            if (d == 0) 
                System.out.println("No date info");
            else 
                System.out.println("Date: " + new Date(d));

            // Get content type 
            System.out.println("Content-Type: " + ucon.getContentType());

            // Get expiration date
            d = ucon.getExpiration();
            if (d == 0) 
                System.out.println("No expiration info");
            else 
                System.out.println("Expires: " + new Date(d));

            // Get Last Modified date
            d = ucon.getLastModified();
            if (d == 0) 
                System.out.println("No last modification info");
            else 
                System.out.println("Last Modified: " + new Date(d));

            // Get content length
            int len = ucon.getContentLength();
            if (len == -1) 
                System.out.println("Content length unavailable");
            else 
                System.out.println("Content-length: " + len);

            // Read and print content
            if (len != 0) {
                System.out.println(" === Content  === ");
                InputStream input = ucon.getInputStream();
                
                int c;
                while ((c = input.read()) != -1) {
                    System.out.print((char) c); // Changed println to print to avoid new lines
                }
                input.close();
            } else {
                System.out.println("No content available");
            }
        } catch (IOException e) {  // Catching IO exceptions
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
