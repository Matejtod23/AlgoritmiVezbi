package vezbanjeIspit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatumiRodendeni {
    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        CBHT<String, List<Vraboten>> rodByVraboten = new CBHT<>(n*2);
        for (int i = 0; i < n ;i++){
            String parts[] = bf.readLine().split("\\s+");
            Vraboten v = new Vraboten((parts[0] + " " + parts[1]), format.parse(parts[2]));
            String dataZaVoMapa = parts[2].substring(0, parts[2].length()-4);
            if (rodByVraboten.search(dataZaVoMapa) == null){
                rodByVraboten.insert(dataZaVoMapa, new ArrayList<>());
            }
            rodByVraboten.search(dataZaVoMapa).element.value.add(v);
        }
        String data = bf.readLine();
        Date d = format.parse(data);
        data = data.substring(0, data.length()-4);
        rodByVraboten.search(data).element.value.stream().sorted(Vraboten::compareTo)
                .forEach(vraboten -> {
                    System.out.print(vraboten + " ");
                    System.out.println(d.getYear() - vraboten.birthday.getYear());
                });
    }
}
class Vraboten implements Comparable<Vraboten>{
    String name;
    Date birthday;

    public Vraboten(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public int compareTo(Vraboten o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
