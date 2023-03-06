package Model;

public class Calculator implements MathematicsOperations {

    @Override
    public Double Sum(double a, double b) {
        return a+b;
    }

    @Override
    public Double Sub(double a, double b) {
        return a-b;
    }

    @Override
    public Double Multiple(double a, double b) {
        return a*b;
    }

    @Override
    public Double Div(double a, double b) {
        return a/b;
    }

}
