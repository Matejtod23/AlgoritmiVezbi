package vezbanjeIspit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TelephoneLetterCombo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nums = input.nextLine();
        HashMap<Integer, List<Character>> charsByNum = new HashMap<>();
        int code = 97;
        for(int i = 2; i <= 9; i++){
            charsByNum.put(i, new ArrayList<>());
            if(i == 9 || i == 7){
                int num = 4;
                while(num != 0){
                    charsByNum.get(i).add((char) code);
                    num--;
                    code++;
                }
            }else{
                int num = 3;
                while(num != 0){
                    charsByNum.get(i).add((char) code);
                    num--;
                    code++;
                }
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < nums.length();i++){
            int nToGet = Integer.parseInt(String.valueOf(nums.charAt(i)));
            charsByNum.get(nToGet).stream().forEach(letter -> {
                int index = 0;
                String s = letter.toString();
                for (int j = 1; j < nums.length(); j++){
                    int nToget = Integer.parseInt(String.valueOf(nums.charAt(j)));
                    s += charsByNum.get(nToget).get(index);
                }
                res.add(s);
            });
        }
    }
}
