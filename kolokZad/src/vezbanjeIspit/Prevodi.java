package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prevodi {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        OBHT<String, String> zborSoPrevodAng = new OBHT(n*2); 
        for(int i = 0; i < n; i++){
            String[] parts = bf.readLine().split(" ");
            zborSoPrevodAng.insert(parts[1], parts[0]);
        }
        while(true){
            String word = bf.readLine();
            if(word.equalsIgnoreCase("KRAJ")){
                break;
            }
            if(zborSoPrevodAng.search(word) == -1){
                System.out.println("/");
            }else{
                int index = zborSoPrevodAng.search(word);
                System.out.println(zborSoPrevodAng.getValue(index));
            }
        }
    }

}
