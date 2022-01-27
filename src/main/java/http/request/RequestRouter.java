package http.request;

import http.helper.Messages;
import http.helper.Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class RequestRouter {
    public static void requestReader(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));


        Utils.print(Messages.httpReceived(reader.readLine()));
        Utils.print("output read");
        parseRequest(reader.readLine());
    }

    public static String[] parseRequest(String requestLine) {
        String[] splitData = requestLine.split(" ");
        return splitData;
    }
 public static Request buildRequest (String method, String path, String protocol) {
        Request request = new Request();
        request.setMethod(method);
        request.setPath(path);
        request.setHeaders("protocol",protocol);
        return request;

 }





//    public static void sendResponse(OutputStream output) throws IOException {
//
//        String response = formatRequestBody();
//
//        output.write(response.getBytes());
//        output.flush();
//
//    }
}


