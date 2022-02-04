package http.response;

import http.helper.Utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class BuildResponse {

    public byte[] buildResponseBody(String protocol, int statusCode, String statusMessage, Map<String, String> headers, byte[] body) throws IOException {
        ByteArrayOutputStream buildResponse = new ByteArrayOutputStream();

        buildResponse.write(buildHeaderLine(buildStartLine(protocol, statusCode, statusMessage), headers));
        Utils.print("Whole response minus body " + new String(buildHeaderLine(buildStartLine(protocol, statusCode, statusMessage), headers), StandardCharsets.UTF_8));
        if (body != null) {
            buildResponse.write(body);
        }
        Utils.print("byte array === "+new String(buildResponse.toByteArray(), StandardCharsets.UTF_8));
        return buildResponse.toByteArray();

    }

    public byte[] buildStartLine(String protocol, int statusCode, String statusMessage) {
        return (protocol + " " + statusCode + " " + statusMessage + "\n\r").getBytes();
    }

    public String parseHeaderLine(String headerKey, Map<String, String> headerValue) {
        return headerKey + " " + ":" + " " + headerValue.get(headerKey) + "\n\r";
    }

    public byte[] buildHeaderLine(byte[] startLine, Map<String, String> headers) throws IOException {
        ByteArrayOutputStream bodyBuilder = new ByteArrayOutputStream();
        bodyBuilder.write(startLine);
        Utils.print(new String(startLine, StandardCharsets.UTF_8));


        StringBuilder formattedHeaderLine = new StringBuilder();


        for (String key : headers.keySet()) {
            Utils.print("In for loop ==== " + new String(parseHeaderLine(key, headers).getBytes(), StandardCharsets.UTF_8));

            formattedHeaderLine.append(parseHeaderLine(key, headers));
        }

        bodyBuilder.write(formattedHeaderLine.toString().getBytes());
        Utils.print(new String(formattedHeaderLine.toString().getBytes(), StandardCharsets.UTF_8));

        return bodyBuilder.toByteArray();
    }

}
