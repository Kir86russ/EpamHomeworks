package Homework2;

public class Equation {

    private float a;
    private float b;
    private float c;

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getC() {
        return c;
    }

    public void setC(float c) {
        this.c = c;
    }

    Equation(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Equation() {
    }

    void solve() {
        float discriminant = getDiscriminant(getA(), getB(), getC());
        boolean hasRealSolve = (getA() != 0);
        if (hasRealSolve) {
            if (discriminant > 0) {
                float x1, x2;
                x1 = (float) ((-getB() - Math.sqrt(discriminant)) / 2 * getA());
                x2 = (float) ((-getB() + Math.sqrt(discriminant)) / 2 * getA());
                getResult(getA(), getB(), getC(), x1, x2);
            } else if (discriminant == 0) {
                float x;
                x = (-getB() / 2 * getA());
                getResult(getA(), getB(), getC(), x);
            } else {
                System.out.println("Equation has not valid solutions!" + "\n");
            }
        } else System.out.println("Equation is not quadratic!" + "\n");
    }

    private float getDiscriminant(float a, float b, float c) {
        return getB() * getB() - 4 * getA() * getC();
    }

    private void getResult(float a, float b, float c, float... x) {
        System.out.println("Equation: " + getA() + "*x^2 + " + getB() + "*x + " + getC() + " = 0");
        if (x.length == 2)
            System.out.println("Equation has solutions: " + "x1 = " + x[0] + "; x2 = " + x[1] + "\n");
        else
            System.out.println("Equation has solution: " + "x = " + x[0] + "\n");
    }
}