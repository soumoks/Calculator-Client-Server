package Server;

public class Model {

    /**
     * Default constructor
     */
    public Model(){};
    /*
    Add checks in each method
     */

    public int addTwoNumbers (int a, int b)
    {
        return a+b;
    }
    public int subTwoNumbers (int a, int b)
    {
        return a-b;
    }
    public int mulTwoNumbers (int a, int b)
    {
        return a*b;
    }

    public int divTwoNumbers (int a, int b) {
        try{
            return a/b;
        }catch (ArithmeticException e){
            return 0;
        }
    }
}
