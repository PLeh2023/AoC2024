package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class InputReader{
    public ArrayList<String> inputToLines(String path){
        ArrayList<String> lines = new ArrayList<>(1000);
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        }catch (Exception _){}
        return lines;
    }
    public ArrayList<ArrayList<String>> inputToIID(String path){
        ArrayList<ArrayList<String>> map = new ArrayList<>(1000);
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<String> tmp = new ArrayList<>(100);
                for (int i = 0; i < line.length(); i++){
                    tmp.add(String.valueOf(line.charAt(i)));
                }
                map.add(tmp);
            }
        }catch (Exception _){}
        return map;

    }
}
