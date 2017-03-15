
package sortowanie;

import java.util.Scanner;


public class Sortowanie {
    
    public static int podzial(int[] t, int p, int r) 
    {
        int x = t[p]; 
        int i = p, j = r, temp; 
        while (true) 
        {
            while (t[j] > x) 
            j--;
            while (t[i] < x) 
            i++;
            if (i < j) 
            {
                temp = t[i];
                t[i] = t[j];
                t[j] = temp;
                i++;
                j--;
            }
            else 
            return j;
            }
    }
    
   public static void quicksort(int[] t, int p, int r) // sortowanie szybkie
    {
        int q;
        if (p < r)
        {  
            q = podzial(t,p,r); 
            quicksort(t, p, q); 
            quicksort(t, q+1, r); 
        }
    }
 
    public static int[] babelkowe(int t[], int n){
        
        int dc = n, i, temp;
        while(dc>1){
            i = 2;
            while(i<=dc){
                if(t[i-1] > t[i]){
                    temp = t[i-1];
                    t[i-1] = t[i];
                    t[i] = temp;
                }
                i++;
            }
            dc--;
        }
        
        return t;
    }
    
    public static int[] insertsort(int t[], int n){
        int i = 1, j, p;
        while(i<=n){
            j = i - 1;
            p = t[i];
            t[0] = p;
            while(t[j] > p){
                t[j+1] = t[j];
                j--;
            }
            t[j+1] = p;
            i++;
        }
        return t;
    }
    
    
    public static void main(String[] args) {
        Scanner wczytaj = new Scanner(System.in);
        int n;
        System.out.println("Podaj dlugosc ciagu: ");
        n = wczytaj.nextInt();
        int[] tab = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            System.out.println("Podaj liczbe: ");
            tab[i] = wczytaj.nextInt();
        }
        
        //tab = babelkowe(tab, n);
        //tab = insertsort(tab, n);
            quicksort(tab, 0, n);
            
        System.out.println("\nPosortowane liczby:");
        for(int i = 1; i<=n; i++){
            System.out.println(tab[i]);
        }
        
    }
    
}
