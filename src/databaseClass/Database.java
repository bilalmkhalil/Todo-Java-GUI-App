package databaseClass;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;

public class Database {
    // private String fileName;
    private String text = "";

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

    public void readFromFile(DefaultListModel<String> obj, String fileName) {
        int data = 0;

        if(countFiles() > 0) { 
            try {
                String filePath = "database/" + fileName + ".txt";
    
                FileReader file = new FileReader(filePath);
                while((data = file.read()) != -1) {
                    text += (char)data;
                }
                file.close();
                
                List<String> list = Arrays.asList(text.split(","));
    
                for(String item:list) {
                    obj.addElement(item);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
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