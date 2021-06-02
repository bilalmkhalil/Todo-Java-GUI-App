import java.awt.Color;

import javax.swing.JList;
import javax.swing.JPanel;

public class mainPanel extends JPanel {
    JList<String> list;
    
    public mainPanel() {
        String[] week = { "Monday","Tuesday","Wednesday", "Thursday","Friday","Saturday","Sunday" };

        list = new JList<String>(week);
        list.setBackground(Color.ORANGE);
        list.setBounds(0,0, 400, 600);

        // add(listPanel);
        add(list);
        setBackground(Color.red);
        setBounds(0,200, 1024, 600);
    }
}