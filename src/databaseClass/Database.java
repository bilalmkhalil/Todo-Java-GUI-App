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
    public Database(String fileName) {
        // this.fileName = fileName;
    }
    
    public void writeToFile(DefaultListModel<String> obj) {
        int size = obj.getSize();
        String listItem = "";

        for(int index = 0; index < size; index++ ) {
            listItem += obj.getElementAt(index);
            if(index < size-1)
                listItem += ",";
        }
        
        try {
            FileWriter file = new FileWriter("database/TodoList.txt", false);
            file.write(listItem);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(DefaultListModel<String> obj) {
        int data = 0;

        try {
			FileReader file = new FileReader("database/TodoList.txt");
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

    public boolean fileExist() {
        File file = new File("database/TodoList.txt");
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
}