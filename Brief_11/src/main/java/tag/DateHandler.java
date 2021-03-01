package tag;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;;
import java.io.IOException;
import java.util.*;

public class DateHandler extends TagSupport {
    private Date date;
    private String value;
    private String display;

    public void setValue(String value) {
        this.value = value;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public int doStartTag() throws JspException {
        date = (Date) ExpressionEvaluatorManager.evaluate("value", value, java.util.Date.class, this, pageContext);
        if (value == null)
            return SKIP_BODY;
        JspWriter out = pageContext.getOut();
        try {
            String outStr = "";
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(this.date);
            //
            switch (this.display) {
                case "date":
                    outStr = String.format("%d/%d/%d", calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
                    break;
                case "time":
                    outStr = String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
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
