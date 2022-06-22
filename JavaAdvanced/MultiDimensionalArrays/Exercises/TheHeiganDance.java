package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class TheHeiganDance {
    public static boolean isCloudHit = false;
    public static double playerHealth = 18_500;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[15][15];

        int[] playerPosition = new int[]{7, 7};

        double heiganHealth = 3_000_000;

        double damageToHeigan = Double.parseDouble(scanner.nextLine());

        String spellWhoKillsPlayer = "";


        while (heiganHealth > 0 && playerHealth > 0) {
            String[] castSpell = scanner.nextLine().split("\\s+");
            String spell = castSpell[0];
            int row = Integer.parseInt(castSpell[1]);
            int col = Integer.parseInt(castSpell[2]);

            if (isCloudHit) {
                playerHealth -= 3500;
                isCloudHit = false;
                if (playerHealth <= 0) {
                    spellWhoKillsPlayer = "Plague Cloud";
                    heiganHealth -= damageToHeigan;
                    break;
                }
            }


            heiganHealth -= damageToHeigan;
            if (heiganHealth <= 0) {
                break;
            }
            fillDamagedArea(matrix, row, col, 1);
            switch (spell) {
                case "Cloud":
                case "Eruption":
                    spellWhoKillsPlayer = spell.equals("Cloud") ? "Plague Cloud" : "Eruption";
                    if (matrix[playerPosition[0]][playerPosition[1]] == 1) {
                        move(matrix, playerPosition, spell);
                    }
                    break;
            }
            fillDamagedArea(matrix, row, col, 0);
        }

        //First line
        //print heigan status
        if (heiganHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n", heiganHealth);
        }

        //Second line
        //print player status
        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s%n", spellWhoKillsPlayer);
        } else {
            System.out.printf("Player: %.0f%n", playerHealth);
        }

        //Third line
        //print coordinates of player
        System.out.printf("Final position: %d, %d%n", playerPosition[0], playerPosition[1]);
    }

    private static boolean playerIsHit(int[][] matrix, int[] playerPosition) {
        return playerPosition[0] - 1 >= 0 && matrix[playerPosition[0] - 1][playerPosition[1]] == 1
                || playerPosition[1] + 1 < 15 && matrix[playerPosition[0]][playerPosition[1] + 1] == 1
                || playerPosition[0] + 1 < 15 && matrix[playerPosition[0] + 1][playerPosition[1]] == 1
                || playerPosition[1] - 1 >= 0 && matrix[playerPosition[0]][playerPosition[1] - 1] == 1;
    }

    private static void move(int[][] matrix, int[] playerPosition, String spell) {

        if (playerPosition[0] - 1 >= 0) {
            if (matrix[playerPosition[0] - 1][playerPosition[1]] != 1) {
                playerPosition[0]--;
                return;
            }
        }

        if (playerPosition[1] + 1 < 15) {
            if (matrix[playerPosition[0]][playerPosition[1] + 1] != 1) {
                playerPosition[1]++;
                return;
            }
        }

        if (playerPosition[0] + 1 < 15) {
            if (matrix[playerPosition[0] + 1][playerPosition[1]] != 1) {
                playerPosition[0]++;
                return;
            }
        }
        if (playerPosition[1] - 1 >= 0) {
            if (matrix[playerPosition[0]][playerPosition[1] - 1] != 1) {
                playerPosition[1]--;
                return;
            }
        }

        switch (spell) {
            case "Cloud":
                playerHealth -= 3500;
                isCloudHit = true;
                break;
            case "Eruption":
                playerHealth -= 6000;
                break;
        }


    }

    //TODO later check
    private static boolean playerCannotMove(int[][] matrix, int[] playerPosition) {
        return playerPosition[0] - 1 >= 0 && matrix[playerPosition[0] - 1][playerPosition[1]] == 1
                && playerPosition[1] + 1 < 15 && matrix[playerPosition[0]][playerPosition[1] + 1] == 1
                && playerPosition[0] + 1 < 15 && matrix[playerPosition[0] + 1][playerPosition[1]] == 1
                && playerPosition[1] - 1 >= 0 && matrix[playerPosition[0]][playerPosition[1] - 1] == 1;
    }

    private static void fillDamagedArea(int[][] matrix, int row, int col, int v) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (inMatrix(matrix, i, j)) {
                    matrix[i][j] = v;
                }
            }
        }
    }

    private static boolean inMatrix(int[][] matrix, int i, int j) {
        return i >= 0 && i < 15 && j >= 0 && j < 15;
    }
}
