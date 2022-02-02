package http.server;

import http.helper.Messages;
import http.helper.Utils;
import http.router.Router;
import http.router.SetupRouter;

import java.io.*;
import java.net.*;



public class SocketHandler {
    ServerSocket serverSocket;
    Socket clientSocket;
    Integer port;

    public SocketHandler(Integer port) {
        this.port = port;

    }

    public void createSocketConnection() throws IOException {
        try {
            this.serverSocket = createServerSocket(port);

        } catch (IOException e) {
            Utils.exitErrorMessage(Messages.cantListen(), e);

        }

        Utils.print(Messages.listeningForConnection());

        while (true) {

            try {

                this.clientSocket = acceptSocketConnection(serverSocket);
                Utils.print("open connection");

            } catch (IOException e) {
                Utils.exitErrorMessage(Messages.acceptFailed(), e);


            }
            Router router = new SetupRouter().setupRouter();
            router.makeRouterRequest(clientSocket);


            closeClientSocket(clientSocket);

        }




    }

    private void closeClientSocket(Socket clientSocket) throws IOException {
        clientSocket.close();
        Utils.print("close client connection");
    }

    private void closeServerSocket(ServerSocket serverSocket) throws IOException {
        serverSocket.close();

        Utils.print("close server connection");
    }

    private ServerSocket createServerSocket(Integer port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        return serverSocket;
    }

    private Socket acceptSocketConnection(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = serverSocket.accept();
        return clientSocket;
    }
}
