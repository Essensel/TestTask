

import numHandlers.ArabicNumeralHandler;
import numHandlers.RomanNumeralHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LineReader {
    private RomanNumeralHandler romanNumeralHandler;
    private ArabicNumeralHandler arabicNumeralHandler;
    private String userText = "";
    private int count = 0;
    private String operation = "";
    private String[] chars;
    private boolean isGoodOperationSigh = true;
    private boolean isGoodOperandsOfExpression = true;
    private int number1;
    private int number2;
    private boolean isArabicNumber;
    private boolean isRomanNumber;

    private boolean getCorrectOperationSign() {
        for (int i = 0; i < userText.length(); i++) {
            if (userText.substring(i, i + 1).equals("+") || userText.substring(i, i + 1).equals("-") || userText.substring(i, i + 1).equals("*") || userText.substring(i, i + 1).equals("/")) {
                operation = userText.substring(i, i + 1);
                count++;
                if (count > 1) {
                    isGoodOperationSigh = false;
                }
            }
        }
        return isGoodOperationSigh;
    }

    private boolean getCorrectOperandsOfExpression() {
        if (count == 1) {
            chars = userText.split("[+*/-]");
            chars[0] = chars[0].trim().toUpperCase();
            chars[1] = chars[1].trim().toUpperCase();
            count = 0;
        } else isGoodOperandsOfExpression = false;
        return isGoodOperandsOfExpression;
    }


    private boolean getCorrectNumbers(String[] chars) {
        romanNumeralHandler = RomanNumeralHandler.getInstance();
        arabicNumeralHandler = ArabicNumeralHandler.getInstance();
        isArabicNumber = true;
        isRomanNumber = true;
        for (int i = 0; i < chars.length; i++) {
            if (!romanNumeralHandler.isCorrectNumber(chars[i])) {
                isRomanNumber = false;
            }
            if (!arabicNumeralHandler.isCorrectNumber(chars[i])) {
                isArabicNumber = false;
            }
        }
        if (isArabicNumber) {
            number1 = arabicNumeralHandler.getNumber(chars[0]);
            number2 = arabicNumeralHandler.getNumber(chars[1]);
            return isArabicNumber;
        } else if (isRomanNumber) {
            number1 = romanNumeralHandler.getNumber(chars[0]);
            number2 = romanNumeralHandler.getNumber(chars[1]);
            return isRomanNumber;
        } else {
            throw new IllegalArgumentException("Внимание! Калькулятор умеет выполнять операции только с двумя арабскими или двумя римскими цифрами! от 1 до 10! " +
                    "Введите корректное выражение!");
        }
    }

    protected String read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Введите новую строку: ");
            userText = reader.readLine();
            if (getCorrectOperationSign() && getCorrectOperandsOfExpression() && getCorrectNumbers(chars)) {

            } else if (!userText.toUpperCase().equals("EXIT"))
                throw new IllegalArgumentException("Внимание! Калькулятор умеет выполнять только операции сложения, вычитания, умножения и деления с двумя числами! " +
                        "Введите корректное выражение!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userText.toUpperCase();
    }

    public String getOperation() {
        return operation;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public boolean getIsRomanNumber() {
        return this.isRomanNumber;
    }
}

