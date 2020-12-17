import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//
public class Quiz {
    private static Serie serie = new Serie();
    //
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz");
        //frame.setPreferredSize(new Dimension(400, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        JPanel root = new JPanel(new GridLayout(2, 1));
        frame.setContentPane(root);
        //
        JPanel form = new JPanel(new GridLayout(4, 1));
        //form.setPreferredSize(new Dimension(400,300));
        int _pos = 0;
        fillForm(form, 1, _pos);
        root.add(form);
        //
        JPanel extra = new JPanel(new GridLayout(1, 3, 0, 0));
        JLabel timer = new JLabel("*");
        extra.add(timer);
        timer.setText("yuh");
        JLabel progress = new JLabel("1/15");
        extra.add(progress);
        JButton btnNext = new JButton("Suivant");
        root.add(extra);
        //
        frame.pack();
        frame.setVisible(true);
    }

    //

    //
    public static void fillForm(JPanel form, int niv, int pos) {
        form.removeAll();
        Niveau niveau = serie.getQuestion(niv,pos);
        form.add(new JLabel(niveau.getQuestion()));
        ButtonGroup grp = new ButtonGroup();
        for (int i = 0; i < niveau.getReponse().length; i++) {
            JRadioButton option = new JRadioButton(niveau.getReponse()[i]);
            grp.add(option);
            form.add(option);
        }
    }

    //
}
