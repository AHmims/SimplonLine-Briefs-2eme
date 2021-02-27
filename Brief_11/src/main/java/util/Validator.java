package util;

public class Validator {
    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0)
            return false;
        try {
            double d = Double.parseDouble(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //
    public static boolean isAlpha(String str) {
        return str.matches("[a-zA-Z]+");
    }

    //
    public static boolean isMatch(String str, String regex) {
        return str.matches(regex);
    }

    //
    public static boolean isFormValid(String nom, String prenom, String email, String pass, String passCon) {
        try {
            boolean isValid = true;
            //
            if (!isAlpha(nom) && nom.length() < 2)
                isValid = false;
            if (!isAlpha(prenom) && prenom.length() < 2)
                isValid = false;
            if (!isMatch(email, "[^@]+@[^\\.]+\\..+"))
                isValid = false;
            //
            if (pass.length() < 8)
                isValid = false;
            if (!pass.equals(passCon))
                isValid = false;
            //
            return isValid;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
