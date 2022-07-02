//package calcRA;

import java.util.FormatFlagsConversionMismatchException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean isRoman = true;
    static Scanner scanner = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;

    public static void main (String[] args) throws Exception {
        System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
//      Считываем строку userInput которую ввёл пользователь
        String userInput = scanner.nextLine();
//      Создаём пустой символьный массив длиной 10 символов:  under_char
        char[] under_char = new char[10];
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        for (int i = 0; i < userInput.length(); i++) {
            under_char[i] = userInput.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String[] blacks = userInput.split("[+-/*]");
        if (blacks.length > 2){
            throw new Exception("fffff");
        }
        num1 = romanToNumber(blacks[0]);
        num2 = romanToNumber(blacks[1]);
        if (num1 == -1 || num2 == -1) {
            throw new Exception("3432434343434");
        }

        result = calculated(num1, num2, operation);
        if (isRoman) {
            System.out.println(blacks[0]+ " " + operation + " " + blacks[1] + " = " + convertNumToRoman(result));
        }else {
            System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
        }
    }

    private static String convertNumToRoman (int numArabian) {
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

    private static int romanToNumber (String roman) {
        try {

            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }

            isRoman = false;

            if (roman.equals("1")) {
                return 1;
            } else if (roman.equals("2")) {
                return 2;
            } else if (roman.equals("3")) {
                return 3;
            } else if (roman.equals("4")) {
                return 4;
            } else if (roman.equals("5")) {
                return 5;
            } else if (roman.equals("6")) {
                return 6;
            } else if (roman.equals("7")) {
                return 7;
            } else if (roman.equals("8")) {
                return 8;
            } else if (roman.equals("9")) {
                return 9;
            } else if (roman.equals("10")) {
                return 10;
            }

        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e ) {
                    System.out.println("Исключения : " + e);
                    System.out.println("Допускаются только целочисленные ненулевые параметры");

                    break;
                }

                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}