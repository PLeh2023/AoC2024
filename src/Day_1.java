import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Day_1 {
    public static void main(String[] args) throws Exception{
        System.out.println("First Problem: " + run(1));
        System.out.println("Second Problem: " + run(2));
    }
    public static int run(int choice)throws Exception{

        if (choice == 1)
            return sumOfDistances(sortIntegerArray(splitStringArrayIntoIntArray(input())));
        return sumOfSimilarity(sortIntegerArray(splitStringArrayIntoIntArray(input())));
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
    public static int[][] sortIntegerArray(int[][] unsortedIntegers){
        int[] leftSide = new int[unsortedIntegers.length];
        int[] rightSide = new int[unsortedIntegers.length];
        int[][] sortedIntegers = new int[leftSide.length][2];
        for (int i = 0; i < leftSide.length; i++){
            leftSide[i] = unsortedIntegers[i][0];
            rightSide[i] = unsortedIntegers[i][1];
        }
        Arrays.sort(leftSide);
        Arrays.sort(rightSide);
        for (int i = 0; i < leftSide.length; i++){
            sortedIntegers[i][0] = leftSide[i];
            sortedIntegers[i][1] = rightSide[i];
        }
        return sortedIntegers;
    }
    public static int sumOfDistances(int[][] sortedIntegers){
        int result = 0;
        for (int i = 0; i < sortedIntegers.length; i++){
            int left = sortedIntegers[i][0];
            int right = sortedIntegers[i][1];
            result += Math.max(left,right) - Math.min(left,right);
        }
        return result;
    }
    public static int sumOfSimilarity(int[][] sortedIntegers){
        int result = 0;

        int j = 0;
        for (int i = 0; i < sortedIntegers.length;){
            if (sortedIntegers[i][0] < sortedIntegers[j][1]){
                i++;
            } else if (sortedIntegers[i][0] > sortedIntegers[j][1]) {
                j++;
            }else{
                int tmpCounter = 0;
                while(sortedIntegers[i][0] == sortedIntegers[j][1]){
                    tmpCounter++;
                    j++;
                    if (j >= 1000)break;
                }
                result += (sortedIntegers[i][0] * tmpCounter);
            }
            if (j >= 1000)break;
        }
        return result;
    }
}