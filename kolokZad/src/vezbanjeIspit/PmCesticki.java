package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PmCesticki {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        CBHT<String, Array<Double>> merenjaByOpstina = new CBHT<>(n*2);
        for (int i = 0; i<n;i++){
            String[] parts = bf.readLine().split("\\s+");
            if (merenjaByOpstina.search(parts[0]) == null){
                merenjaByOpstina.insert(parts[0], new Array<>(n));
                merenjaByOpstina.search(parts[0]).element.value.insertLast(Double.valueOf(parts[1]));
            }else {
                merenjaByOpstina.search(parts[0]).element.value.insertLast(Double.valueOf(parts[1]));
            }
        }
        String opstina = bf.readLine();
        double messures = 0;
        for (int i = 0; i < merenjaByOpstina.search(opstina).element.value.getSize(); i++){
            messures += merenjaByOpstina.search(opstina).element.value.get(i);
        }
        System.out.println(messures / merenjaByOpstina.search(opstina).element.value.getSize());
    }
}
