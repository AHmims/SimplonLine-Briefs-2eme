package beans;

import model.Apprenant;
import model.Groupe;
import model.Promotion;
import util.Parser;

import java.util.Date;

public class Log {
    private Apprenant apprenant;
    private int action;
    private Date date;
    private String strDate;

    //
    public Log(Apprenant apprenant, int action, Date date) {
        this.apprenant = apprenant;
        this.action = action;
        this.date = date;
        this.strDate = Parser.toDateTimeString(date);
    }

    //
    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }
}
