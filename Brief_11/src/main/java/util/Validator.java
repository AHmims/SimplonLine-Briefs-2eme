package util;

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
    public static Date toDate(String str){
        if(!str.equals("") && str != null){
            try {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(str);
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }else return null;
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

    //
    public static boolean isAnimal(String choix) {
        return inRange(choix, new String[]{"chat", "chien", "oiseau", "lapin", "poisson", "autre"});
    }

    //
    public static boolean isMotif(String choix) {
        return inRange(choix, new String[]{"SP", "TD", "EM", "autre"});
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
