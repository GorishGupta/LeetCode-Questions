/*class Solution {
    public int findChampion(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<edges.length;i++){
            set.add(edges[i][1]);
        }
        int c=0;int ans=0;
        for(int i=0;i<n;i++){
            if(!set.contains(i)){ c++; ans=i;}
        }

        if(c>1) return -1;
        return ans;

    }
}*/
class Solution{
    public int findChampion(int n, int[][] edges){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<edges.length;i++){
            set.add(edges[i][1]);
        }
        int ans = -1;

        for(int i=0; i<n;i++){
           if(!set.contains(i)){
            if(ans == -1){
                ans = i;
            }
            else{
                return -1;
            }
           } 
        }
        return ans;
    }
}
