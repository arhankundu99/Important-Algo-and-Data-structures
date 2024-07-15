// https://www.geeksforgeeks.org/maximum-number-of-accepted-invitations-to-party/

import java.util.Arrays;

public class Main {
    static boolean dfs(int[][] invitationMatrix, int boy, int[] girls, boolean[] visited) {
        
        if (visited[boy]) {
            return false;
        }
        
        visited[boy] = true;
        for (int i = 0; i < invitationMatrix[0].length; i++) {
            if (invitationMatrix[boy][i] == 1) {
                if (girls[i] == -1 || dfs(invitationMatrix, girls[i], girls, visited)) {
                    girls[i] = boy;
                    return true;
                }
            }
        }
        return false;
    }
    // Function to find the maximum number of invitations
    static int maximumInvitations(int[][] invitationMatrix) {
        int[] girls = new int[invitationMatrix[0].length];
        Arrays.fill(girls, -1);
        for (int boy = 0; boy < invitationMatrix.length; boy++) {
            boolean[] visited = new boolean[invitationMatrix.length];
            dfs(invitationMatrix, boy, girls, visited);
        }
        int count = 0;
        for (int i = 0; i < girls.length; i++) {
            if (girls[i] != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Define the invitation matrix
        int[][] invitationMatrix = {{1, 1, 1}, {1, 0, 1}, {0, 0, 1}};

        // Call the maximumInvitations function and store the result
        int totalInvitations = maximumInvitations(invitationMatrix);

        // Print the result
        System.out.println("The maximum possible number of accepted invitations is: " + totalInvitations);
    }
}