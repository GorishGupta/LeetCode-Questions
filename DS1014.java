import java.util.*;
class DS1014{
		public int maxScoreSightseeingPair(int[] a){
			int ans = Integer.MIN_VALUE;
			int m = a[0];
			for(int i = 1; i < a.length; i++){
				if(a[i]-i+m > ans){
					ans = a[i]-i+m;
				}
				if(a[i]+i > m){
					m = a[i]+i;
				}
			}
			return ans;
		}
	}