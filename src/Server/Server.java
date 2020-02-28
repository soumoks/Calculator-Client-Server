package Server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private Socket aSocket;
    private ServerSocket serverSocket;
    private ExecutorService pool;
    private Model theModel;

    public Server() {
        try {
            // Server socket accepts the port as a parameter
            serverSocket = new ServerSocket(9090);
            theModel = new Model();
            System.out.println("Server is running!");
            pool = Executors.newFixedThreadPool(20);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runServer() {
        try {
            while (true) {
                aSocket = serverSocket.accept();
                System.out.println("Accepted connection..");
                RequestController requestController = new RequestController(aSocket,theModel);
                pool.execute(requestController);
            }

        }catch (SocketException e) {
            System.out.println("Socket exception!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
