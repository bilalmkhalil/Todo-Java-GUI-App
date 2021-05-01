import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;

public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        frame.setSize(420,420);
        frame.setTitle("ExON Todo");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(420, 30));

        frame.getContentPane().setBackground(Color.cyan);
    }
}
