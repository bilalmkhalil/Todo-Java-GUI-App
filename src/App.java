import java.awt.Color;
// import java.awt.Component;
// import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
// import javax.swing.JList;
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
        // upperPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 80));
        // upperPanel.setLayout(new GridLayout(0, 2, 150, 150));
        // upperPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.red);
        mainPanel.setBounds(0,0, 1024, 800);
        // mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);



        JTextField textField = new JTextField(25);
        // textField.setSize(420, 30);
        
        JButton button = new JButton("Add");
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        button.setBounds(0, 20, 300, 30);
        // button.setBorder(BorderFactory.createLineBorder(Color.darkGray, 10));
        button.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, Color.darkGray));

        // String week[]= { "Monday","Tuesday","Wednesday",
        //                  "Thursday","Friday","Saturday","Sunday"};

        // JList list = new JList(week);
        // list.setBounds(0, 20, 200, 30);

        
        upperPanel.add(textField);
        upperPanel.add(button);
        // mainPanel.add(list);
        frame.add(upperPanel);
        frame.add(mainPanel);
        // frame.getContentPane().setBackground(Color.cyan);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

// class Panel {
//     JPanel panel;
//     private int x, y, width, length;
//     private String xAlignment, color;

//     Panel(String color, int x, int y, int width, int length, String xAlignment) {
//         this.color = color;
//         this.x = x;
//         this.y = y;
//         this.width = width;
//         this.length = length;
//         this.xAlignment = xAlignment;
//     }

//     panel.setBackground(color);
//     panel.setBounds(x, y, width, length);
//     panel.setAlignmentX(xAlignment);

// }
