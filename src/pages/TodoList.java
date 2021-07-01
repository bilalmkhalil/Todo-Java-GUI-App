package pages;

import java.awt.Color;

// import java.awt.Color;

import javax.swing.JPanel;

import splitContainers.inputPanel;
import splitContainers.mainPanel;

public class TodoList extends JPanel {
    private inputPanel upperPanel;
    private mainPanel panel;
    
    // public TodoList() {}

    public TodoList(String fileName) {
        
        upperPanel = new inputPanel(fileName);
        panel = new mainPanel();
        panel.fromFileToList(fileName);

        upperPanel.setList(panel);
        
        System.out.println("TodoList File Name: " + fileName + "\n");

        add(upperPanel);
        add(panel);
        setBounds(300, 0, 700, 800);
        setBackground(Color.white);
    }
}