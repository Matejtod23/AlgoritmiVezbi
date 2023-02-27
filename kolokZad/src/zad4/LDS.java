package zad4;

import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {
        int count = 1,maxCount = 1;
        for (int i = 0; i < a.length; i++){
            int tmp = a[i];
            for (int j = i+1;j<a.length;j++){
                for (int k=j;k<a.length;k++){
                    if (tmp > a[k]){
                        tmp = a[k];
                        count++;
                    }
                }
                if (maxCount<count){
                    maxCount = count;
                }
                count = 1;
                tmp=a[i];
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}

