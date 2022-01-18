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
        writer.println("status: 200 OK");
    }
}
