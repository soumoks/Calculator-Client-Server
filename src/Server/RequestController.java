package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestController implements Runnable {
    private Socket aSocket;
    private PrintWriter aSocketOut;
    private BufferedReader aSocketIn;
    private Model theModel;

    public RequestController(Socket socket,Model model) throws IOException {
        this.aSocket = socket;
        this.theModel = model;
        aSocketOut = new PrintWriter(aSocket.getOutputStream(),true);
        aSocketIn = new BufferedReader(new InputStreamReader(aSocket.getInputStream()));
    }
    @Override
    public void run() {
        try {
            getClientData();
        } catch (IOException e) {
            //e.printStackTrace();
            //Close socket connections if this exception occurs
            System.out.println("Closing client connection..");
            aSocketOut.close();
            try {
                aSocketIn.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                aSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Client data is in the format "choice" + "," + "firstNumber" + "," + "secondNumber"
     * @throws IOException
     */
    public void getClientData() throws IOException {
        while(true){
            String clientData = "";
            clientData = aSocketIn.readLine();
            if(clientData != null){
                String [] temp = clientData.split(",");
                switchBoard(Integer.parseInt(temp[0]),Integer.parseInt(temp[1]),Integer.parseInt(temp[2]));
            }
        }
    }


    public void switchBoard(int choice,int firstNum,int secondNum){
        switch (choice){
            //Addition
            case 1:
                sendServerResponse(theModel.addTwoNumbers(firstNum,secondNum));
                break;
                //Subtraction
            case 2:
                sendServerResponse(theModel.subTwoNumbers(firstNum,secondNum));
                break;
                //Multiplication
            case 3:
                sendServerResponse(theModel.mulTwoNumbers(firstNum,secondNum));
                break;
                //Division
            case 4:
                sendServerResponse(theModel.divTwoNumbers(firstNum,secondNum));
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    /**
     * Helper method for sending serverResponse
     * @param serverResponse
     */
    public void sendServerResponse(int serverResponse){
        System.out.println("Sending server response: " + serverResponse);
        aSocketOut.println(serverResponse);
        aSocketOut.flush();
    }

}
