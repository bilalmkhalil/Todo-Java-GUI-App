import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

// import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class inputPanel extends JPanel {
    JTextField textField;
    JButton button;
    
    public inputPanel() {
        
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 35));
        textField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));
        
        button = new JButton("Add");
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, Color.DARK_GRAY));
        
        buttonHover();
        buttonAction();

        add(textField);
        add(button);
        setBackground(Color.blue);
        setBounds(0,0, 1024, 200);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 80));
    }

    private void buttonHover() {
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
    }
    
    private void buttonAction() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("working");
            }
        });
    }
}