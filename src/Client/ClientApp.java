package Client;
import Client.View.View;
import Client.Controller.ClientController;

public class ClientApp {
    public static void main(String [] args){
        View theView = new View();
        ClientController theController = new ClientController("localhost",9090,theView);
        theView.setVisible(true);
        theController.getServerResponse();
    }
}
