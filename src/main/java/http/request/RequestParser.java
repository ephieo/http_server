package http.request;



import java.nio.charset.StandardCharsets;
import java.util.*;

public class RequestParser {
    public static String startLine;
    public static HashMap<String, String> headers = new HashMap<>();
    public static String statusCode;
    public static String statusMessage;
    public static byte[] requestBody ;

    public static void setRequestType(String requestData) {
        System.out.println(requestData);
        startLine = requestData;

    }
    public static String getRequestType  (){

        String[] splitData =  startLine.split("/");

        return splitData[0].trim();
    }
    public static String getStartLine() {
        System.out.println(startLine);
        return startLine;
    }

    public static void setHeaders( String value) {
        headers.put("Content-Type", value);
    }

    public static HashMap<String, String> getHeaders() {

        return headers;
    }

    public static void setRequestBody(byte[] body) {
        requestBody = body;
    }

    public static String getRequestBody() {
        String parsedBody = new String(requestBody, StandardCharsets.UTF_8);
        return parsedBody;

    }

    public static void setStatus(String code, String message) {
        statusCode = code;
        statusMessage = message;

    }

    public static String getStatusCode() {
        return statusCode;
    }

    public static String getStatusMessage() {
        return statusMessage;
    }

    public static String formatRequestBody() {
        String formattedRequest = startLine + "\n"
                + "Content-Type: " + headers.get("Content-Type") + "\n"
                + "Content-Length: " + requestBody.toString().length() + "\n"
                + "Body{ " + "\n" + requestBody + "\n" + "}";
        return formattedRequest;
    }


}
