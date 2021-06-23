package splitContainers;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.Component;
// import java.awt.Font;

import customComponents.Button;
import databaseClass.Database;

public class SideBarTextFieldContainer extends JPanel {
    private JTextField sideTextField;
    private Button addButton;
    private ListTabContainer listTab = new ListTabContainer();
    private Database database = new Database();

    public SideBarTextFieldContainer() {

        JLabel titleJLabel = new JLabel("ExON Todo App");
        titleJLabel.setFont(titleJLabel.getFont().deriveFont(28.0f));
        
        sideTextField = new JTextField();
        sideTextField.setPreferredSize(new Dimension(200, 33));
        sideTextField.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));
        sideTextField.setBackground(new Color(236,240,241));
        
        addButton = new Button("Add");
        
        setUpButtonListener();
        setUpButtonHover();

        add(titleJLabel);
        add(sideTextField);
        add(addButton);
        setPreferredSize(new Dimension(290, 200));
        setBackground(Color.WHITE);
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
                            
                            Component[] panels = listTab.getComponents();

                            for(int i=0; i<panels.length; i++) {
                                if(!((JPanel) panels[i]).isVisible()) {
                                    String fileName = sideTextField.getText();

                                    ((JLabel) (((JPanel) (((JPanel) panels[i]).getComponent(0))).getComponent(0))).setText(fileName);

                                    ((JPanel) panels[i]).setVisible(true);
            
                                    database.createNewFile(fileName);
                                    sideTextField.setText(null);
                                    break;
                                }
                            }
                            
                        }
                    }
                }
            }
        };

        addButton.addActionListener(buttonListener);
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
            }
        
            public void mouseExited(MouseEvent e) {
                Object obj = e.getSource();

                if(obj == addButton) {
                    addButton.setBackground( new Color(52,73,94));
                }
            }
        };

        addButton.addMouseListener(mouseAdapter);
    }

}