package http.server;


import http.helper.Messages;
import http.helper.Utils;

import java.io.IOException;

public class Server {


    Integer port;
    SocketHandler socketHandler;

    public Server (Integer port){
     this.port = port;
    }

    public void runServer() throws IOException{

        try {
            this.socketHandler = new SocketHandler(port);
            socketHandler.createSocketConnection();

        } catch (IOException e) {
            Utils.exitErrorMessage(Messages.cantListen(), e);

        }
    }

}
