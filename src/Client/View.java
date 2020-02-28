package Client;
import java.awt.event.ActionListener;
import javax.swing.*;

public class View extends JFrame{


    private JTextField firstNumber = new JTextField(10);
    private JLabel addLabel = new JLabel ("+");

    /*
    Buttons for different functionality
     */
    private JButton addButton = new JButton("Add");
    private JButton subButton = new JButton("Subtract");
    private JButton mulButton = new JButton("Multiply");
    private JButton divButton = new JButton("Divide");

    private JTextField secondNumber = new JTextField(10);
    private JButton calculateButton = new JButton ("Calculate");

    private JTextField solution = new JTextField(10);

    View(){
        JPanel calcPanel = new JPanel ();
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calcPanel.add(firstNumber);
    //    calcPanel.add(addLabel);
        calcPanel.add(secondNumber);
    //    calcPanel.add(calculateButton);
        calcPanel.add(addButton);
        calcPanel.add(subButton);
        calcPanel.add(mulButton);
        calcPanel.add(divButton);
        calcPanel.add(solution);

        this.add(calcPanel);
    }
    public int getFirstNumber ()
    {
        return Integer.parseInt(firstNumber.getText());
    }
    public int getSecNumber ()
    {
        return Integer.parseInt(secondNumber.getText());
    }
    public void setSolution (int sol)
    {
        solution.setText(Integer.toString(sol));
    }
    public void addCalcListener (ActionListener listenForCalcButton)
    {
        calculateButton.addActionListener(listenForCalcButton);
    }

    public void addAddButtonListener(ActionListener listenForAddButton){
        addButton.addActionListener(listenForAddButton);
    }

    public void addSubButtonListener(ActionListener listenForSubButton){
        subButton.addActionListener(listenForSubButton);
    }

    public void addMulButtonListener(ActionListener listenForMulButton){
        mulButton.addActionListener(listenForMulButton);
    }

    public void addDivButtonListener(ActionListener listenForDivButton){
        divButton.addActionListener(listenForDivButton);
    }

    void displayErrorMessage (String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage);
    }



}
