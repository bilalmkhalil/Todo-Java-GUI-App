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
    
    public mainPanel() {
        listModel = new DefaultListModel<String>();
        
        listPanel = new JPanel();
        listPanel.setBackground(Color.WHITE);
        listPanel.setPreferredSize(new Dimension(325, 400));
        listPanel.setLayout(new GridLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("TODO LIST"));

        list = new JList<String>();
        list.setFixedCellHeight(25);
        list.setBorder(BorderFactory.createMatteBorder(10, 15, 15, 15, Color.WHITE));

        list.setModel(listModel);

        listPanel.add(list);
        add(listPanel);
        setBackground(Color.WHITE);
        setBounds(0,200, 440, 600);
    }

    public void fromFileToList(String fileName) {
        database.readFromFile(listModel, fileName);
    }

    public void setListValue(String text, String fileName) {
        listModel.addElement(text);
        database.writeToFile(listModel, fileName);
    }
    public void delListValue(int index, String fileName) {
        listModel.remove(index);
        database.writeToFile(listModel, fileName);
    }
    public void updateListValue(int index, String text, String fileName) {
        listModel.add(index, text);
        database.writeToFile(listModel, fileName);
    }
    public int indexVal() {
        return list.getSelectedIndex();
    }
    public boolean isSelected() {
        return list.isSelectionEmpty();
    }
}