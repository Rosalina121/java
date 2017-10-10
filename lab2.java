package labolatoria_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class zadanie_1 {

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
		public String getMarka() {
			String temp = Marka.FIAT.name();
			return temp;
		}
		@Override
		public String toString() {
			return "Marka: " + this.marka.nazwa +" Cena: " + (int)this.cena + " Rocznik: " + this.rocznik + "\n";
		}
		void zwracaj(char a) {
			
		}
	}
	
	public static void najstarszy(List list) {
		
	}
	public static void niestarszy(List list) {
		
	}
	public static void najmlodszy(List list) {
		
	}
	public static void niemlodszy(List list) {
		
	}
	public static void domyslne(List list) {
		System.out.println(list);
	}
	
	public static void main(String[] args) {

		EasyReader console = new EasyReader();
		
		System.out.println("Ile wylosowac samochodow? ");
		int a = console.readInt();
		System.out.println("Wybierz kryterium:\n1. Najstarszy\n2. Nie starszy ni¿\n3. Najm³odszy\n4. Nie m³odszy ni¿\n");
		int choice = console.readInt();
		
		List<Samochod> auta = new ArrayList<>();
		
		for(int i=0;i<a;i++) {
			auta.add(new Samochod());
		}
		
		//sortowanie list itd itp
		
		switch(choice) {
		case 1:
			najstarszy(auta);
			break;
		case 2:
			niestarszy(auta);
			break;
		case 3:
			najmlodszy(auta);
			break;
		case 4:
			niemlodszy(auta);
			break;
		default:
			
		}
		
		
	}


}
