package Server;
import Server.Controller.Server;

public class ServerApp {
    public static void main(String [] args){
        Server theServer = new Server();
        theServer.runServer();
    }
}
