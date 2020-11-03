public class Calculator {

    protected static double performOperation(int num1, int num2, String operation) {
        double result = 0.0;
        if ("+".equals(operation)) {
            result = num1 + num2;
        } else if ("-".equals(operation)) {
            result = num1 - num2;
        } else if ("*".equals(operation)) {
            result = num1 * num2;
        } else if ("/".equals(operation)) {
            result = (num1) / (num2 + 0.0);
        }
        return result;
    }
}
