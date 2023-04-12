package view;

import controller.CalculationController;
import controller.WriteController;
import model.parser.ExpressionParserService;
import model.calculator.CalculatorService;
import model.write.WriterExpressionService;

import java.util.Scanner;


public class Menu {

    private final CalculationController calculationController = new CalculationController(new CalculatorService(), new ExpressionParserService());
    private final WriteController writeController = new WriteController(new WriterExpressionService());
    public void drawExpression() throws Exception {
        Scanner scanner = new Scanner(System.in);
        Double result = null;
        int num = 0;
        while (!(num == 5)) {
            System.out.println("1. Ввести выражение: ");
            System.out.println("2. Вывести логи");
            System.out.println("3. Записать историю в файл");
            System.out.println("4. Записать отдельное уравнение в файл");
            System.out.println("5. Закрыть");
            num = scanner.nextInt();
            switch (num) {
                case (1) -> {
                    System.out.println("Введите выражение: ");
                    calculationController.setExpressionString();
                    result = calculationController.calculateTheExpression();
                    System.out.println("Результат: " + result);
                }
                case (2) -> {
                    System.out.println(calculationController.getLog().getEvents());
                    }
                case (3) -> {
                    if (result == null) {
                        System.out.println("Нечего записывать");
                    } else {
                        writeController.WriteToFile(calculationController.getLog().getEvents() + " \n");
                    }
                } case (4) -> {
                    System.out.println(calculationController.getLog().getEvents() + "\n");
                    System.out.println("Выберите выражение");
                    int expr = scanner.nextInt();
                    writeController.WriteToFile(calculationController.getLog().getEvent(expr)+ " \n");
                }
            }
        }
    }
}
