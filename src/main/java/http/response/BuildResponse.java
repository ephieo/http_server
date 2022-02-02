package http.response;

public class BuildResponse {
    public byte[] buildStartLine(String protocol, int statusCode, String statusMessage) {
        return (protocol + " " + statusCode + " " + statusMessage + "\n\r").getBytes();
    }

    public byte[] parseHeaderLine(String headerKey, String headerValue) {
        return (headerKey + " " + ":" + " " + headerValue + "\n\r").getBytes();
    }

}
