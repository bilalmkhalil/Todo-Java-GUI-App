package customComponents;

import databaseClass.Database;
// import splitContainers.ListTabContainer;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
// import java.awt.Component;


public class ListTab extends JPanel {
    private JLabel title;
    private Button delButton;
    // private ListTabContainer tabList = new ListTabContainer();
    Database database = new Database();

    public ListTab() {
        JPanel titleContainer = new JPanel();
        titleContainer.setPreferredSize(new Dimension(200, 28));
        titleContainer.setBackground(new Color(0,180,137));

        title = new JLabel("title");
        title.setForeground(Color.WHITE);
        title.setFont(title.getFont().deriveFont(13.5f));

        titleContainer.add(title);

        delButton = new Button("Delete");

        delButton.setPreferredSize(new Dimension(60, 35));
        
        // setUpButtonListener();
        setUpButtonHover();


        setLayout(new FlowLayout(FlowLayout.RIGHT));

        add(titleContainer);
        add(delButton);
        setBackground(new Color(0,180,137));
        setPreferredSize(new Dimension(290, 45));
        setVisible(false);
    }

    public void setTitle(String text) {
        System.out.println(text);
        title.setText(text);
    }

    // private void setUpButtonListener() {
    //     ActionListener buttonListener = new ActionListener() {
    //         @Override
    //         public void actionPerformed(ActionEvent e) {
    //             Object obj = e.getSource();
                
    //             if(obj == delButton) {
    //                 Component[] comp = delButton.getParent().getComponents();
                    
    //                 for(int i=0; i<comp.length-1; i++) {
    //                     String file = ((JLabel) comp[i]).getText();
    //                     database.deleteFile(file);
    //                     tabList.disVisibility(file);
    //                     // comp[i].getParent().setVisible(false);
    //                 }
    //             }
    //         }
    //     };

    //     delButton.addActionListener(buttonListener);
    // }

    private void setUpButtonHover() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                Object obj = e.getSource();

                if(obj == delButton) {
                    delButton.setBackground(new Color(192,57,43));
                    delButton.setFocusPainted(false);
                    delButton.setBorder(BorderFactory.createEmptyBorder());
                }
            }
        
            public void mouseExited(MouseEvent e) {
                Object obj = e.getSource();

                if(obj == delButton) {
                    delButton.setBackground(new Color(231,76,60));
                }
            }
        };

        delButton.addMouseListener(mouseAdapter);
    }
}