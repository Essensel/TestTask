package numHandlers;

        import java.util.HashMap;
        import java.util.TreeMap;


public class RomanNumeralHandler extends AbstractNumeralHandler {
    private static RomanNumeralHandler instance;

    private RomanNumeralHandler() {
    }

    public static RomanNumeralHandler getInstance() {
        if (instance == null) {
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
        return isCorrect;
    }

    public int getNumber(String arrayElement) {
        if (map.containsKey(arrayElement)) {
            int number = map.get(arrayElement);
            return number;
        } else
            throw new IllegalArgumentException("Калькулятор принимает на вход числа от 1 до 10 включительно, не более");
    }

    public String convertRomanToInt(double arabicNumber) {
        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        map.put(0, "0");

        int integerNumber = (int) arabicNumber;
        if (integerNumber >= 0) {
            int nearestNumber = map.floorKey(integerNumber);
            if (integerNumber == nearestNumber) {
                return map.get(integerNumber);
            }
            return map.get(nearestNumber) + convertRomanToInt(integerNumber - nearestNumber);
        } else {
            integerNumber = integerNumber * (-1);
            String minus = "-";
            int nearestNumber = map.floorKey(integerNumber);
            if (integerNumber == nearestNumber) {

                return minus + map.get(integerNumber);
            }
            return minus + map.get(nearestNumber) + convertRomanToInt(integerNumber - nearestNumber);
        }
    }
}


