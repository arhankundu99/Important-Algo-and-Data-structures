// https://leetcode.com/problems/maximum-number-of-accepted-invitations/description/
// Time complexity: O(M∗N^2) where M is grid.length and N is grid[0].length
// Space complexity: O(M∗N)
class Solution {
    public int maximumInvitations(int[][] grid) {
        Map<Integer, Integer> matches = new HashMap<>();

        for (int boy = 0; boy < grid.length; boy++) {
            dfs(grid, boy, matches, new HashSet<>());
        }

        return matches.size();
    }

    private boolean dfs(int[][] grid, int boy, Map<Integer, Integer> matches, Set<Integer> visited) {
        for (int girl = 0; girl < grid[0].length; girl++) {
            // if currboy can be matched with the girl
            if (grid[boy][girl] == 1 && !visited.contains(girl)) {
                visited.add(girl);

                // Check if there are no matches or if there is any match, then check if the other boy match can be assigned another girl
                if (!matches.containsKey(girl) || dfs(grid, matches.get(girl), matches, visited)) {
                    matches.put(girl, boy);
                    return true;
                }
            }
        }
        return false;
    }
}