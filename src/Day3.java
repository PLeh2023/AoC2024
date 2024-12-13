import Input.InputReader;
import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        System.out.println(run(1));
        System.out.println(run(2));
    }
    public static int run(int choice){
        InputReader inputReader = new InputReader();
        if(choice == 1)
            return sumMultiplyTasks(findMulitplyTask(inputReader.input("Inputs/Day3_Input.txt")));
        return sumMultiplyTasks(findMultiplyTaskWithModifiers(inputReader.input("Inputs/Day3_Input.txt")));
    }
    public static ArrayList<String> findMulitplyTask(ArrayList<String> memory){
        ArrayList<String> multiplyTasks = new ArrayList<>(100);
        String regEx = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
        for (String s : memory) {
            for (int i = 0; i < s.length()-11; i++) {
                if ('m' == s.charAt(i) && 'u' == s.charAt(i+1) && 'l' == s.charAt(i+2) && '(' == s.charAt(i+3)) {
                    StringBuilder matched = new StringBuilder();
                    for (int j = 0; j < 12; j++){
                        matched.append(s.charAt(i + j));
                        if (matched.toString().matches(regEx)) {
                            multiplyTasks.add(matched.toString());
                            i += j;
                            break;
                        }
                    }
                }
            }
        }
        return multiplyTasks;
    }
    public static ArrayList<String> findMultiplyTaskWithModifiers(ArrayList<String> memory){
        ArrayList<String> multiplyTasks = new ArrayList<>(100);
        String regEx = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
        boolean enabled = true;
        for (String s : memory) {
            for (int i = 0; i < s.length(); i++) {
                if ('d' == s.charAt(i) && 'o' == s.charAt(i+1) && 'n' == s.charAt(i+2) && '\'' == s.charAt(i+3) && 't' == s.charAt(i+4) && '(' == s.charAt(i+5) && ')' == s.charAt(i+6)){
                    enabled = false;
                }
                if ('d' == s.charAt(i) && 'o' == s.charAt(i+1) && '(' == s.charAt(i+2) && ')' == s.charAt(i+3)){
                    enabled = true;
                }
                if ('m' == s.charAt(i) && 'u' == s.charAt(i+1) && 'l' == s.charAt(i+2) && '(' == s.charAt(i+3) && enabled) {
                    StringBuilder matched = new StringBuilder();
                    for (int j = 0; j < 12; j++){
                        matched.append(s.charAt(i + j));
                        if (matched.toString().matches(regEx)) {
                            multiplyTasks.add(matched.toString());
                            i += j;
                            break;
                        }
                    }
                }
            }
        }
        return multiplyTasks;
    }
    public static int sumMultiplyTasks(ArrayList<String> multiplyTasks){
        int sum = 0;
        for (int i = 0; i < multiplyTasks.size(); i++){
            String[] numbersS = multiplyTasks.get(i).replace("mul(","").replace(")","").split(",");
            sum += multiplyTask(Integer.parseInt(numbersS[0]),Integer.parseInt(numbersS[1]));
        }
        return sum;
    }
    public static int multiplyTask(int a, int b){
        return a*b;
    }

}
