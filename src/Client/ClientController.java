package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ClientController {
    private Socket aSocket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;
    private View theView;
    private int choice;
    private Boolean isConnected = false;
    private ViewController viewController;


    /**
     * Constructor
     * @param serverName
     * @param portNumber
     * @param theView
     */
    public ClientController(String serverName, int portNumber, View theView) {
        this.theView = theView;
        try {
            aSocket = new Socket(serverName, portNumber);
            isConnected = true;
            // Socket input Stream
            socketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));

            // Socket output Stream
            socketOut = new PrintWriter(aSocket.getOutputStream(), true);
        } catch (IOException e) {
            //theView.setMessageArea("Not able to connect to server!");
            System.out.println("Not able to connect to server");
        }
        viewController = new ViewController(theView,this);
    }

    /**
     * Method to be called from ViewController on button press
     * @return
     */
    public void sendNumbers(int choice){
        /*
        Need to handle case where no number is inputted
         */
        String clientMessage = choice + "," + theView.getFirstNumber() + "," + theView.getSecNumber();
        if (clientMessage != null && !clientMessage.isEmpty()) {
            System.out.println("Sending numbers: " + theView.getFirstNumber() + "," + theView.getSecNumber());
            socketOut.println(clientMessage);
            socketOut.flush();
        }
    }

    /**
     * Constantly listening for server response
     */
    public void getServerResponse(){
        while(isConnected){
            String response = "";
            try {
                response = socketIn.readLine();
                System.out.println("Server response is: " + response);
                String [] temp = response.split(",");
                choice = Integer.parseInt(temp[0]);
            }catch(SocketException e){
                System.out.println("Socket exception!");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            //Send response to switch board only if non-null
            if(response != null){
               // switchBoard(choice, response);
                theView.setSolution(Integer.parseInt(response));
            }
        }
    }

    /**
     * SwitchBoard updates the view based on the server response.
     * @param choice
     * @param response
     */
    public void switchBoard(int choice,String response) {
        switch (choice) {
            case 1:
                //Set players
                //setPlayer(response);
                //Set name by taking the data from the GUI itself as we have received an ack from server
                //theView.setPlayerName(theView.getName());
                break;
            case 2:
                //Set player names
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
