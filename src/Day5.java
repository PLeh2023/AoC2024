import Input.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day5 {
    public static void main(String[] args) {
        System.out.println("First Problem: " + run(1));
        System.out.println("Second Problem: " + run(2));
    }
    public static int run(int choice){
        return manageInput(new InputReader().inputToLines("Inputs/Day5_Input.txt"),choice);
    }
    public  static int manageInput(ArrayList<String> input,int choice){
        boolean isInManuel = false;
        List<int[]> rules = new ArrayList<>(1000);
        List<List<Integer>> manuels = new ArrayList<>(1000);
        int sum = 0;
        for(String line : input){
            if (isInManuel){
                String[] tmp = line.split(",");
                List<Integer> manuel = new ArrayList<>();
                for (String string : tmp) {
                    manuel.add(Integer.parseInt(string));
                }
                manuels.add(manuel);
            }else{
                if (line.trim().isEmpty()){
                    isInManuel = true;
                    continue;
                }
                String[] tmp = line.split("\\|");
                rules.add(new int[]{Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1])});
            }
        }
        for (List<Integer> manuel : manuels){
            if(choice == 1) {
                if (isValidManuel(rules, manuel)) {
                    sum += getMiddleNumber(manuel);
                }
            }else{
                if (!isValidManuel(rules, manuel)) {
                    while (!makeValidManuel(rules, manuel)) {
                        makeValidManuel(rules, manuel);
                    }
                    sum += getMiddleNumber(manuel);
                }
            }
        }
        return sum;
    }
    public static boolean isValidManuel(List<int[]> rules, List<Integer> manuel){
        for (int number : manuel){
            for (int[] rule : rules){
               if (Objects.equals(number,rule[0]) || Objects.equals(number,rule[1])) {
                   boolean good = Objects.equals(number, rule[0]) ? ruleOK(manuel, number, rule[1], false) : ruleOK(manuel, number, rule[0], true);
                   if (!good) return false;
               }
            }
        }
        return true;
    }
    public static int getMiddleNumber(List<Integer> manuel){
        return manuel.get(manuel.size()/2);
    }
    public static boolean ruleOK(List<Integer> manuel, int manuelNumber, int ruleNumber, boolean behind){
        if (!manuel.contains(ruleNumber))return true;
        if (behind) return manuel.indexOf(manuelNumber) > manuel.indexOf(ruleNumber);
        return manuel.indexOf(manuelNumber) < manuel.indexOf(ruleNumber);
    }
    public static boolean makeValidManuel(List<int[]> rules, List<Integer> manuel){
        for (int number : manuel){
            for (int[] rule : rules){
                if (Objects.equals(number,rule[0]) || Objects.equals(number,rule[1])) {
                    boolean good = Objects.equals(number, rule[0]) ? ruleOK(manuel, number, rule[1], false) : ruleOK(manuel, number, rule[0], true);
                    if (!good) {
                        int tmp = manuel.get(manuel.indexOf(rule[0]));
                        manuel.set(manuel.indexOf(rule[0]),manuel.get(manuel.indexOf(rule[1])));
                        manuel.set(manuel.indexOf(rule[1]),tmp);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
