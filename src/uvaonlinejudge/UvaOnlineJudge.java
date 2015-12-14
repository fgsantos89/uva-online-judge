package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class UvaOnlineJudge {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(
                System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(
//                new FileInputStream("/home/felipe/entradas.txt")));
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
                System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream("/home/felipe/saida.txt")));
        String linha = entrada.readLine();
        boolean primeira = true;
        while (linha != null) {
            String ret = "";
            for (char c : linha.toCharArray()) {
                if (c == '\"' && primeira) {
                    ret += "`";
                    ret += "`";
                    primeira = !primeira;
                } else if (c == '\"' && !primeira) {
                    ret += "'";
                    ret += "'";
                    primeira = !primeira;
                } else {
                    ret += c;
                }
            }
            saida.write(ret);
            linha = entrada.readLine();
            saida.newLine();
        }
        saida.flush();
    }
}
