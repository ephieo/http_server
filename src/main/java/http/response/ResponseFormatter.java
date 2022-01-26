package http.response;

import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ResponseFormatter {
    private int statusCode;
    private String statusMessage;
    private Map<String, String> headers;
    private byte[] body;

    public void ResponseFormatter( int statusCode, String statusMessage, HashMap<String, String> headers, byte[] body) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.headers = headers;
        this.body = body;
    }

    public String buildResponse (){
        String bytes = new String(this.body, StandardCharsets.UTF_8);
        String formattedRequest =
                "Content-Type: " + this.headers.get("Content-Type") + "\n"
                + "Content-Length: " + this.body.toString().length() + "\n"
                + "Body{ " + "\n" + bytes + "\n" + "}";
        return formattedRequest;
    }
}
