import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

//
public class Exercice_2 {
    public static void main(String[] args) {
        //ALI HMIMS
        JFrame frame = new JFrame("-- Fiche technique --");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 350));
        //
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));
        frame.setContentPane(root);
        //
        JPanel panel1 = new JPanel(new GridLayout(4, 1));
        //
        JLabel label1 = new JLabel("Choisissez la spécialité", SwingConstants.LEFT);
        panel1.add(label1);
        //
        JRadioButton rad1 = new JRadioButton("JEE");
        rad1.setSelected(true);
        JRadioButton rad2 = new JRadioButton("C#");
        JRadioButton rad3 = new JRadioButton("back & frontend");
        //
        ButtonGroup rads = new ButtonGroup();
        rads.add(rad1);
        rads.add(rad2);
        rads.add(rad3);
        //
        panel1.add(rad1);
        panel1.add(rad2);
        panel1.add(rad3);
        //
        //
        JPanel panel2 = new JPanel(new GridLayout(4, 1));
        //
        JLabel label2 = new JLabel("Choisissez vos préférences", SwingConstants.LEFT);
        panel2.add(label2);
        //
        JCheckBox cb1 = new JCheckBox("Programmation");
        JCheckBox cb2 = new JCheckBox("Conception");
        JCheckBox cb3 = new JCheckBox("Design graphique");
        //
        panel2.add(cb1);
        panel2.add(cb2);
        panel2.add(cb3);
        //
        //
        JButton btn1 = new JButton("Valider");
        btn1.setHorizontalAlignment(JLabel.LEFT);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String choix1 = "";
                Enumeration<AbstractButton> radsV = rads.getElements();
                while (radsV.hasMoreElements()) {
                    JRadioButton temp = (JRadioButton) radsV.nextElement();
                    if (temp.isSelected()) {
                        choix1 = temp.getText();
                        break;
                    }
                }
                //
                String choix2 = "";
                if (cb1.isSelected())
                    choix2 += cb1.getText();
                if (cb2.isSelected())
                    choix2 += ", " + cb2.getText();
                if (cb3.isSelected())
                    choix2 += ", " + cb3.getText();
                //
                String msg = String.format("Votre spécialité est : %s\nCompétences choisies : %s", choix1, choix2);
                JOptionPane.showMessageDialog(frame, msg, "-- Bilan --", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        //
        root.add(panel1);
        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(1000, 10));
        root.add(sep);
        root.add(panel2);
        root.add(btn1);
        //
        frame.pack();
        frame.setVisible(true);
    }
}
