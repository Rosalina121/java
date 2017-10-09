package cwiczenia_1;

import java.util.Scanner;

public class zadanie_1 {

	public static int silnia(int n) {
        if(n==0)
            return 1;
        else
            return (n*silnia(n-1));
    }

	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			
	        int n = in.nextInt();
	        int i = 0;
	        float pierwsza;
	        pierwsza = 0;
	        for(int j=3; j<n; j++) {
	            pierwsza += (silnia(j-2) - (j * Math.floor( silnia(j-2)/j)) );
	            
	        }
	        pierwsza -= 1;
	        System.out.println("Jest: " + (int)pierwsza +" liczb pierwszych."  );
	}

}
