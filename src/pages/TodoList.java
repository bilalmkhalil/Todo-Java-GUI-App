package pages;

import javax.swing.JPanel;

import splitContainers.inputPanel;
import splitContainers.mainPanel;

public class TodoList extends JPanel {
    public TodoList() {
        
        inputPanel upperPanel = new inputPanel();
        mainPanel panel = new mainPanel();

        upperPanel.setList(panel);
        
        add(upperPanel);
        add(panel);
        setBounds(300, 0, 700, 800);
    }
}