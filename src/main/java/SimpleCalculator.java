import numHandlers.RomanNumeralHandler;

public class SimpleCalculator {
    public static void main(String[] args) {

        LineReader ln = new LineReader();
        double input;

        System.out.println("Начало работы калькулятора!" + "\n" + "Калькулятор умеет выполнять только операции сложения, вычитания, умножения и деления с двумя числами! " +
                "Принимаются римские и арабские числа от 1 до 10!");
        System.out.println("Для выполнения операций введите данные в одну строку! ");
        while (!ln.read().equals("EXIT")) {
            input = (Calculator.performOperation(ln.getNumber1(), ln.getNumber2(), ln.getOperation()));
            if (ln.getIsRomanNumber()) {
                System.out.println("= "+RomanNumeralHandler.getInstance().convertRomanToInt(input));
            } else {
                System.out.println("= "+input);
            }
        }
    }
}

