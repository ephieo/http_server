package http.request;

import http.helper.Messages;
import http.helper.Utils;

import java.io.*;
import java.nio.Buffer;


public class RequestParser {


    public static void requestReader(BufferedReader reader) throws IOException {

        Utils.print(Messages.httpReceived(reader.readLine()));
        Utils.print("output read");


    }


    public static String[] parseRequest(String requestLine) {
        String[] splitData = requestLine.split(" ");
        return splitData;
    }

    public static Request buildRequest(String method, String path, String protocol) {
        Request request = new Request();
        request.setMethod(method);
        request.setPath(path);
        request.setHeaders("protocol", protocol);
        return request;

    }


}


