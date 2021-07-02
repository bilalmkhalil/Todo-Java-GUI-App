
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;

import databaseClass.Database;
import splitContainers.ListTabContainer;
import splitContainers.SideBarTextFieldContainer;
import splitContainers.inputPanel;
import splitContainers.mainPanel;

class App extends JFrame {
    String[] title;
    Database database;
    JTextField sideTextField;
    ListTabContainer todoListContainer;
    SideBarTextFieldContainer sideBarTextFieldContainer;
    JPanel SideBar;
    JPanel TodoList;

    private inputPanel upperPanel;
    private mainPanel panel;
    ListTabContainer tabContainer;

    public App() {
        database = new Database();

        String[] list = database.existedFiles();
        title = list[0].split("\\.");

        SideBar = new JPanel();

        
        sideBarTextFieldContainer = new SideBarTextFieldContainer();

        todoListContainer = new ListTabContainer();
        sideBarTextFieldContainer.setTab(todoListContainer);


        TodoList = new JPanel();

        upperPanel = new inputPanel();
        panel = new mainPanel();

        upperPanel.setFileName(title[0]);

        upperPanel.setList(panel);

        todoListContainer.setTodoList(panel, upperPanel);
        
        System.out.println("TodoList File Name: " + title[0] + "\n");


        SideBar.add(sideBarTextFieldContainer);
        SideBar.add(todoListContainer);
        SideBar.setBounds(0, 0, 320, 800);
        SideBar.setBackground(Color.WHITE);
        SideBar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, new Color(217, 218, 218)));

        TodoList.add(upperPanel);
        TodoList.add(panel);
        TodoList.setBounds(300, 0, 700, 800);
        TodoList.setBackground(Color.white);
        
        add(SideBar);
        add(TodoList);

        setTitle("ExON Todo");
        setSize(1000,800);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);  
    }
    public static void main(String[] args) {
        new App();
    }
}
