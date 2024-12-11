import java.util.*;
class Solution {
    public int maximumBeauty(int[] nums, int k) {
      //bubble sort
      for(int i=1;i<=nums.length;i++){
        for(int j=0;j<nums.length - i;j++){
            while(nums[j] > nums[j+1]){
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
    }
    //inbuild sorting
   // Arrays.sort(nums);   
     Arrays.sort(nums);
        int i=0,j,n= nums.length;
        for(j=0;j<n;j++){
            if(nums[j] - nums[i] > k*2){
                i++;
            }
        }
        return j-i;
    }
}