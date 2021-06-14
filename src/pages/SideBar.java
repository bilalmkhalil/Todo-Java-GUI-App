package pages;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import databaseClass.Database;
import splitContainers.ListTabContainer;
import splitContainers.SideBarTextFieldContainer;

public class SideBar extends JPanel {
    JTextField sideTextField;
    ListTabContainer todoListContainer;
    SideBarTextFieldContainer sideBarTextFieldContainer;

    Database database;

    public SideBar() {
        database = new Database();
        
        sideBarTextFieldContainer = new SideBarTextFieldContainer();

        todoListContainer = new ListTabContainer();
        sideBarTextFieldContainer.setTab(todoListContainer);

        for(int i=0; i<database.countFiles(); i++) {
            todoListContainer.setVisiblity(i);
        }

        add(sideBarTextFieldContainer);
        add(todoListContainer);
        setBounds(0, 0, 300, 800);
        setBackground(Color.LIGHT_GRAY);
    }

    public void addTodoList() {
        if(!sideTextField.getText().toString().isEmpty()) {
            JLabel label = new JLabel(sideTextField.getText());
            
            JPanel listItem = new JPanel();
            listItem.add(label);

            todoListContainer.add(listItem); 
        }
    }
}