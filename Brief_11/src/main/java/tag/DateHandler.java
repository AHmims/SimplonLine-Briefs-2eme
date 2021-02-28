package tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHandler extends TagSupport {
    private Date value;
    private String display;

    public void setValue(String value) {
        System.out.println(value);
        this.value = new Date();
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        try {
            String outStr = "";
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(this.value);
            //
            switch (this.display) {
                case "date":
                    outStr = String.format("%d/%d/%d", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
                    break;
                case "time":
                    outStr = String.format("%d:%d", calendar.get(Calendar.MINUTE), calendar.get(Calendar.HOUR_OF_DAY));
                    break;
                default:
                    outStr = "error";
            }
            out.print(outStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
