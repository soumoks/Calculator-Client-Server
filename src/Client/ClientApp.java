package Client;

public class ClientApp {
    public static void main(String [] args){
        View theView = new View();
        ClientController theController = new ClientController("localhost",9090,theView);
        theView.setVisible(true);
        theController.getServerResponse();
    }
}
