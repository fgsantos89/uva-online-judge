package uvaonlinejudge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.US);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream("/home/felipe/entradas.txt")));
//        Scanner entrada = new Scanner(new FileInputStream("/home/felipe/entradas.txt"));C:\\Users\\felipe.santos\\Documents\\
//        Scanner entrada = new Scanner(System.in);
        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter saida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/felipe/saidas.txt")));

        String linha = entrada.readLine();
        while (linha != null) {
            int size = Integer.parseInt(linha);
            char matriz[][] = new char[size][size];
            for (int i = 0; i < size; i++) {
                matriz[i] = entrada.readLine().trim().toCharArray();
            }
            int menor = Integer.MIN_VALUE;
            for (int row = 0; row < size; row++) {
                for (int col = 0; col < size; col++) {
                    if (matriz[row][col] == '1') {
                        int atual = Integer.MAX_VALUE;
                        for (int baixo = 0; baixo < size; baixo++) {
                            for (int dir = 0; dir < size; dir++) {
                                if (matriz[baixo][dir] == '3') {
                                    int manhattanDistance = Math.abs(row - baixo) + Math.abs(col - dir);
                                    atual = Math.min(atual, manhattanDistance);
                                }
                            }
                        }
                        menor = Math.max(atual, menor);
                    }
                }
            }
            saida.write(menor + "\n");
            linha = entrada.readLine();
        }
        saida.flush();
    }
}
