package main;

public class Validator {

    public static boolean isValid(String s) {
        int checkBracket = 0;
        // Проверка строки на разрешенные символы
        if (!s.matches("[a-zA-Z\\[\\]\\d]+")) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String oneSymbol = s.substring(i, i + 1);

            // Первый символ не '['
            if (oneSymbol.equals("[") && i == 0) {
                return false;
            }

            // Перед скобкой есть цмфра
            if (oneSymbol.equals("[") && i != 0 && !String.valueOf(s.charAt(i - 1)).matches("[\\d]")) {
                return false;
            }

            // После цифры есть '['
            if (oneSymbol.matches("[\\d]") && i != s.length() - 1 && s.charAt(i + 1) != '[') {
                return false;
            }

            // Скобки не пустные
            if (oneSymbol.equals("[") && i != s.length() - 1 && s.charAt(i + 1) == ']') {
                return false;
            }

            // Проверка на правильность скобочной последовательности
            if (oneSymbol.equals("[")){
                checkBracket++;
            } else if (oneSymbol.equals("]")){
                checkBracket--;
            }

            if (checkBracket < 0) {
                return false;
            }
        }

        return checkBracket == 0;
    }
}

