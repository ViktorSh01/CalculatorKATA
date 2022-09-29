import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMain {
    public static void main(String[] args) throws IOException {

        Scanner calculation = new Scanner(System.in);

        System.out.println("Введите пример сост. из 2-х целых чисел или 2-х римских чисел, цифры должны быть >0 и <=10.");

        String input = calculation.nextLine();

        if(input.length() < 2){
            throw new IOException("Вы ввели некорректный пример.");
        }

        System.out.println(calc(input));
    }

    public static String calc(String input) throws IOException {

        char[] intelligence = new char[10];

        int result;

        int CovertN1, ConvertN2;

        char instrument = 0;

        for (int i = 0; i < input.length(); i++){
            switch (input.charAt(i)){
                case '+' -> instrument = '+';
                case '-' -> instrument = '-';
                case '/' -> instrument = '/';
                case '*' -> instrument = '*';
            }
        }

        String[] symbols = (" "+input+" ").split("[-+/*]");

        if (symbols.length > 2) throw new InputMismatchException("Слишком много операторов.");

        String symbol1 = symbols[0].trim();
        String symbol2 = symbols[1].trim();


        CovertN1 = romanToArab(symbol1);
        ConvertN2 = romanToArab(symbol2);

        if(CovertN1 < 0 && ConvertN2 < 0){
            result = 0;
        }
        else{
            result = calculated(CovertN1, ConvertN2, instrument);
            if(CovertN1 < ConvertN2){
                throw new IOException("У Римских чисел нет чисел <0.");
            }
            String resultRoman = convertNumToRoman(result);
            return resultRoman;
        }

        CovertN1 = Integer.parseInt(symbol1);
        ConvertN2 = Integer.parseInt(symbol2);
        result = calculated(CovertN1, ConvertN2, instrument);
        String resultArabic = "Ответ: " + result;

        return resultArabic;
    }

    private static String convertNumToRoman (int numArabian){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }

    private static int romanToArab (String roman){
        try{
            if(roman.equals("X")){
                return 10;
            }else if (roman.equals("II")){
                return 2;
            }else if (roman.equals("III")){
                return 3;
            }else if (roman.equals("IV")){
                return 4;
            }else if (roman.equals("V")){
                return 5;
            }else if (roman.equals("VI")){
                return 6;
            }else if (roman.equals("VII")){
                return 7;
            }else if (roman.equals("VIII")){
                return 8;
            }else if (roman.equals("IX")){
                return 9;
            }else if (roman.equals("I")){
                return 1;
            }
        }catch (InputMismatchException e){
            throw new InputMismatchException("Неверный формат данных.");
        }
        return -1;
    }

    public static int calculated (int n1, int n2, char instrument) throws IOException{
        int answer = 0;

        if(!(n1 > 0 && n1 <= 10 && n2 > 0 && n2 <= 10)){
            throw new IOException("Вы ввели некоректный пример.");
        }

        switch(instrument){
            case '+':
                answer = n1 + n2;;
                break;
            case '-':
                answer = n1 - n2;;
                break;
            case '/':
                answer = n1 / n2;;
                break;
            case '*':
                answer = n1 * n2;;
                break;
        }
        return answer;
    }
}
