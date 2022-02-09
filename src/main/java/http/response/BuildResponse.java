package http.response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.util.*;

public class BuildResponse {

    public byte[] buildResponseBody(String protocol, int statusCode, String statusMessage, Map<String, String> headers, byte[] body) throws IOException {
        ByteArrayOutputStream buildResponse = new ByteArrayOutputStream();

        try {
            buildResponse.write(buildHeaderLine(buildStartLine(protocol, statusCode, statusMessage), headers));
            if (body != null) {
                buildResponse.write(body);
            }


        } catch (IOException err) {
            throw new RuntimeException();
        }
        return buildResponse.toByteArray();

    }

    public byte[] buildStartLine(String protocol, int statusCode, String statusMessage) {
        return (protocol.split("/")[0] + "/" + protocol.split("/")[1] + " " + statusCode + " " + statusMessage + "\r\n").getBytes();
    }

    public String parseHeaderLine(String headerKey, Map<String, String> headerValue) {
        return headerKey + ":" + " " + headerValue.get(headerKey) + "\r\n";
    }

    public byte[] buildHeaderLine(byte[] startLine, Map<String, String> headers) throws IOException {
        ByteArrayOutputStream bodyBuilder = new ByteArrayOutputStream();
        bodyBuilder.write(startLine);


        StringBuilder formattedHeaderLine = new StringBuilder();


        for (String key : headers.keySet()) {
            formattedHeaderLine.append(parseHeaderLine(key, headers));
        }

        bodyBuilder.write(formattedHeaderLine.toString().getBytes());
        bodyBuilder.write("\r\n".getBytes());


        return bodyBuilder.toByteArray();
    }

}
