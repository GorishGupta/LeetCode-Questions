public class hello{
    public static void main(String args[]){
       int x = 5;
       for(int i=0;i<x;i++){
        for(int j=x-i;j>0;j--){
            System.out.print("   ");
        }
        for(int j=0;j<2*i-1;j++){
            System.out.print(" * ");
        }
        System.out.println();
       }
       for(int i=x;i>0;i--){
        for(int j=x-i;j>0;j--){
            System.out.print("   ");
        }
        for(int j=0;j<2*i-1;j++){
            System.out.print(" * ");
        }
        System.out.println();
       }
    }
}