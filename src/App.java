
import javax.swing.JFrame;

import pages.SideBar;
import pages.TodoList;
import pages.HomePage;

class App extends JFrame {
    public App() {

        HomePage listContainer = new HomePage();
        TodoList todoList = new TodoList();
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
