package http.response;

import java.io.*;

import java.util.*;

public class Response {
    private OutputStream output;
    private String protocol;
    private int statusCode;
    private String statusMessage;
    private Map<String, String> headers = new HashMap();
    private byte[] body;

    public Response(OutputStream output) {
        this.output = output;

    }


    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public void setStatus(int code, String message) {
        this.statusCode = code;
        this.statusMessage = message;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void addHeaders(String key, String value) {
        this.headers.put(key, value);

    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setBody(byte[] body) {
        addHeaders("Content-Length", Integer.toString(body.length));
        this.body = body;
    }

    public byte[] getBody() {
        return this.body;
    }

    private byte[] buildResponse () throws IOException {
        headers.put("Connection", "Close");
        BuildResponse build = new BuildResponse();
        byte[] response = build.buildResponseBody(protocol, statusCode, statusMessage, headers, body);
        return response;
    }

    public void sendResponse() throws IOException {

        output.write(buildResponse());

    }


}
