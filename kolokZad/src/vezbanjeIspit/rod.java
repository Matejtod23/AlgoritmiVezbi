package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class rod {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        CBHT<Integer, String> imeByRod = new CBHT<>(n*2);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yy");
        for (int i = 0; i < n;i++){
            String[] parts = bf.readLine().split("\\s+");
            int m = format.parse(parts[1]).getMonth();
            if (imeByRod.search(m+1) == null){
                imeByRod.insert(m + 1, parts[0]);
            }else {
                imeByRod.search(m+1).succ.element = new MapEntry<>(m+1, parts[0]);
            }
        }
        int month = Integer.parseInt(bf.readLine());
        SLLNode<MapEntry<Integer, String>> first = imeByRod.search(month);
        if (first == null){
            System.out.println("nema takov mesec");
        }else {
            while (first != null){
                System.out.print(first.element.value+ " ");
                first = first.succ;
            }
        }
    }
}
