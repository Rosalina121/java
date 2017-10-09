package cwiczenia_1;

import java.util.Scanner;

public class zadanie_2 {

	public static int kolejna(int n) {
	        if(n%2==0) {
	            n = n/2;
	        }else {
	            n = n*3+1;
	        }
	        return n;
	    }
	    
	    public static Boolean parzyste(int n) {
	        Boolean parz;
	        if(n%2==0) {
	            parz = true;
	        }else {
	            parz = false;
	        }
	        return parz;
	    }
	    
	    public static void main(String[] args) {
	    	Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int i = 0;
	        do {
	            if(parzyste(n)) {
	                System.out.println(n+", parzysta," + kolejna(n));
	            }else {
	                System.out.println(n+", nieparzysta" + kolejna(n));
	            }
	            if(kolejna(n)>Integer.MAX_VALUE) {
	            	break;
	            }
	              n = kolejna(n);
	            i++;
	        }while(n!=1 && i<1000);
	    }
}
