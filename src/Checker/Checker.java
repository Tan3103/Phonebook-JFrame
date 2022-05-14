package Checker;

public class Checker {
    public boolean checkerPassword(String password) {
        int a = 0, b = 0, d = 0;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 65 && password.charAt(i) <= 90) { // password must have one capital letter
                a++;
            }
            if (password.charAt(i) >= 97 && password.charAt(i) <= 122) { // password must have one lowercase letter
                b++;
            }

            if (password.charAt(i) >= 48 && password.charAt(i) <= 57) { // password must be one digit
                d++;
            }
        }
        if (a > 0 && b > 0 && d > 0) {
            return true;
        } else {
            return false;
        }
    }
}
