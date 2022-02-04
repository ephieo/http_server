package http.response;

import java.util.*;

public class BuildResponse {
    public byte[] buildStartLine(String protocol, int statusCode, String statusMessage) {
        return (protocol + " " + statusCode + " " + statusMessage + "\n\r").getBytes();
    }

    public String parseHeaderLine(String headerKey, String headerValue) {
        return headerKey + " " + ":" + " " + headerValue + "\n\r";
    }

    public byte[] buildHeaderLine(Map<String, String> headers) {
        StringBuilder formattedHeaderLine = new StringBuilder();
        Set<String> headersList = headers.keySet();

        for (String key : headersList) {

            formattedHeaderLine.append(parseHeaderLine(key, headers.get(key)));
        }

        return formattedHeaderLine.toString().getBytes();
    }

}
