package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lozinki {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, String> table = new CBHT<>(N*2);
        for(int i=1;i<=N;i++){
            String imelozinka = br.readLine();
            String[] pom = imelozinka.split(" ");
            String ime = pom[0];
            String lozinka = pom[1];
            table.insert(ime, lozinka);
        }
        while (true){
            String[] imeIlozinka = br.readLine().split("\\s+");
            if (imeIlozinka[0].equals("KRAJ")){
                break;
            }
            String ime = imeIlozinka[0];
            String lozinka = imeIlozinka[1];
            if (table.search(ime) != null){
                if (table.search(ime).element.value.equals(lozinka)){
                    System.out.println("Najaven");
                }else {
                    System.out.println("Nenajaven");
                }
            }
        }
    }
}
