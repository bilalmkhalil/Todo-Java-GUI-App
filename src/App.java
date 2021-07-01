
import javax.swing.JFrame;

import databaseClass.Database;
import pages.SideBar;
import pages.TodoList;
import pages.HomePage;

class App extends JFrame {
    private String[] title;
    private Database database;

    public App() {

        HomePage listContainer = new HomePage();
        
        database = new Database();
        String[] list = database.existedFiles();
        title = list[0].split("\\.");

        TodoList todoList = new TodoList(title[0]);
        todoList.setVisible(true);
        
        listContainer.setVisible(false);
        SideBar sideBar = new SideBar();
        
        add(sideBar);
        add(listContainer);
        add(todoList);

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
