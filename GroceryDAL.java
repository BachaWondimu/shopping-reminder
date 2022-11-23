package OOP_Project;

import java.io.*;
import java.util.ArrayList;

public class GroceryDAL {


    public GroceryDAL() {
    }


    public void writeToList(String data, boolean append, String filePath) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(filePath, append));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }


    //This method will add a given list of items to the file at filepath
    public void addToList(String[] list, String filePath) {
        StringBuffer stringBuffer = new StringBuffer("");
        for (String element : list) {
            stringBuffer.append(element + "\n");
        }
        writeToList(stringBuffer.toString(), true, filePath);
    }


    //This method will override the existing lists with a new set of items
    public void writeNewList(String[] list, String filePath) {
        StringBuffer str = new StringBuffer("");
        for (String temp : list) {
            if (!temp.isBlank() || !temp.isEmpty()) {
                while (temp.charAt(0) == ' ') {
                    temp = temp.trim();
                }
                if (48 <= temp.charAt(0) && temp.charAt(0) <= 57) {
                    if (temp.length() > 2) {
                        str.append(temp.substring(2) + "\n");
                    }
                } else
                    str.append(temp + "\n");
            }
        }
        writeToList(str.toString(), false, filePath);
    }


    public ArrayList<String> search(boolean allButThisLine, String item, String filePath) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = reader.readLine()) != null) {
                if (allButThisLine && !line.equals(item)
                        || !allButThisLine && line.equals(item)) {
                    list.add(line);
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return list;
    }


    public void delete(String item, String filePath) {
        ArrayList<String> newList = search(true, item, filePath);
        String str = "";
        for (int i = 0; i < newList.size(); i++) {
            str += newList.get(i)+"\n";
        }
        writeToList(str, false, filePath);
    }


    public ArrayList<String> readAll(String filePath) {
        ArrayList<String> myList = new ArrayList<>();
        try {
            BufferedReader readLine = new BufferedReader(new FileReader(filePath));
            String line = "";
            while ((line = readLine.readLine()) != null) {
                myList.add(line);
            }
            readLine.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return myList;
    }


    //The End
}