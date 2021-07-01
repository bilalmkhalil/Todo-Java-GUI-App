package splitContainers;

import java.awt.Cursor;
import java.awt.Dimension;
// import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;


// import customComponents.Button;
import customComponents.ListTab;
import databaseClass.Database;
import pages.HomePage;
import pages.TodoList;

public class ListTabContainer extends JPanel {
    private ListTab list1;
    private ListTab list2;
    private ListTab list3;
    private ListTab list4;
    private ListTab list5;
    private Database database;

    public ListTabContainer() {
        database = new Database();

        JLabel label = new JLabel("List Tabs");
        label.setFont(label.getFont().deriveFont(20.0F));
        label.setBorder(BorderFactory.createMatteBorder(0, 0, 30, 0, Color.WHITE));


        list1 = new ListTab();
        list2 = new ListTab();
        list3 = new ListTab();
        list4 = new ListTab();
        list5 = new ListTab();

        list1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        list2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        list3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        list4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        list5.setCursor(new Cursor(Cursor.HAND_CURSOR));

        setVisiblityFromDatabase();
        setTabTitleFromDatabase();
        tabClickListener();

        

        setUpButtonListener();

        setPreferredSize(new Dimension(290, 520));
        setBackground(Color.WHITE);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10,0,0,0);

        add(label, gbc);
        add(list1, gbc);
        add(list2, gbc);
        add(list3, gbc);
        add(list4, gbc);
        add(list5, gbc);
    }

    public void setVisiblityFromDatabase() {
        for(int num=0; num<database.countFiles(); num++) {
            if(num == 0) {
                list1.setVisible(true);
            } else if(num==1) {
                list2.setVisible(true);
            } else if(num==2) {
                list3.setVisible(true);
            } else if(num==3) {
                list4.setVisible(true);
            } else if(num==4) {
                list5.setVisible(true);
            }
        }
    }

    public void setTabTitleFromDatabase() {
        String[] titles = database.existedFiles();
        for(int i = 0; i<database.countFiles(); i++) {
            if(i==0) {
                String[] temp = titles[i].split("\\.");
                list1.setTitle(temp[0]);
            } else if(i==1) {
                String[] temp = titles[i].split("\\.");
                list2.setTitle(temp[0]);
            } else if(i==2) {
                String[] temp = titles[i].split("\\.");
                list3.setTitle(temp[0]);
            } else if(i==3) {
                String[] temp = titles[i].split("\\.");
                list4.setTitle(temp[0]);
            } else if(i==4) {
                String[] temp = titles[i].split("\\.");
                list5.setTitle(temp[0]);
            }
        }
    }

    private void setUpButtonListener() {
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();

                if(((JButton) obj).getText().equals("Delete")) {

                    JLabel label = ((JLabel) (((JPanel) (((JButton) obj).getParent().getComponent(0))).getComponent(0)));
                    String file = label.getText();

                    database.deleteFile(file);
                    label.getParent().getParent().setVisible(false);
                }
                
            }
        };
        
        ((JButton) list1.getComponent(1)).addActionListener(buttonListener);
        ((JButton) list2.getComponent(1)).addActionListener(buttonListener);
        ((JButton) list3.getComponent(1)).addActionListener(buttonListener);
        ((JButton) list4.getComponent(1)).addActionListener(buttonListener);
        ((JButton) list5.getComponent(1)).addActionListener(buttonListener);
    }

    private void tabClickListener() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Object obj = e.getSource();

                HomePage homePage = new HomePage();
                homePage.setVisible(false);

                JPanel panel = ((JPanel) ((JPanel) obj).getComponent(0));
                JLabel label = ((JLabel) (panel.getComponent(0)));
                String fileName = label.getText();

                mainPanel mainpanel = new mainPanel();
                mainpanel.fromFileToList(fileName);
                // TodoList list = new TodoList(fileName);
                // list.setVisible(true);
            }
        };

        list1.addMouseListener(mouseAdapter);
        list2.addMouseListener(mouseAdapter);
        list3.addMouseListener(mouseAdapter);
        list4.addMouseListener(mouseAdapter);
        list5.addMouseListener(mouseAdapter);
    }

    // public void setVisiblity(int num) {
    //     if(num == 0) {
    //         list1.setVisible(true);
    //     } else if(num==1) {
    //         list2.setVisible(true);
    //     } else if(num==2) {
    //         list3.setVisible(true);
    //     } else if(num==3) {
    //         list4.setVisible(true);
    //     } else if(num==4) {
    //         list5.setVisible(true);
    //     }
    // }

    public void setTabTitle(String name, int i) {
        if(i==0) {
            list1.setTitle(name);
        } else if(i==1) {
            list2.setTitle(name);
        } else if(i==2) {
            list3.setTitle(name);
        } else if(i==3) {
            list4.setTitle(name);
        } else if(i==4) {
            list5.setTitle(name);
        }
    }

    public int listTabCounter() {
        int counter = 0;

        if(list1.isVisible())
            counter++;
        if(list2.isVisible())
            counter++;
        if(list3.isVisible())
            counter++;
        if(list4.isVisible())
            counter++;
        if(list5.isVisible())
            counter++;

        return counter;
    }
}