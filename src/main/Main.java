package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");

        String string = scanner.nextLine();

        // Проверка строки на валидность
        if (Validator.isValid(string)) {
            unpack(string);
        } else {
            System.out.println("Неверный формат строки");
        }
    }

    public static void unpack(String string) {
        while (string.contains("[") && string.contains("]")) {
            int numberBeforeBracket = 0;
            int indexFirstBracket = 0;
            int indexLastBracket = 0;
            int indexNumberBeforeBracket = 0;
            String multipliedString = "";

            indexFirstBracket = string.lastIndexOf("["); // Индекс первой открытой скобки с конца
            indexLastBracket = string.indexOf(']', indexFirstBracket); // Индекс последней закрытой скобки от индекса открытой
            numberBeforeBracket = Integer.parseInt(String.valueOf(string.charAt(indexFirstBracket - 1))); // Число перед скобкой
            indexNumberBeforeBracket = indexFirstBracket - 1; // Индекс числа перед скобкой

            multipliedString = multiplyString(numberBeforeBracket, indexFirstBracket, indexLastBracket, string);
            string = replaceString(multipliedString,string, indexNumberBeforeBracket, indexLastBracket);
        }

        System.out.println(string);
    }

    // Умножение строки в скобках на число
    public static String multiplyString(int number, int start, int end,  String s) {
        String cutString = "";

        String result = "";

        for (int i = start + 1; i < end; i++) {
            cutString += s.charAt(i);
        }

        for (int j = 0; j < number; j++) {
            result += cutString;
        }
        return result;
    }

    // Замена числа со скобкой на готовый результат
    public static String replaceString(String modifiedString, String string, int startIndex, int endIndex) {
        String replacedString = "";
        for (int i = startIndex; i <= endIndex; i++) {
            replacedString += string.charAt(i);
        }
        return string.replace(replacedString, modifiedString);
    }
}