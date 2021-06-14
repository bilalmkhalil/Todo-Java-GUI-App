package splitContainers;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import databaseClass.Database;


public class mainPanel extends JPanel {
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JPanel listPanel;
    private Database database = new Database();

    // private String text = "";
    
    public mainPanel() {

        listPanel = new JPanel();
        listPanel.setBackground(Color.WHITE);
        listPanel.setPreferredSize(new Dimension(325, 400));
        listPanel.setLayout(new GridLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("TODO LIST"));
        // listPanel.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, Color.WHITE));

        String[] week = { "Monday","Tuesday","Wednesday", "Thursday","Friday","Saturday","Sunday" };

        list = new JList<String>(week);
        list.setFixedCellHeight(25);
        list.setBorder(BorderFactory.createMatteBorder(10, 15, 15, 15, Color.WHITE));
        // list.setRequestFocusEnabled(false);
        // list.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        listModel = new DefaultListModel<String>();

        if(database.fileExist()) {
            database.readFromFile(listModel);
        } else {
            listModel.addElement(week[0]);
            listModel.addElement(week[1]);
            listModel.addElement(week[2]);
            listModel.addElement(week[3]);
        }

        list.setModel(listModel);

        listPanel.add(list);
        add(listPanel);
        setBackground(Color.WHITE);
        setBounds(0,200, 440, 600);
    }

    public void setListValue(String text) {
        listModel.addElement(text);
        database.writeToFile(listModel);
    }
    public void delListValue(int index) {
        listModel.remove(index);
        database.writeToFile(listModel);
    }
    public void updateListValue(int index, String text) {
        listModel.add(index, text);
        database.writeToFile(listModel);
    }
    public int indexVal() {
        return list.getSelectedIndex();
    }
    public boolean isSelected() {
        return list.isSelectionEmpty();
    }
}