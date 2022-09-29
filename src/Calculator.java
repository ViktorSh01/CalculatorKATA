import java.util.Scanner;

public class Calculator{
    public static void main(String[] args){

        Scanner calculation = new Scanner(System.in);

        System.out.println("Введите пример сост. из 2-х целых чисел или 2-х римских чисел, цифры должны быть >0 и <=10.");

        String input = calculation.nextLine();

        System.out.println(calc(input));


    }
    public static String calc(String input){ // в параметре задаем новую строку с именем input

        String[] intelligence = new String[1];// создаем массив строк с 2-мя ячейками [0][1]

        String answer = null;// задаем новую строку и именем answer и присваеваем ей нулевое значение

        String instrument = null; // задаем новую строку и именем instrument и присваеваем ей нулевое значение

        if(input.contains("+")){ // создаем оператор if и с его помощью определяем математический знак для строки instrument
            instrument = "+";
        }else if(input.contains("-")){
            instrument = "-";
        }else if(input.contains("/")){
            instrument = "/";
        }else if(input.contains("*")){
            instrument = "*";
        }

        intelligence = input.split("[-+/*]"); // задаем математические инструменты которые могут использоваться в программе

        if (intelligence.length > 2){ // если длина введенного примера привышает 3 значения (должна быть 1 цифра, 1 мат. инструмент,
            return "Введено лишнее число.";//                               1 цифра) то выдаем ошибку и прекращаем работу программы.
        }

        int n1 = Integer.parseInt(intelligence[0]),n2 = Integer.parseInt(intelligence[1]); // создаем 2 тд int которые помещаются в строчный массив

        if (n1 > 0 && n1 <= 10 && n2 > 0 && n2 <= 10) { // if который помогает нам выдавать ошибку если числа <1 или >10

            switch (instrument) { // switch выполняет +-.* в зависимости от того, что мы введем в панель
                case "+":
                    answer = (n1 + n2) + " ";
                    break;
                case "-":
                    answer = (n1 - n2) + " ";
                    break;
                case "/":
                    answer = (n1 / n2) + " ";
                    break;
                case "*":
                    answer = (n1 * n2) + " ";
                    break;
            }

        }else {System.out.println("Ты ввел число <1 или >10");}


        if (n1>0 && n2>0 && n1<=10 && n2<=10){ //возвращает ответ на введенный пример из метода switch
            return "Ответ: " + answer;
        }else{                                 // в ином случае выдает ошибку
            return "Перезапусти программу.";
        }


    }
}

