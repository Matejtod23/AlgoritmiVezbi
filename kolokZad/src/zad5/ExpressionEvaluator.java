package zad5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        // Vasiot kod tuka
        int suma=0;
        Stack<Integer> stack =new Stack<Integer>();
        String [] niza = expression.split("\\+");
        for(int i=0;i<niza.length;i++){
            if(niza[i].contains("*")){
                String[] pom = niza[i].split("\\*");
                int proizvod=1;
                for(int j=0;j<pom.length;j++){
                    proizvod*= Integer.valueOf(pom[j]);
                }
                stack.push(proizvod);
            }
            else{
                stack.push(Integer.valueOf(niza[i]));
            }
        }
        while(!stack.isEmpty()){
            suma+=stack.pop();
        }

        return suma;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}