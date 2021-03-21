package main;

public class Validator {

    public static boolean isValid(String s) {
        int checkBracket = 0;
        if (!s.matches("[a-zA-Z\\[\\]\\d]+")) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            String oneSymbol = s.substring(i, i + 1);

            if (oneSymbol.equals("[") && i == 0) {
                return false;
            }

            if (oneSymbol.equals("[") && i != 0 && !String.valueOf(s.charAt(i - 1)).matches("[\\d]")) {
                return false;
            }

            if (oneSymbol.matches("[\\d]") && i != s.length() - 1 && s.charAt(i + 1) != '[') {
                return false;
            }

            if (oneSymbol.equals("[") && i != s.length() - 1 && s.charAt(i + 1) == ']') {
                return false;
            }

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

