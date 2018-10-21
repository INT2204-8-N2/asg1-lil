package database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Dictionary {
    
    protected HashMap<String, String> data;
    protected ArrayList<String> keys;
    
    public Dictionary() {
        data = new HashMap<>();
        keys = new ArrayList<>();
        readData("data/E_V.txt");
    }
    
    public Dictionary(String path) {
        data = new HashMap<>();
        keys = new ArrayList<>();
        readData(path);
    }

    public HashMap<String, String> getData() {
        return data;
    }
    
    public void setData(HashMap<String, String> data) {
        this.data = data;
    }
    
    public ArrayList<String> getKeys() {
        return keys;
    }
    
    public void setKeys(ArrayList<String> keys) {
        this.keys = keys;
    }
    
    private void readData(String path) {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            String line, word, def;
            while ((line = in.readLine()) != null) {
                
                int index1 = line.indexOf("<html>");
                int index2 = line.indexOf("<ul>");

                if (index2 != -1 && index1 > index2) {
                    index1 = index2;
                }

                if (index1 != -1) {
                    word = line.substring(0, index1);

                    word = word.trim();
                    keys.add(word);

                    def = line.substring(index1);
                    data.put(word, def);
                }
            }
            Collections.sort(keys);
            in.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }  
    
    public void addWord(String word, String def){
        data.put(word, def);
        int n = binarySearch(keys, word);
        keys.add(n, word);
    }    
    
    public int binarySearch(ArrayList<String> keys, String str) { 
        if (keys.get(0).compareTo(str)>=0) return 0;
        int l = 0, r = keys.size();
        while (l < r - 1){
            int m = (l + r) / 2;
            if (keys.get(m).compareTo(str) < 0) l = m;
            else r = m;
        }
        return r;
    }  
    
    public void modifyWord(String word, String newWord, String newDef) {
        if (newWord == null){
            data.replace(word, newDef);
        } else
        if (newDef == null){
            String defin = data.get(word);
            removeWord(word);
            addWord(newWord, defin);
        } else{
            removeWord(word);
            addWord(newWord,newDef);
        }
    }
    
    public void removeWord(String word) {
        int n = keys.lastIndexOf(word);
        if (n>=0 && n<=keys.size() - 1) {
            keys.remove(n);
            data.remove(word);
        }
    }
    
    public void update(String path) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            
            for (String key : keys) {
                writer.write(key);
                String def = data.get(key);
                if (def != null) {
                    writer.write(data.get(key));
                }

                writer.newLine();
            }

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
