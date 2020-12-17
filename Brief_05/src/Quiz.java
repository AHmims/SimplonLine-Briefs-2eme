import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

//
public class Quiz {
    private static Serie serie = new Serie();
    private static int points = 0;
    private static ArrayList<Integer> results = new ArrayList<Integer>();
    private static JLabel progress;
    private static JLabel pointsC;
    private static JLabel niveauI;
    //
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz");
        //frame.setPreferredSize(new Dimension(400, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        JPanel root = new JPanel();
        frame.setContentPane(root);
        //
        JPanel form = new JPanel(new GridLayout(5, 1));
        //form.setPreferredSize(new Dimension(400,300));
        int _pos = 0;
        fillForm(form, 1, _pos);
        root.add(form);
        //
        JPanel extra = new JPanel();
        JLabel timer = new JLabel("0");
        extra.add(timer);
        progress = new JLabel("Progress : 1/15");
        pointsC = new JLabel("Points : 0");
        niveauI = new JLabel("Niveau 1");
        extra.add(progress);
        extra.add(pointsC);
        extra.add(niveauI);
        root.add(extra);
        //
        frame.pack();
        frame.setVisible(true);
    }

    //

    //
    public static void fillForm(JPanel form, int niv, int pos) {
        form.removeAll();
        Niveau niveau = serie.getQuestion(niv, pos);
        form.add(new JLabel(niveau.getQuestion()));
        ButtonGroup grp = new ButtonGroup();
        for (int i = 0; i < niveau.getReponse().length; i++) {
            JRadioButton option = new JRadioButton(niveau.getReponse()[i]);
            if (i == 0)
                option.setSelected(true);
            grp.add(option);
            form.add(option);
        }
        //
        JButton btnNext = new JButton("Suivant");
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Enumeration<AbstractButton> radsV = grp.getElements();
                int i = 0;
                while (radsV.hasMoreElements()) {
                    JRadioButton temp = (JRadioButton) radsV.nextElement();
                    if (temp.isSelected()) {
                        results.add(i);
                        progress.setText(String.format("Progress : %d/15", results.size() + 1));
                        boolean res = niveau.isCorrect(i);
                        if (res)
                            points += 20;
                        pointsC.setText("Points : " + points);
                        break;
                    }
                    i++;
                }
                //
                int nextNiv = niv;
                if (pos == 4) {//5
                    nextNiv = niv + 1;
                }
                //
                int nextPos = pos;
                if (pos < 4)
                    nextPos++;
                else if (pos == 4)
                    nextPos = 0;
                //
                if(nextNiv != niv)
                    niveauI.setText("Niveau " + nextNiv);
                //
                if (nextNiv <= 3 && nextPos <= 4)
                    fillForm(form, nextNiv, nextPos);
            }
        });
        form.add(btnNext);
    }

    //
}
