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
        if (choice == 1) {
            for (ArrayList<Integer> report : reports) {
                if (report.get(0) < report.get(1)) {
                    if (isSafeReport(report, false)) safeReports++;
                } else if (report.get(0) > report.get(1)) {
                    if (isSafeReport(report, true)) safeReports++;
                }
            }
        }else{
            for (ArrayList<Integer> report : reports) {
                ArrayList<Integer> report2 = new ArrayList<>(report);
                if (report.get(0) < report.get(1)) {
                    if (isSafeReportWithFailure(report2, false)) safeReports++;
                    else if (isSafeReportWithFailure2(report, false)) safeReports++;
                } else if (report.get(0) > report.get(1)) {
                    if (isSafeReportWithFailure(report2, true)) safeReports++;
                    else if (isSafeReportWithFailure2(report, true)) safeReports++;
                }
            }
        }
        return safeReports;
    }
    public static boolean isSafeReport(ArrayList<Integer> report, boolean desc){
        for (int i = 0; i < report.size()-1; i++){
            if (desc){
                if (!(0 < report.get(i) - report.get(i + 1) && 4 > report.get(i) - report.get(i + 1))){
                    return false;
                }
            }else{
                if (!(0 < report.get(i + 1) - report.get(i) && 4 > report.get(i + 1) - report.get(i))){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isSafeReportWithFailure(ArrayList<Integer> report, boolean desc){
        int counter = 0;
        for (int i = 0; i < report.size()-1; i++){
            if (desc){
                if (!(0 < report.get(i) - report.get(i + 1) && 4 > report.get(i) - report.get(i + 1))){
                    report.remove(i);
                    counter++;
                    i=-1;
                }
            }else{
                if (!(0 < report.get(i + 1) - report.get(i) && 4 > report.get(i + 1) - report.get(i))){
                    report.remove(i);
                    counter++;
                    i=-1;
                }
            }
        }
        return counter <= 1;
    }
    public static boolean isSafeReportWithFailure2(ArrayList<Integer> report, boolean desc){
        int counter = 0;
        for (int i = 0; i < report.size()-1; i++){
            if (desc){
                if (!(0 < report.get(i) - report.get(i + 1) && 4 > report.get(i) - report.get(i + 1))){
                    report.remove(i+1);
                    counter++;
                    i=-1;
                }
            }else{
                if (!(0 < report.get(i + 1) - report.get(i) && 4 > report.get(i + 1) - report.get(i))){
                    report.remove(i+1);
                    counter++;
                    i=-1;
                }
            }
        }
        return counter <= 1;
    }
}
