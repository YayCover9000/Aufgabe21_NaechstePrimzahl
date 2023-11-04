import java.util.Scanner;
public class Aufgabe21_NaechstePrimzahl {
	static Scanner sc = new Scanner(System.in);
	public static void main(String [] args) {
		
		Version1();
		Version2();
		Version3();
		
	}
	public static void Version1() {
		int zahl = 5;
		//int zahl = sc.nextint();
		int teiler = 0;
		boolean primzahl =false;
		
		zahl += 1;
		teiler = 2;
		primzahl = true;
		
		while(primzahl == true && teiler <= Math.sqrt(zahl)){
			if(zahl%teiler == 0) {
				primzahl = false;
				teiler+= 1;
			}
		}
		System.out.println("Zahl: " + zahl);
	}
	
	
	//Version 2
	public static void Version2() {
		System.out.print("Geben Sie eine Zahl ein: ");
	    int zahl = sc.nextInt();
	
	    int naechstePrimzahl = findNaechstePrimzahl(zahl);
	    System.out.println("Die naechste Primzahl nach " + zahl + " ist " + naechstePrimzahl);
	}
	
	public static boolean istPrimzahl(int zahl) {
	    if (zahl <= 1) {
	        return false;
	    }
	    
	    if (zahl <= 3) {
	        return true;
	    }
	    
	    if (zahl % 2 == 0 || zahl % 3 == 0) {
	        return false;
	    }
	    
	    for (int i = 5; i * i <= zahl; i += 6) {
	        if (zahl % i == 0 || zahl % (i + 2) == 0) {
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	public static int findNaechstePrimzahl(int start) {
	    int naechsteZahl = start + 1;
	
	    while (true) {
	        if (istPrimzahl(naechsteZahl)) {
	            return naechsteZahl;
	        }
	        naechsteZahl++;
	    }
	    
	    
	    
	}
	//Version 3
	public static void Version3() {
		
	}

	static int[] lowPrimes = { 2, 3, 5, 7 };
	public static boolean isPrime( int prime ) {
		int sqrt = (int) Math.sqrt(prime);
		int i = nextPrime(1);
		while(i<=sqrt) {
			if ( prime % i == 0 && prime != i ) return false;
			i = nextPrime(i);
		}
		return true;
	}


	public static int nextPrime( int prime ) {
	if(prime == 1) return 2;
			while ( !isPrime( ++prime ) );
			return prime;
		}
}
