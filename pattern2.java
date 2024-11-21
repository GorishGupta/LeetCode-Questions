public class pattern2 {
    public static void main(String[] args) {
        int x =7;
        for(int i=0;i<x;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            for(int j=x;j>=0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
