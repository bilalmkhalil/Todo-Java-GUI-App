
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

class App extends JFrame {
    public App() {
        JPanel sideBar = new JPanel();
        sideBar.setBounds(0, 0, 300, 800);
        sideBar.setBackground(Color.LIGHT_GRAY);

        JPanel listContainer = new JPanel();
        listContainer.setPreferredSize(new Dimension(420, 800));
        listContainer.setBounds(430, 0, 420, 800);
        


        inputPanel upperPanel = new inputPanel();
        mainPanel panel = new mainPanel();

        upperPanel.setList(panel);

        listContainer.add(upperPanel);
        listContainer.add(panel);
        
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
