package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class InputReader{
    public ArrayList input(String path){
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
}
