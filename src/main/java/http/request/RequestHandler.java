package http.request;

import http.helper.Messages;
import http.helper.Utils;

import java.io.*;

public class RequestHandler {
    public static void requestReader(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        Utils.print(Messages.echoReceived(reader.readLine()));
        Utils.print("done");

    }

    public static void sendResponse(OutputStream output) {
        PrintWriter writer = new PrintWriter(output, true);
        writer.println(
                "HTTP/1.1 200 OK\n" +
                "Date: Mon, 27 Jul 2009 12:28:53 GMT\n" +
                "Server: Apache/2.2.14 (Win32)\n" +
                "Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT\n" +
                "Content-Length: 777\n" +
                "Content-Type: text/html\n" +
                "Connection: Closed"
        );

    }
}


