package splitContainers;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import customComponents.ListTab;
import databaseClass.Database;

public class ListTabContainer extends JPanel {
    private ListTab list1;
    private ListTab list2;
    private ListTab list3;
    private ListTab list4;
    private ListTab list5;
    private Database database;

    public ListTabContainer() {
        database = new Database();

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

        for(int i=0; i<database.countFiles(); i++) {
            setVisiblity(i);
        }

        add(list1);
        add(list2);
        add(list3);
        add(list4);
        add(list5);

        setPreferredSize(new Dimension(290, 540));
        setLocation(0, 300);
    }

    public void setVisiblityFromDatabase() {
        for(int i=0; i<database.countFiles(); i++) {
            setVisiblity(i);
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

    public void setVisiblity(int num) {
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