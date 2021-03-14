package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadWriteClass {

    public static HashMap<String, Integer> ReadFile(String file){
        HashMap<String, Integer> dictionary = new HashMap<>();
        try(FileReader reader = new FileReader(file)) {
            int c;
            StringBuilder buf = new StringBuilder();
            while ((c = reader.read())!=-1) {
                if (ParseClass.parsing(String.valueOf((char) c))) {
                    buf.append((char) c);
                } else if (ParseClass.parsing(String.valueOf(buf))) {
                    System.out.println(buf);
                    int count = dictionary.get(String.valueOf(buf)) != null ? dictionary.get(String.valueOf(buf))+1 : 1;
                    dictionary.put(String.valueOf(buf),count);
                    buf = new StringBuilder();
                }
            }
            if (buf.length() > 0 && ParseClass.parsing(String.valueOf(buf))){
                int count = dictionary.get(String.valueOf(buf)) != null ? dictionary.get(String.valueOf(buf))+1 : 1;
                dictionary.put(String.valueOf(buf),count);
                System.out.println(buf);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return dictionary;
    }

    public static void WriteFile(List<Map.Entry<String, Integer>> dictionary, String file) {
        try(FileWriter writer = new FileWriter(file, false)) {
            for (Map.Entry<String, Integer> value : dictionary) {
                    writer.write(value.getKey() + " => " + value.getValue()+"\n");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
