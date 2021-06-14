package customComponents;

import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ListTab extends JPanel {
    private JLabel title;

    public ListTab() {
        title = new JLabel("title");

        title.setForeground(Color.WHITE);

        add(title);
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(290, 35));
        setVisible(false);
    }

    public void setTitle(String text) {
        System.out.println(text);
        title.setText(text);
    }
}