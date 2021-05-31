import java.awt.Color;
// import java.awt.Component;
// import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JPanel;

class App extends JFrame {
    public App() {
        // JFrame frame = new JFrame();
        setSize(1024,800);
        setTitle("ExON Todo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(Color.blue);
        upperPanel.setBounds(0,0, 1024, 200);
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 80));
        // upperPanel.setLayout(new GridLayout(0, 2, 150, 150));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.red);
        mainPanel.setBounds(0,0, 1024, 800);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel listPanel = new JPanel();
        listPanel.setPreferredSize(new Dimension(350, 600));
        // listPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        listPanel.setBackground(Color.DARK_GRAY);

        JLabel title = new JLabel("ExON Todo App");
        title.setForeground(Color.WHITE);
        // listPanel.add(title);
        // title.setText("khan");

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 35));
        textField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        
        JButton button = new JButton("Add");
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, Color.DARK_GRAY));

        String[] week = { "Monday","Tuesday","Wednesday", "Thursday","Friday","Saturday","Sunday" };

        JList list = new JList(week);
        list.setBackground(Color.ORANGE);

        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.GREEN);
                button.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, Color.GREEN));
            }
        
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.DARK_GRAY);
                button.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, Color.DARK_GRAY));
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("working");
                title.setText("Working");
            }
        });
        
        upperPanel.add(title);
        upperPanel.add(textField);
        upperPanel.add(button);
        listPanel.add(list);
        mainPanel.add(listPanel); 
        // mainPanel.add(list);
        add(upperPanel);
        add(mainPanel);
        // getContentPane().setBackground(Color.cyan);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new App();
    }
}
