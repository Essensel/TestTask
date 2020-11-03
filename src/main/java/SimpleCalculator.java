
public class SimpleCalculator{
    public static void main(String[] args) {
        LineReader ln = new LineReader();
        Calculator calculator = new Calculator();
        System.out.println("Начало работы калькулятора!"+"\n"+ "Калькулятор умеет выполнять только операции сложения, вычитания, умножения и деления с двумя числами! " +
                "Принимаются римские и арабские числа от 1 до 10!" );
        System.out.println("Для выполнения операций введите данные в одну строку! ");
        while (!ln.read().equals("EXIT")) {
            ln.read();
        }
    }
}

