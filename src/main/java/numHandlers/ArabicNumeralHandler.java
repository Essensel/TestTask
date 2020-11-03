package numHandlers;



import java.util.HashMap;

public class ArabicNumeralHandler extends AbstractNumeralHandler {
    private static ArabicNumeralHandler instance;

    private ArabicNumeralHandler(){
    }
    public static ArabicNumeralHandler getInstance(){
        if(instance == null){
            instance = new ArabicNumeralHandler();
        }
        return instance;
    }

    HashMap<String, Integer> map = new HashMap<String, Integer>();
    public boolean isCorrectNumber(String arrayElement) {
        boolean isCorrect = false;
        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);
        map.put("5", 5);
        map.put("6", 6);
        map.put("7", 7);
        map.put("8", 8);
        map.put("9", 9);
        map.put("10", 10);
        if (map.containsKey(arrayElement)) {
            isCorrect = true;
        }
        return isCorrect;
    }
    public int getNumber(String arrayElement) {
        int arabicNum = Integer.parseInt(arrayElement);
        if (arabicNum >= 1 && arabicNum <= 10) {
            return arabicNum;
        } else {
            throw new IllegalArgumentException("Калькулятор принимает на вход числа от 1 до 10 включительно, не более");
        }
    }
}

