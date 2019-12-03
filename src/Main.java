public class Main {

    public static void main(String[] args) {
        Equation equation = new Equation();

        equation.solve(1, 4, -5); // 2 solves
        equation.solve(1, -2, 1); // 1 solve
        equation.solve(5, 5, 5); // no solves
        equation.solve(0, 10, 10);// not quadratic equation
    }
}
