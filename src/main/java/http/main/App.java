package http.main;

import http.server.Server;

import java.io.IOException;

public class App {
    public static Server server;
    public static Integer port = 5000;

    public static void main (String [] args) throws IOException {
       server = new Server(port);
       server.runServer();
    }
}
