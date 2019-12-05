package Homework2;

public class Main {

    public static void main(String[] args) {

        /*  via default constructor and setters  */
        Equation equation1 = new Equation();

        equation1.setA(1);
        equation1.setB(-2);
        equation1.setC(1);
        equation1.solve();



        /*  via custom constructor  */
        Equation equation2 = new Equation(1, 4, -5);
        equation2.solve();
    }
}
