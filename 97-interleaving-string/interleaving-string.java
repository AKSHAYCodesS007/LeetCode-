class Solution {
    private String s1, s2, s3;
    private byte[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        memo = new byte[s1.length() + 1][s2.length() + 1];

        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        if (i == s1.length() && j == s2.length()) return true;

        if (memo[i][j] != 0) return memo[i][j] == 1;

        int k = i + j;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && dfs(i + 1, j)) {
            memo[i][j] = 1;
            return true;
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k) && dfs(i, j + 1)) {
            memo[i][j] = 1;
            return true;
        }

        memo[i][j] = -1;
        return false;
    }
}