package numHandlers;

import java.util.HashMap;


public class RomanNumeralHandler extends AbstractNumeralHandler {
    private static RomanNumeralHandler instance;

    private RomanNumeralHandler(){
    }
    public static RomanNumeralHandler getInstance(){
        if(instance == null){
            instance = new RomanNumeralHandler();
        }
        return instance;
    }

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public boolean isCorrectNumber(String arrayElement) {
        boolean isCorrect = false;
        map.put("I", 1);
        map.put("II", 2);
        map.put("III", 3);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("VI", 6);
        map.put("VII", 7);
        map.put("VIII", 8);
        map.put("IX", 9);
        map.put("X", 10);
        if (map.containsKey(arrayElement)) {
            isCorrect = true;
        }
        return isCorrect;}

    public int getNumber(String arrayElement) {
        if(map.containsKey(arrayElement)){
            int number = map.get(arrayElement);
            return number;} else
        throw new IllegalArgumentException("Калькулятор принимает на вход числа от 1 до 10 включительно, не более");
    }
}

