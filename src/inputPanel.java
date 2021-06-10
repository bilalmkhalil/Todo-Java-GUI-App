import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class inputPanel extends JPanel {
    private JTextField textField;
    private Button addButton;
    private Button updateButton;
    private Button deleteButton;
    private mainPanel listPanel;
    
    public inputPanel() {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(230, 35));
        textField.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.LIGHT_GRAY));
        textField.setBackground(new Color(236,240,241));
        // textField.setForeground(Color.WHITE);
        
        addButton = new Button("Add");
        updateButton = new Button("Update");
        deleteButton = new Button("Delete");
        
        setUpButtonHover();
        setUpButtonListener();
        
        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setBackground(Color.WHITE);

        Box container = Box.createVerticalBox();

        buttonsContainer.add(addButton);
        buttonsContainer.add(updateButton);
        buttonsContainer.add(deleteButton);

        container.add(textField);
        container.add(Box.createRigidArea(new Dimension(5, 10)));
        container.add(buttonsContainer);

        add(container);
        setBackground(Color.WHITE);
        setBounds(0,0, 420, 200);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 80));
    }

    public void setList(mainPanel listPanel) {
        this.listPanel = listPanel;
    }

    private void setUpButtonHover() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                Object obj = e.getSource();

                if(obj == addButton) {
                    addButton.setBackground(new Color(44,62,80));
                    addButton.setFocusPainted(false);
                    addButton.setBorder(BorderFactory.createEmptyBorder());
                } else if (obj == deleteButton ) {
                    deleteButton.setBackground(new Color(192,57,43));
                    deleteButton.setFocusPainted(false);
                    deleteButton.setBorder(BorderFactory.createEmptyBorder());
                } else {
                    updateButton.setBackground(new Color(41,128,185));
                    updateButton.setFocusPainted(false);
                    updateButton.setBorder(BorderFactory.createEmptyBorder());
                }
            }
        
            public void mouseExited(MouseEvent e) {
                Object obj = e.getSource();

                if(obj == addButton) {
                    addButton.setBackground( new Color(52,73,94));
                    updateButton.setBorder(BorderFactory.createEmptyBorder());
                    // addButton.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, new Color(52,73,94)));
                } else if (obj == deleteButton ) {
                    deleteButton.setBackground(new Color(231,76,60));
                    // deleteButton.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, new Color(231,76,60)));
                } else {
                    updateButton.setBackground(new Color(52,152,219));
                    // updateButton.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, new Color(52,152,219)));
                }
            }
        };

        addButton.addMouseListener(mouseAdapter);
        deleteButton.addMouseListener(mouseAdapter);
        updateButton.addMouseListener(mouseAdapter);
    }

    private void setUpButtonListener() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();

                if(obj == addButton) {
                    if(!textField.getText().toString().isEmpty()) {
                        listPanel.setListValue(textField.getText().toString());
                        textField.setText(null);
                    }
                } else if (obj == deleteButton ) {
                    if(!listPanel.isSelected()) {
                        int index = listPanel.indexVal();
                        System.out.println(index);
                        if(index >= 0)
                            listPanel.delListValue(index);
                    }
                } else {
                    if(!listPanel.isSelected()) {
                        int index = listPanel.indexVal();
                        System.out.println(index);
                        if(!textField.getText().toString().isEmpty()) {
                            listPanel.delListValue(index);
                            listPanel.updateListValue(index, textField.getText().toString());
                            textField.setText(null);
                        }
                    }
                }
            }
        };

        addButton.addActionListener(buttonListener);
        updateButton.addActionListener(buttonListener);
        deleteButton.addActionListener(buttonListener);
    }
}