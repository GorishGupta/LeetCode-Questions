public class Solution {
    public boolean checkifExist(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i!=j &&  0<=i && j<arr.length && arr[i] == 2*arr[j] ){
                        return true;
                }
                
            }
        }
        return false;
    }
    
}
