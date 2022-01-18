package http.main;

import http.server.Server;

import java.io.IOException;

public class App {
    public static Server server;
    public static Integer port = 7777;

    public static void main (String [] args) throws IOException {
       server = new Server(port);
       System.out.println(port);
       server.runServer();
    }
}
