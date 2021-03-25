package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
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
        if (!str.equals("")) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else return null;
    }

    //
    public static String toDateString(Date date) {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    //
    public static String toDateTimeString(Date date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy hh:mm").format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
