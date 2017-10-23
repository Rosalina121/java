
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class lab2 {

	public static enum Marka{
		POLONEZ("Polonez"), FIAT("Fiat"), SYRENA("Syrena");
		private String nazwa;
		private Marka(String nazwa1) {
			this.nazwa = nazwa1;
		}
		@Override
		public String toString() {
			return nazwa;
		}
	}
	
	
	public static class Samochod{
		Marka marka;
		int rocznik;
		double cena;
		public Samochod(){
			this.rocznik = ThreadLocalRandom.current().nextInt(1960,1990+1);
			this.cena = ThreadLocalRandom.current().nextInt(1000,6000+1);
			int rand = ThreadLocalRandom.current().nextInt(2);
			if(rand == 0) {
				this.marka = Marka.FIAT;
			}else {
				if(rand == 1) {
					this.marka = Marka.POLONEZ;
				}else {
					this.marka = Marka.SYRENA;
				}
			}
		}
		public int getRocznik() {
			return rocznik;
		}
		public String getMarka() {
			String temp = Marka.FIAT.name();
			return temp;
		}
		@Override
		public String toString() {
			return "Marka: " + this.marka.nazwa +", Cena: " + (int)this.cena + " zł, Rocznik: " + this.rocznik + ",\n";
		}
		void zwracaj(char a) {
			
		}
	}


	public static void main(String[] args) {

		EasyReader console = new EasyReader();
		
		System.out.println("Ile wylosowac samochodow? ");
		int a = console.readInt();
		System.out.println("Wybierz kryterium:\n1. Najstarszy\n2. Nie starszy niż\n3. Najmłodszy\n4. Nie młodszy niż\n");
		int choice = console.readInt();
		
		List<Samochod> auta = new ArrayList<>();
		
		for(int i=0;i<a;i++) {
			auta.add(new Samochod());
		}
		
		//sortowanie list itd itp
		
		auta.sort((o1, o2) -> Integer.compare(o1.getRocznik(), o2.getRocznik())); //sortowanie
		switch(choice) {
		case 1: 									//najstarszy
			System.out.println(auta.get(0));
			break;
		case 2: { 									//niestarszy
			System.out.println("Podaj rocznik: ");
			int yr = console.readInt();
			
			for (int i=0;i<auta.size();i++) {
				int rok = auta.get(i).rocznik;
				if(rok >= yr) {
					System.out.println(auta.get(i));
					}
			
				}
			}
			break;
		case 3: 									//najmlodszy(auta);
			System.out.println(auta.get(auta.size()-1));
			break;
		case 4: { 									//niemlodszy
			System.out.println("Podaj rocznik: ");
			int yr = console.readInt();
			
			for (int i=0;i<auta.size();i++) {
				int rok = auta.get(i).rocznik;
				if(rok <= yr) {
					System.out.println(auta.get(i));
					}
			
				}
			}
			break;
		default: //domyslne(auta);
			System.out.println(auta);
			break;
			
		}
		
		
	}


}
