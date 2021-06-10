import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Color;

// import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {
    public Button(String label) {
        if(label.equals("Add")) {
            setText(label);
            setBackground(new Color(52,73,94));
            setForeground(Color.WHITE);
            setPreferredSize(new Dimension(80, 35));
            // setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, new Color(52,73,94)));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setFocusPainted(false);
            setFocusable(true);
        } else if(label.equals("Delete")) {
            setText(label);
            setBackground(new Color(231,76,60));
            setForeground(Color.WHITE);
            // setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, new Color(231,76,60)));
            setPreferredSize(new Dimension(120, 35));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setFocusPainted(false);
        } else {
            setText(label);
            setBackground(new Color(52,152,219));
            setForeground(Color.WHITE);
            // setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, new Color(52,152,219)));
            setPreferredSize(new Dimension(120, 35));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            setFocusPainted(false);
        }
    }
}