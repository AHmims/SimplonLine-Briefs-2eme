package util;

import beans.User;
import config.Hibernate;
import model.Apprenant;
import model.Authentification;
import model.Groupe;
import model.Promotion;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class LeBonMain {
    public static void main(String[] args) {
        SimplonLine simplonLine = new SimplonLine();
        User user = simplonLine.getUserData("youness.echchadi@gmail.com");
        System.out.println(user.getAvatarUrl());
    }
}
