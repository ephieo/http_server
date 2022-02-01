package http.helper;

import http.request.Request;
import http.response.Response;

@FunctionalInterface
public interface Handler {
 void setResponseValues(Request request, Response response);
}
