package Client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {

    private View theView;
    //private CalculatorModel theModel;
    private ClientController client;

    public ViewController (View v,ClientController c)
    {
        theView = v;
        this.client = c;
        theView.addAddButtonListener(new AddButtonListener());
        theView.addSubButtonListener(new SubButtonListener());
        theView.addMulButtonListener(new MulButtonListener());
        theView.addDivButtonListener(new DivButtonListener());
    }

    class AddButtonListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //Send across the numbers from the input to the server
        //Receive the input from the server
        //Call the switchBoard in setting the view
        client.sendNumbers(1);
    }
    }

    class SubButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Send across the numbers from the input to the server
            //Receive the input from the server
            //Call the switchBoard in setting the view
            client.sendNumbers(2);
        }
    }

    class MulButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Send across the numbers from the input to the server
            //Receive the input from the server
            //Call the switchBoard in setting the view
            client.sendNumbers(3);
        }
    }

    class DivButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Send across the numbers from the input to the server
            //Receive the input from the server
            //Call the switchBoard in setting the view
            client.sendNumbers(4);
        }
    }


}
