package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class zadaca_kolok {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        CBHT<String, Vozac> vozaciByreg = new CBHT<>(n*2);
        List<Vozac> vozaciByKazna = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        for (int i = 0; i < n; i++){
            String parts[] = bf.readLine().split("\\s+");
            Vozac v = new Vozac(parts[1], parts[2], new Date());
            vozaciByreg.insert(parts[0], v);
        }
        int speed = Integer.parseInt(bf.readLine());
        String[] info = bf.readLine().split("\\s+");
        for (int i = 0; i < info.length; i+=3){
            if (i+3 > info.length){
                break;
            }
            int speedByDriver = Integer.parseInt(info[i+1]);
            if (speedByDriver > speed){
                Vozac v = vozaciByreg.search(info[i]).element.value;
                v.time = format.parse(info[i+2]);
                vozaciByKazna.add(v);
            }
        }
        vozaciByKazna.sort(Vozac::compareTo);
        for (int i = 0; i < vozaciByKazna.size(); i++){
            System.out.println(vozaciByKazna.get(i).toString());
        }
    }

}
class Vozac implements Comparable<Vozac>{
    String ime;
    String prezime;
    Date time;

    public Vozac(String ime, String prezime,Date time) {
        this.ime = ime;
        this.prezime = prezime;
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public int compareTo(Vozac o) {
        return this.time.compareTo(o.time);
    }
}
