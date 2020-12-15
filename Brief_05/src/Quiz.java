import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//
public class Quiz {
    private static ArrayList<String[][]> niveau_1 = new ArrayList<String[][]>();
    private static ArrayList<String[][]> niveau_2 = new ArrayList<String[][]>();
    private static ArrayList<String[][]> niveau_3 = new ArrayList<String[][]>();

    //
    public static void main(String[] args) {
        fillCollection();
        JFrame frame = new JFrame("Quiz");
        //frame.setPreferredSize(new Dimension(400, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        JPanel root = new JPanel(new GridLayout(2, 1));
        frame.setContentPane(root);
        //
        JPanel form = new JPanel(new GridLayout(1, 1, 0, 5));
        //form.setPreferredSize(new Dimension(400,300));
        int pos = 0;
        fillForm(form, niveau_1, pos);
        root.add(form);
        //
        JPanel extra = new JPanel(new GridLayout(1, 3, 0, 0));
        JLabel timer = new JLabel("*");
        extra.add(timer);
        root.add(extra);
        timer.setText("yuh");
        //
        frame.pack();
        frame.setVisible(true);
    }

    //

    //
    public static void fillForm(JPanel form, ArrayList<String[][]> list) {
        form.removeAll();
        for (String[][] qSet : list) {
            JPanel row = new JPanel(new GridLayout(4, 1));
            row.add(new JLabel(qSet[0][0]));
            ButtonGroup grp = new ButtonGroup();
            for (int i = 0; i < qSet[1].length; i++) {
                JRadioButton option = new JRadioButton(qSet[1][i]);
                grp.add(option);
                row.add(option);
            }
            form.add(row);
        }
    }

    public static void fillForm(JPanel form, ArrayList<String[][]> list, int pos) {
        form.removeAll();
        String[][] qSet = list.get(pos);
        JPanel row = new JPanel(new GridLayout(4, 1));
        row.add(new JLabel(qSet[0][0]));
        ButtonGroup grp = new ButtonGroup();
        for (int i = 0; i < qSet[1].length; i++) {
            JRadioButton option = new JRadioButton(qSet[1][i]);
            grp.add(option);
            row.add(option);
        }
        form.add(row);
    }

    //
}
