package http.request;

import http.helper.Messages;
import http.helper.Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RequestHandler {
    public static void requestReader(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        Utils.print(Messages.echoReceived(reader.readLine()));
        Utils.print("output read");

    }

    public static void sendResponse(OutputStream output) throws IOException {
        String CRNL = "\r\n";
        String response = "HTTP\\/" + "/1.1" + " " + "200" + " " + "OK" + CRNL;

        output.write(response.getBytes());
        output.flush();


    }
}


