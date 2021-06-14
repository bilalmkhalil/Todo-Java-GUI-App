
import javax.swing.JFrame;

import pages.SideBar;
import pages.TodoList;

class App extends JFrame {
    public App() {

        SideBar sideBar = new SideBar();
        TodoList listContainer = new TodoList();
        
        add(sideBar);
        add(listContainer);

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
