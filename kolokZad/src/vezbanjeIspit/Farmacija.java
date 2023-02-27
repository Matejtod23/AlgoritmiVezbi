package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Farmacija {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        CBHT<String, List<Lek>> lekoviPoNamena = new CBHT<>(n*2);
        for (int i = 0; i < n; i++) {
            String[] parts = bf.readLine().split("\\s+");
            Lek l = new Lek(parts[0], parts[1], Integer.parseInt(parts[2]));
            if (lekoviPoNamena.search(parts[1]) == null){
                lekoviPoNamena.insert(parts[1], new ArrayList<>());
            }
            lekoviPoNamena.search(parts[1]).element.value.add(l);
        }
        String namena = bf.readLine();
        lekoviPoNamena.search(namena).element.value.sort(Lek::compareTo);
        String imeNaLek = lekoviPoNamena.search(namena).element.value.get(0).ime;
        System.out.println(imeNaLek);
    }
}
class Lek implements Comparable<Lek>{
    String ime;
    String namena;
    int cena;

    public Lek(String ime, String namena, int cena) {
        this.ime = ime;
        this.namena = namena;
        this.cena = cena;
    }

    @Override
    public int compareTo(Lek o) {
        return Integer.compare(cena, o.cena);
    }
}