package pages;

import java.awt.Color;

// import java.awt.Color;

import javax.swing.JPanel;

import splitContainers.inputPanel;
import splitContainers.mainPanel;

public class TodoList extends JPanel {
    String fileName;

    public TodoList() {
        
        inputPanel upperPanel = new inputPanel(fileName);
        mainPanel panel = new mainPanel(fileName);

        upperPanel.setList(panel);
        
        System.out.println("TodoList File Name: " + fileName);

        add(upperPanel);
        add(panel);
        setBounds(300, 0, 700, 800);
        setBackground(Color.white);
    }
    public void setFile(String fileName) {
        this.fileName = fileName;
    }
}