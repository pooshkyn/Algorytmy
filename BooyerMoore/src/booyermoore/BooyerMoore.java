
package booyermoore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BooyerMoore {
    private final static int alfabet = 255;
    private static int[] niepasujace = new int[alfabet];
    private static int[] pasujace;
    private static int[] znak;
    
    static void przygotowanie_niepasujacych(String wzorzec){
        int m = wzorzec.length();
        
        for(int i = 0; i < alfabet; i++){
            niepasujace[i] = m;
        }
        
        for (int i = 0; i < m-1; ++i) {
            niepasujace[wzorzec.charAt(i)] = m-i-1;           
        }
    }
    
    private static void przygotowanie_znakow(String wzorzec){
        int m = wzorzec.length();
        int j;
        znak = new int[m];
        
        znak[m-1] = m;
        for(int i = m-2; i >= 0; --i){
            for(j = 0; (j <= i) && (wzorzec.charAt(i-j) == wzorzec.charAt(m-j-1)); j++){
                znak[i] = j;
            }
        }
    }
    
    private static void przygotowanie_pasujacych(String wzorzec){
        int j = 0;
        int m = wzorzec.length();
        pasujace = new int[m];
        
        przygotowanie_znakow(wzorzec);
        
        for(int i = 0; i < m; i++){
            pasujace[i] = m;
        }
        
        for (int i = m - 1; i >= 0; --i){
            if (znak[i] == i + 1){
                for (; j < m - 1 - i; ++j){
                    pasujace[j] = m - 1 - i;
                }
            }   
        }
 
        for (int i = 0; i <= m - 2; ++i)
        {
            pasujace[m - 1 - znak[i]] = m - 1 - i;
        }
    }
    
    private static void BM(String tekst, String wzorzec){
        int i, j;
        int m = wzorzec.length();
        int n = tekst.length();
        
        przygotowanie_pasujacych(wzorzec);
        przygotowanie_niepasujacych(wzorzec);
        
        j = 0;
        while(j < n - m){
            for (i = m - 1; i >= 0 && wzorzec.charAt(i) == tekst.charAt(i + j); --i);
            if (i < 0) {
                System.out.print(j + " ");
                j += pasujace[0];
            }
            else{
                j += Math.max(pasujace[i], niepasujace[tekst.charAt(i+j)]) - m+1+i;
            }    
        }
    }
    
    public static void main(String[] args) throws IOException {
        String txt, pat;
        BufferedReader wczytaj = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj tekst: ");
        txt = wczytaj.readLine();
        System.out.println("Podaj wzrorzec: ");
        pat = wczytaj.readLine();
        
        BM(txt, pat);
    }
    
}
