package http.helper;

import java.io.IOException;

public class Utils {
    public static void print (String text){
        System.out.println(text);
    }
    public static void exitErrorMessage(String message, IOException e) {
        print(message + e);
        System.exit(1);
    }
}
