import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercice_1_2 {
    public static void main(String[] args) {
        JPanel root = new JPanel(new GridLayout(3, 1));
        //
        JLabel label = new JLabel("Bienvenue",SwingConstants.CENTER);
        root.add(label);
        //
        JPanel btnsCont = new JPanel(new GridLayout(1,4));
        //
        JButton btn1 = new JButton("Noir");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                root.setBackground(Color.BLACK);
            }
        });
        btnsCont.add(btn1);
        //
        JButton btn2 = new JButton("Blanc");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                root.setBackground(Color.WHITE);
            }
        });
        btnsCont.add(btn2);
        //
        JButton btn3 = new JButton("Rouge");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                root.setBackground(Color.RED);
            }
        });
        btnsCont.add(btn3);
        //
        JButton btn4 = new JButton("Bleu");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                root.setBackground(Color.BLUE);
            }
        });
        btnsCont.add(btn4);
        //
        root.add(btnsCont);
        //
        Object[] items;
        JComboBox comboBox1 = new JComboBox(new String[]{"Noir","Blanc","Rouge","Bleu"});
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(comboBox1.getSelectedItem().equals("Noir"))
                    root.setBackground(Color.BLACK);
                else if(comboBox1.getSelectedItem().equals("Blanc"))
                    root.setBackground(Color.WHITE);
                else if(comboBox1.getSelectedItem().equals("Rouge"))
                    root.setBackground(Color.RED);
                else if(comboBox1.getSelectedItem().equals("Bleu"))
                    root.setBackground(Color.BLUE);
            }
        });
        root.add(comboBox1);
        //
        JFrame frame = new JFrame("Exercice_1");
        frame.setContentPane(root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
