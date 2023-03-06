import Model.Calculator;
import View.Menu;

public class Main {
    static Calculator calculator = new Calculator();
    static Menu menu = new Menu();
    public static void main(String[] args) {
        menu.drawExpression();
    }
}