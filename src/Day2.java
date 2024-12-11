import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args) {

    }
    public static int run(){

        return -1;
    }
    public static ArrayList input() throws Exception{
        ArrayList<String> lines = new ArrayList<>(1000);
        File file = new File("Inputs/Day1_Input.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null){
            lines.add(line);
        }
        return lines;
    }
    public static int[][] splitStringArrayIntoIntArray(ArrayList list){
        int[][] unsortedIntegers = new int[list.size()][2];
        for (int i = 0; i < unsortedIntegers.length;i++){
            String tmp = (String) list.get(i);
            String[] tmpArray = tmp.replace("   ",";").split(";");
            unsortedIntegers[i][0] = Integer.parseInt(tmpArray[0]);
            unsortedIntegers[i][1] = Integer.parseInt(tmpArray[1]);
        }
        return unsortedIntegers;
    }
}
