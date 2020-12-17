import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

//
public class Quiz {

    private static Serie serie = new Serie();
    private static int points = 0;
    private static ArrayList<Integer> results = new ArrayList<Integer>();
    private static JLabel progress;
    private static JLabel pointsC;
    private static JLabel niveauI;
    private static int secElapsed = 0;
    private static int minElapsed = 0;
    private static boolean programEnd = false;
    private static Player player = new Player();

    //
    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz");
        frame.setPreferredSize(new Dimension(600, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        JPanel root = new JPanel(new GridLayout(2, 1));
        frame.setContentPane(root);
        //
        JPanel form = new JPanel(new GridLayout(5, 1));
        form.setBorder(new EmptyBorder(30, 30, 0, 30));
        int _pos = 0;
        fillForm(form, 1, _pos);
        root.add(form);
        //
        JPanel extra = new JPanel(new GridLayout(1, 0));
        Timer timerC = new Timer();
        JLabel timer = new JLabel("00:00");

        timerC.schedule(new TimerTask() {
            @Override
            public void run(){
                secElapsed++;
                if (secElapsed == 60) {
                    secElapsed = 0;
                    minElapsed++;
                }
                //
                if (programEnd)
                    timerC.cancel();
                else
                    timer.setText(String.format("%02d:%02d", minElapsed, secElapsed));
                //
                if (minElapsed == 5 && !programEnd)
                    endQuiz(form, false);
            }
        }, 1000, 1000);
        extra.add(timer);
        progress = new JLabel("Progress : 1/15");
        pointsC = new JLabel("Points : 000/100");
        niveauI = new JLabel("Niveau 1");
        extra.add(progress);
        extra.add(pointsC);
        extra.add(niveauI);
        extra.setBorder(new EmptyBorder(0, 30, 0, 0));
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
                        if (results.size() < 15)
                            progress.setText(String.format("Progress : %02d/15", results.size() + 1));
                        boolean res = niveau.isCorrect(i);
                        if (res)
                            points += 20;
                        pointsC.setText(String.format("Points : %03d/100",points));
                        break;
                    }
                    i++;
                }
                //
                int nextNiv = niv;
                if (pos == 4) {//5
                    points = 0;
                    nextNiv = niv + 1;
                }
                //
                int nextPos = pos;
                if (pos < 4)
                    nextPos++;
                else if (pos == 4)
                    nextPos = 0;
                //
                boolean pass = true;
                if (nextNiv != niv) {
                    if (nextNiv <= 3)
                        niveauI.setText("Niveau " + nextNiv);
                    switch (niv) {
                        case 1:
                            if (points < 40)
                                pass = false;
                            else
                                pointsC.setText("Points : 000/100");
                            break;
                        case 2:
                            if (points < 60)
                                pass = false;
                            else
                                pointsC.setText("Points : 000/100");
                            break;
                        case 3:
                            int localPoints = 0;
                            /*for (int j = 0; j < 5; j++) {
                                Niveau niveau1 = serie.getQuestion(3, j);
                                if (niveau1.isCorrect(results.get(j + 10)))
                                    localPoints++;
                            }*/
                            if (points < 4)
                                pass = false;
                            break;
                    }
                }
                //
                if (nextNiv <= 3 && nextPos <= 4 && pass)
                    fillForm(form, nextNiv, nextPos);
                else
                    endQuiz(form, pass);
            }
        });
        form.add(btnNext);
    }

    //
    private static void endQuiz(JPanel form, boolean pass) {
        if (!programEnd) {
            programEnd = true;
            form.removeAll();
            JLabel msg = new JLabel("Quiz terminé");
            form.add(msg);
            if (!pass) {
                form.add(new JLabel("Vous n'avez pas réussi l'examen!"));
            } else {
                form.add(new JLabel("Vous avez réussi l'examen"));
            }
            //
            player.playSound(pass);
        }
    }
}
