import Input.InputReader;
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
    public static int findXMAS(ArrayList<ArrayList<String>> map) {
        int sum = 0;
        int[][][] directions = {
                {{0, 0}, {0, 1}, {0, 2}, {0, 3}},   // Rechts
                {{0, 0}, {1, 1}, {2, 2}, {3, 3}},   // Diagonal rechts unten
                {{0, 0}, {1, 0}, {2, 0}, {3, 0}},   // Unten
                {{0, 0}, {1, -1}, {2, -2}, {3, -3}}, // Diagonal links unten
                {{0, 0}, {0, -1}, {0, -2}, {0, -3}}, // Links
                {{0, 0}, {-1, -1}, {-2, -2}, {-3, -3}}, // Diagonal links oben
                {{0, 0}, {-1, 0}, {-2, 0}, {-3, 0}}, // Oben
                {{0, 0}, {-1, 1}, {-2, 2}, {-3, 3}}  // Diagonal rechts oben
        };
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.getFirst().size(); j++) {
                if (Objects.equals(map.get(i).get(j), "X")) {
                    for (int[][] dir : directions) {
                        if (checkPattern(map, i, j, dir, "XMAS")) {
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }
    public static int findX_Mas(ArrayList<ArrayList<String>> map) {
        int sum = 0;
        int[][][] directions = {
                {{-1, 1}, {0, 0}, {1, -1}}, // Diagonal rechts unten
                {{1, 1}, {0, 0}, {-1, -1}}, // Diagonal links oben
                {{1, -1}, {0, 0}, {-1, 1}}, // Diagonal links unten
                {{-1, -1}, {0, 0}, {1, 1}}  // Diagonal rechts oben
        };
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < map.getFirst().size(); j++) {
                if (Objects.equals(map.get(i).get(j), "A")) {
                    int count = 0;
                    for (int[][] dir : directions) {
                        if (checkPattern(map, i, j, dir, "MAS")) {
                            count++;
                        }
                    }
                    if (count >= 2) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
    public static boolean checkPattern(ArrayList<ArrayList<String>> map, int i, int j, int[][] directions, String pattern) {
        StringBuilder foundPattern = new StringBuilder();
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow < 0 || newRow >= map.size() || newCol < 0 || newCol >= map.getFirst().size()) {
                return false;
            }
            foundPattern.append(map.get(newRow).get(newCol));
        }
        return foundPattern.toString().equals(pattern);
    }
}
