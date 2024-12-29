class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1_000_000_007;
        int n = target.length();
        int m = words[0].length();
        int[][] dp = new int[n][m];
        int[][] count = new int[m][26]; // letter count
        for (String word : words) {
            for (int i = 0; i < m; i++) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        int idx = target.charAt(0) - 'a';
        for (int i = 0; i < m; i++) {
            dp[0][i] = count[i][idx]+ (i>0?dp[0][i-1]:0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < m; j++) {
                int cnt = count[j][target.charAt(i) - 'a'];
                long total = (long)dp[i-1][j-1]*(long)cnt%MOD;
                dp[i][j] = (dp[i][j] + (int)total)%MOD;
                dp[i][j] = (dp[i][j] +  + dp[i][j-1])%MOD;
            }
        }
        return dp[n - 1][m-1];
    }
}