import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercice_1 {
    //ALI HMIMS
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel root;
    private JPanel btnsCont;
    private JLabel label1;
    private JComboBox comboBox1;

    public Exercice_1() {
        label1.setText("Bienvenue");
        button1.setText("Noir");
        button2.setText("Rouge");
        button3.setText("Blanc");
        button4.setText("Bleu");
        //
        comboBox1.addItem("Noir");
        comboBox1.addItem("Rouge");
        comboBox1.addItem("Blanc");
        comboBox1.addItem("Bleu");
        //
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                root.setBackground(Color.BLACK);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                root.setBackground(Color.BLUE);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                root.setBackground(Color.WHITE);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                root.setBackground(Color.RED);
            }
        });
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
    }

    //
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exercice_1");
        frame.setContentPane(new Exercice_1().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    //
}
