class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int min = 0;
        int max = Integer.MAX_VALUE;
        while(min + 1 < max){
            int mid = (max - min) / 2 + min;
            int count =0;
            for(int a : nums){
                count += ( a - 1) / mid;
            }
            if(count <= maxOperations){
                max = mid;
            }
            else{
                min = mid;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        return max;
    }
}