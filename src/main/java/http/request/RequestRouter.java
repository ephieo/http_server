package http.request;

import http.helper.Messages;
import http.helper.Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;


import static http.request.RequestParser.*;

public class RequestRouter {
    public static void requestReader(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        setRequestType(reader.readLine());

        Utils.print(Messages.echoReceived(reader.readLine()));
        Utils.print("output read");

    }

    public static void setupResponse() {
        setHeaders("text/html");
        setRequestBody("hello".getBytes(StandardCharsets.UTF_8));
        setStatus("200", "well done :)");
    }

    public static void sendResponse(OutputStream output) throws IOException {

        String response = formatRequestBody();

        output.write(response.getBytes());
        output.flush();

    }
}


