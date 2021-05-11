import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setSize(1024,800);
        frame.setTitle("ExON Todo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(Color.blue);
        upperPanel.setBounds(0,0, 1024, 200);

        JTextField textField = new JTextField();
        textField.setSize(420, 30);
        
        JButton button = new JButton("Add");
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createEtchedBorder(0));
        button.setBounds(0, 20, 200, 30);
        
        upperPanel.add(textField);
        upperPanel.add(button);
        frame.add(upperPanel);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
