package splitContainers;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import customComponents.Button;
import databaseClass.Database;

public class SideBarTextFieldContainer extends JPanel {
    private JTextField sideTextField;
    private Button addButton;
    private Button deleteButton;
    private ListTabContainer listTab = new ListTabContainer();
    private Database database = new Database();

    public SideBarTextFieldContainer() {
        
        sideTextField = new JTextField();
        sideTextField.setPreferredSize(new Dimension(200, 30));
        
        addButton = new Button("Add");
        deleteButton = new Button("Delete");
        
        setUpButtonListener();
        setUpButtonHover();

        add(sideTextField);
        add(addButton);
        add(deleteButton);
        setPreferredSize(new Dimension(290, 200));
    }

    public void setTab(ListTabContainer listTab) {
        this.listTab = listTab;
    }

    private void setUpButtonListener() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();

                if(obj == addButton) {
                    if(!sideTextField.getText().toString().isEmpty()) {
                        if(listTab.listTabCounter() != 5) {
                            String fileName = sideTextField.getText();
                            
                            listTab.setTabTitle(fileName, listTab.listTabCounter());
                            listTab.setVisiblity(listTab.listTabCounter());
    
                            database.createNewFile(fileName);
                            
                            sideTextField.setText(null);
                        }
                    }
                }

                if(obj == deleteButton) {

                }
            }
        };

        addButton.addActionListener(buttonListener);
        deleteButton.addActionListener(buttonListener);
    }

    private void setUpButtonHover() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                Object obj = e.getSource();

                if(obj == addButton) {
                    addButton.setBackground(new Color(44,62,80));
                    addButton.setFocusPainted(false);
                    addButton.setBorder(BorderFactory.createEmptyBorder());
                } 
                if (obj == deleteButton ) {
                    deleteButton.setBackground(new Color(192,57,43));
                    deleteButton.setFocusPainted(false);
                    deleteButton.setBorder(BorderFactory.createEmptyBorder());
                }
            }
        
            public void mouseExited(MouseEvent e) {
                Object obj = e.getSource();

                if(obj == addButton) {
                    addButton.setBackground( new Color(52,73,94));
                } 
                if (obj == deleteButton) {
                    deleteButton.setBackground(new Color(231,76,60));
                }
            }
        };

        addButton.addMouseListener(mouseAdapter);
        deleteButton.addMouseListener(mouseAdapter);
    }

}