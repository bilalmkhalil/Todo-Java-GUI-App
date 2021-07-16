package databaseClass;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Database {
    private static int counter = 0;

    public Database() {}
    
    public void writeToFile(DefaultListModel<String> obj, String fileName) {
        int size = obj.getSize();
        String listItem = "";

        for(int index = 0; index < size; index++ ) {
            listItem += obj.getElementAt(index);
            if(index < size-1)
                listItem += ",";
        }
        
        try {
            String filePath = "database/" + fileName + ".txt";

            FileWriter file = new FileWriter(filePath, false);
            file.write(listItem);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(DefaultListModel<String> listModel, String fileName) {
        String text = "";
        ArrayList<String> list = new ArrayList<String>();
        int data = 0;

        try {
            String filePath = "database/" + fileName + ".txt";
            System.out.println(filePath);

            FileReader file = new FileReader(filePath);
            while((data = file.read()) != -1) {
                text += (char)data;
            }
            file.close();
            
            if(text != "") {
                for(String listItem:text.split(",")) {
                    list.add(listItem);
                    System.out.println(listItem);
                } 
    
                for(String item:list) {
                    listModel.addElement(item);
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(list.size());
        if (counter != 0) {

            for(int i=counter-1; i>=0; i--) {
                System.out.println(listModel.elementAt(i) + "  Removed!");
                listModel.remove(i);
            }
        }

        counter = list.size();
    }

    public boolean fileExist(String fileName) {
        String filePath = "database/" + fileName + ".txt";
        File file = new File(filePath);
        return file.exists();
    }

    public int countFiles() {
        File files = new File("database");
        int len = files.list().length;
        return len;
    }

    public String[] existedFiles() {
        File files = new File("database");
        return files.list();  
    }

    public void createNewFile(String fileName) {
        try {
            String filePath = "database/" + fileName + ".txt";
            File file = new File(filePath);
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteFile(String fileName) {
        try {
            String filePath = "database/" + fileName + ".txt";
            File file = new File(filePath);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}