package ahmims.BasmaOnlineStore.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    public static Date toDate(String str) {
        if (!str.equals("") && str != null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else return null;
    }

    //
    public static boolean isMatch(String str, String regex) {
        return str.matches(regex);
    }

    //
    public static boolean isEmail(String email) {
        return isMatch(email, "[^@]+@[^\\.]+\\..+");
    }

    //
    public static boolean isPassword(String password) {
        return password.length() >= 8;
    }

    //
    //
    private static boolean inRange(String user_choice, String[] choices) {
        try {
            boolean exists = false;
            for (String choice : choices) {
                if (user_choice.toLowerCase().equals(choice.toLowerCase())) {
                    exists = true;
                    break;
                }
            }
            //
            return exists;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
