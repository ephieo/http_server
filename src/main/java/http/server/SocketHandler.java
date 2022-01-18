package http.server;
import http.helper.Messages;
import http.helper.Utils;

import java.io.*;
import java.net.*;
import java.nio.Buffer;

public class SocketHandler {
    ServerSocket serverSocket;
    Socket clientSocket;
    Integer port;

    public SocketHandler(Integer port){
        this.port = port;

    }
    public void createSocketConnection () throws IOException{
        try {
            this.serverSocket = createServerSocket(port);

        } catch (IOException e) {
            Utils.exitErrorMessage(Messages.cantListen(), e);

        }

        Utils.print(Messages.listeningForConnection());

        try {

            this.clientSocket = acceptSocketConnection(serverSocket);
            Utils.print("open connection");

        } catch (IOException e) {
            Utils.exitErrorMessage(Messages.acceptFailed(), e);


        }

        requestReader(clientSocket.getInputStream());
        sendResponse(clientSocket.getOutputStream());
        closeSocket(this.serverSocket,this.clientSocket);
        Utils.print("close connection");

    }
    public static void requestReader (InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

//        String inputLine = null;
//        while ((inputLine = reader.readLine()) != null) {
//
//            Utils.print(Messages.echoReceived(inputLine));
//
//        }
        Utils.print(Messages.echoReceived(reader.readLine()));
        Utils.print("done");

    }
    public static void sendResponse (OutputStream output){
        PrintWriter writer = new PrintWriter(output,true);
        writer.println("status: 200 OK");
    }
    private void closeSocket (ServerSocket serverSocket, Socket clientSocket) throws IOException{
        serverSocket.close();
        clientSocket.close();
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
