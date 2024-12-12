import java.util.*;
class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        int n = gifts.length;
        Arrays.sort(gifts);

        while(k > 0){
            gifts[n-1] = (int) Math.sqrt(gifts[n-1]);
            Arrays.sort(gifts);
            k--;
        }
        for(int i=0;i<n;i++){
            ans += gifts[i];
        }
        return ans;

    }
}