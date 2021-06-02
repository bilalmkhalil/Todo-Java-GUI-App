import javax.swing.JFrame;

class App extends JFrame {
    public App() {
        inputPanel upperPanel = new inputPanel();
        mainPanel panel = new mainPanel();

        add(upperPanel);
        add(panel);

        setTitle("ExON Todo");
        setSize(1024,800);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new App();
    }
}
