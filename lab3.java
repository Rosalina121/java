
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
public class lab3 {

	public static class Item{
		String name;
		int code;
		int price;
		public Item(String n, int p, int c) {
			name = n;
			price = p;
			code = c;
			
		}
		@Override
		public String toString() {
			return price + "\n" + code + "\n" + name + "\n";
		}
	}
	
	static List<Item> magazyn = new ArrayList<>();
	static List<Item> koszyk = new ArrayList<>();
	static EasyReader console = new EasyReader();
	
	public static void cout(String str) {
		System.out.println(str);
	}
	
	public static void dodajArtykul(Item item) {
		magazyn.add(item);
	}
	
	public static void pobierzArtykul(Item item, int i) {
		koszyk.add(item);
	}
	
	public static int wycenaZamowienia(List<Item> lista) { //przyjmuje koszyk
		int fullPrice = 0;
		for(int i=0; i<lista.size(); i++) {
			 fullPrice += lista.get(i).price;
		 }
		return fullPrice;
	}
	
	public static void realizujZamowienie() {
		for(int i=0; i<magazyn.size(); i++) {
			for(int j=0; i<koszyk.size(); j++) {
				if(magazyn.get(i)==koszyk.get(j)) magazyn.remove(i);
			}
		}
	}
	
	public static void updateFile() {
		try {
			PrintWriter writer = new PrintWriter("data.txt","UFT=8");
			for(int i=0; i<magazyn.size(); i++) {
				writer.println(magazyn.get(i).toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void znajdzArtykul(String name) {

		for(int i=0; i<magazyn.size() ;i++) {
			if(magazyn.get(i).name == name) {
				cout("Artykul: " + name + " jest w magazynie. Dodac do koszyka? (y/n) ");
				if(console.readChar() == 'y') {
					pobierzArtykul(magazyn.get(i),i);
				}
			}
		}
	}
	
	public static int LinesInFile() {
		EasyReader file = new EasyReader("dane.txt");
		int lines = 0;
		while (file.readLine() != null) lines++;
		file.close();
		return lines/3;
	}
	
	public static void main(String[] args) {
		EasyReader inFile = new EasyReader("dane.txt");
		
		for(int i=0; i<LinesInFile(); i++) {
			String nameTemp = inFile.readLine();
			int priceTemp = Integer.parseInt(nameTemp);
			nameTemp = inFile.readLine();
			int codeTemp = Integer.parseInt(nameTemp);
			nameTemp = inFile.readLine();
			magazyn.add(new Item(nameTemp,priceTemp,codeTemp));
		}
		inFile.close();
		
		System.out.println(magazyn);
		
		
	}
}
