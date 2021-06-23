package pages;

import java.awt.Color;

import javax.swing.BorderFactory;
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

        add(sideBarTextFieldContainer);
        add(todoListContainer);
        setBounds(0, 0, 320, 800);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, new Color(217, 218, 218)));
    }
}