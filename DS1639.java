class Solution {
    public int numWays(String[] words, String target) {
        int MOD = 1_000_000_007;
        int n = target.length();
        int m = words[0].length();
        // [i][j] ith letter in target, jth letter in word
        // number of ways form [0:i] in target, using [0:j] letter in words
        // add all result from 0 to j to save the time that we sum it again
        int[][] dp = new int[n][m];
        // [i][j]- ith letter in word, j-letter, 0~25
        // count of the letters
        int[][] count = new int[m][26]; // letter count

        // int l = words.length;
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
            // from i, not possible to form target i by using letters in words before i
            for (int j = i; j < m; j++) {
                int cnt = count[j][target.charAt(i) - 'a'];

                /*
                int cnti1 = 0;
                for (int k = 0; k < j; k++) {
                    cnti1 = (cnti1 + dp[i - 1][k]) % MOD;
                }
                long total = (long) cnti1 * (long) cnt % MOD;
                dp[i][j] = (dp[i][j] + (int) total) % MOD;
                */
                // if cnt == 0, just add [j-1] to [j]
                long total = (long)dp[i-1][j-1]*(long)cnt%MOD;
                dp[i][j] = (dp[i][j] + (int)total)%MOD;
                dp[i][j] = (dp[i][j] +  + dp[i][j-1])%MOD;
            }
        }
        /*
        int res = 0;
        for (int j = 0; j < m; j++) {
            res = (res + dp[n - 1][j]) % MOD;
        }*/
        return dp[n - 1][m-1];
    }
}