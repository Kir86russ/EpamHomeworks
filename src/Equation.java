public class Equation {
    void solve(float a, float b, float c) {
        float discriminant = getDiscriminant(a, b, c);
        if (a != 0) {
            if (discriminant > 0) {
                float x1, x2;
                x1 = (float) ((-b - Math.sqrt(discriminant)) / 2 * a);
                x2 = (float) ((-b + Math.sqrt(discriminant)) / 2 * a);
                getResult(a, b, c, x1, x2);
            } else if (discriminant == 0) {
                float x;
                x = (-b / 2 * a);
                getResult(a, b, c, x);
            } else {
                System.out.println("Equation has not valid solutions!" + "\n");
            }
        } else System.out.println("Equation is not quadratic!" + "\n");
    }

    private float getDiscriminant(float a, float b, float c) {
        return b * b - 4 * a * c;
    }

    private void getResult(float a, float b, float c, float... x) {
        System.out.println("Equation: " + a + "*x^2 + " + b + "*x + " + c + " = 0");
        if (x.length == 2)
            System.out.println("Equation has solutions: " + "x1 = " + x[0] + "; x2 = " + x[1] + "\n");
        else
            System.out.println("Equation has solution: " + "x = " + x[0] + "\n");
    }
}