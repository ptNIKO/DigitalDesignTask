package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");

        String string = scanner.nextLine();

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

            indexFirstBracket = string.lastIndexOf("[");
            indexLastBracket = string.indexOf(']', indexFirstBracket);
            numberBeforeBracket = Integer.parseInt(String.valueOf(string.charAt(indexFirstBracket - 1)));
            indexNumberBeforeBracket = indexFirstBracket - 1;
            multipliedString = multiplyString(numberBeforeBracket, indexFirstBracket, indexLastBracket, string);
            string = replaceString(multipliedString,string, indexNumberBeforeBracket, indexLastBracket);
        }

        System.out.println(string);
    }

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

    public static String replaceString(String modifiedString, String string, int startIndex, int endIndex) {
        String replacedString = "";
        for (int i = startIndex; i <= endIndex; i++) {
            replacedString += string.charAt(i);
        }
        return string.replace(replacedString, modifiedString);
    }
}