package zad3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka
        int brojDecaPoVoz,min,max;
        if (M == 0 || M == 1){
            min = N*100;
            max = 100*N;
        } else if (M < N) {
            min = N*100;
            max = 100*(N+M-1);
        } else if (M%N==0){
            brojDecaPoVoz = M/N;
            min = 100*(N+N*(brojDecaPoVoz-1));
            max = 100*(N+M-1);

        }else {
            brojDecaPoVoz = M/N;
            int ostanati = M - (brojDecaPoVoz * (N-1));
            min = 100*(N+(N-1)*(brojDecaPoVoz-1) + ostanati-1);
            max = 100*(N+M-1);

        }
        System.out.println(min + "\n" + max);

    }

}
