package http.request;


import java.io.BufferedReader;
import java.io.IOException;


public class RequestParser {

    private BufferedReader reader;

    public RequestParser(BufferedReader reader) {
        this.reader = reader;
    }

    public Request buildRequest() throws IOException {
        Request request = new Request();
        parseRequestLine(request);
        parseHeadersLine(request);
        parseBodyLine(request);
        return request;

    }

   private void parseRequestLine(Request request) throws IOException {
        String[] splitData = (reader.readLine()).split(" ");
        request.setMethod(splitData[0]);
        request.setPath(splitData[1]);
        request.setProtocol(splitData[2]);
    }



    private void parseHeadersLine (Request request) throws IOException {
        String headers;
        if((headers = reader.readLine()) != null){
            while ((headers = reader.readLine()).length() > 0){
                String[] combineHeaders = headers.split(": ");
                request.setHeaders(combineHeaders[0],combineHeaders[1]);
            }
        }
    }

    private void parseBodyLine (Request request) throws IOException{
        String contentLengthKey = request.getHeaders().get("Content-Length");
         if(contentLengthKey != null) {
             int contentLength = Integer.parseInt(contentLengthKey);
             char[] destinationBuffer = new char[contentLength];

             reader.read(destinationBuffer,0,contentLength);
             String parsedBody = new String(destinationBuffer,0,contentLength);
             request.setBody(parsedBody);


         }

    }


}


