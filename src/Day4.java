import Input.InputReader;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Objects;

public class Day4 {
    public static void main(String[] args) {
        System.out.println("First Problem: " + run(1));
        System.out.println("Second Problem: " + run(2));
    }
    public static int run(int choice){
        InputReader inputReader = new InputReader();
        if (choice == 1) {
            return findXMAS(inputReader.inputToIID("Inputs/Day4_Input.txt"));
        }
        return findX_Mas(inputReader.inputToIID("Inputs/Day4_Input.txt"));
    }
    public static int findXMAS(ArrayList<ArrayList<String>> map){
       int sum = 0;
        for (int i = 0; i < map.size(); i++){
           for (int j = 0; j < map.getFirst().size(); j++){
               if (Objects.equals(map.get(i).get(j), "X")){
                   //right
                   try {if (Objects.equals(map.get(i).get(j) + map.get(i).get(j+1) + map.get(i).get(j+2) + map.get(i).get(j+3), "XMAS")) {sum += 1;}}catch (Exception _){}
                   //right down
                   try {if (Objects.equals(map.get(i).get(j) + map.get(i+1).get(j+1) + map.get(i+2).get(j+2) + map.get(i+3).get(j+3), "XMAS")) {sum += 1;}}catch (Exception _){}
                   //down
                   try {if (Objects.equals(map.get(i).get(j) + map.get(i+1).get(j) + map.get(i+2).get(j) + map.get(i+3).get(j), "XMAS")) {sum += 1;}}catch (Exception _){}
                   //left down
                   try {if (Objects.equals(map.get(i).get(j) + map.get(i+1).get(j-1) + map.get(i+2).get(j-2) + map.get(i+3).get(j-3), "XMAS")) {sum += 1;}}catch (Exception _){}
                   //left
                   try {if (Objects.equals(map.get(i).get(j) + map.get(i).get(j-1) + map.get(i).get(j-2) + map.get(i).get(j-3), "XMAS")) {sum += 1;}}catch (Exception _){}
                   //left up
                   try {if (Objects.equals(map.get(i).get(j) + map.get(i-1).get(j-1) + map.get(i-2).get(j-2) + map.get(i-3).get(j-3), "XMAS")) {sum += 1;}}catch (Exception _){}
                   //up
                   try {if (Objects.equals(map.get(i).get(j) + map.get(i-1).get(j) + map.get(i-2).get(j) + map.get(i-3).get(j), "XMAS")) {sum += 1;}}catch (Exception _){}
                   //right up
                   try {if (Objects.equals(map.get(i).get(j) + map.get(i-1).get(j+1) + map.get(i-2).get(j+2) + map.get(i-3).get(j+3), "XMAS")) {sum += 1;}}catch (Exception _){}
               }
           }
       }
        return sum;
    }
    public static int findX_Mas(ArrayList<ArrayList<String>> map){
        int sum = 0;
        for (int i = 0; i < map.size(); i++){
            for (int j = 0; j < map.getFirst().size(); j++){
                if (Objects.equals(map.get(i).get(j), "A")){
                    //right MMs
                    try{if (Objects.equals(map.get(i-1).get(j+1) + map.get(i).get(j) + map.get(i+1).get(j-1), "MAS") && Objects.equals(map.get(i+1).get(j+1) + map.get(i).get(j) + map.get(i-1).get(j-1), "MAS")){sum += 1;}}catch (Exception _){}
                    //down MMs
                    try{if (Objects.equals(map.get(i+1).get(j+1) + map.get(i).get(j) + map.get(i-1).get(j-1), "MAS") && Objects.equals(map.get(i+1).get(j-1) + map.get(i).get(j) + map.get(i-1).get(j+1), "MAS")){sum += 1;}}catch (Exception _){}
                    //left MMs
                    try{if (Objects.equals(map.get(i+1).get(j-1) + map.get(i).get(j) + map.get(i-1).get(j+1), "MAS") && Objects.equals(map.get(i-1).get(j-1) + map.get(i).get(j) + map.get(i+1).get(j+1), "MAS")){sum += 1;}}catch (Exception _){}
                    //up MMs
                    try{if (Objects.equals(map.get(i-1).get(j-1) + map.get(i).get(j) + map.get(i+1).get(j+1), "MAS") && Objects.equals(map.get(i-1).get(j+1) + map.get(i).get(j) + map.get(i+1).get(j-1), "MAS")){sum += 1;}}catch (Exception _){}
                }
            }
        }
        return sum;
    }
}
