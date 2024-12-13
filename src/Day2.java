import Input.InputReader;
import java.util.ArrayList;

public class Day2 {
    public static void main(String[] args){
        System.out.println(run(1));
        System.out.println(run(2));
    }
    public static int run(int choice){
        InputReader inputReader = new InputReader();
        return countSafeReport(splitStringArrayIntoIntArray(inputReader.input("Inputs/Day2_Input.txt")),choice);
    }
    public static ArrayList<ArrayList<Integer>> splitStringArrayIntoIntArray(ArrayList<String> lists){
        ArrayList<ArrayList<Integer>> reports = new ArrayList<>(lists.size());
        for (String list : lists) {
            String[] tmpArray = list.split(" ");
            ArrayList<Integer> tmpIntArray = new ArrayList<>();
            for (String number : tmpArray) {
                tmpIntArray.add(Integer.parseInt(number));
            }
            reports.add(tmpIntArray);
        }
        return reports;
    }
    public static int countSafeReport(ArrayList<ArrayList<Integer>> reports, int choice){
        int safeReports = 0;
        for (ArrayList<Integer> report : reports) {
            if (choice == 1){
                if (isSafeReport(report)) safeReports++;
            }else{
                if (isSafeReportWithFailure(report)) safeReports++;
            }
        }
        return safeReports;
    }
    public static boolean isSafeReport(ArrayList<Integer> report){
        if (isDescending(report.get(0),report.get(1))){
            for (int i = 0; i < report.size()-1; i++) {
                if (!(isSafeStepDescending(report.get(i), report.get(i + 1)))){
                    return false;
                }
            }
        }else {
            for (int i = 0; i < report.size()-1; i++) {
                if (!(isSafeStepAscending(report.get(i), report.get(i + 1)))){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSafeReportWithFailure(ArrayList<Integer> report){
        if (isSafeReport(report)) return true;
        for (int i = 0; i < report.size(); i++) {
            ArrayList<Integer> report2 = new ArrayList<>(report);
            report2.remove(i);
            if (isSafeReport(report2)) {
                return true;
            }
        }

        return false;
    }
    public static boolean isDescending(int a, int b){
        return a > b;
    }
    public static boolean isSafeStepDescending(int a, int b){
        return 0 < a-b && 4 > a-b;
    }
    public static boolean isSafeStepAscending(int a, int b){
        return 0 < b-a && 4 > b-a;
    }
}
