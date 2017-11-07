package lab3;


import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lab32 {
	
	public static enum imiona{
		Anna("Anna"), Piotr("Piotr"), Tomasz("Tomasz");
		private final String nazwa;
		private int count[] = {0,0,0};

		private imiona(String nazwa1) {
			this.nazwa = nazwa1;

		}
		public int getCount(int i) {
			return count[i];
		}
		public void addCount(int i) {
			count[i]++;
		}
		
		
		public String toString() {
			return nazwa;
		}
	}
	
	public static class LetterObject{
		char letter;
		static List<WordObject> assignedList = new ArrayList<>();
		public LetterObject(char l) {
			letter = l;
		}
	}
	
	public static class WordObject{
		String word;
		int duplicates=0;
		int fileIndex;
		public WordObject(String line, int index) {
			word = line;
			fileIndex = index;
		}
		public void addDuplicate() {
			duplicates++;
		}
		public String getWord() {
			return word;
		}
	}
	
	public static void nameCounter(List<LetterObject> workingList) {
		int k;
		for(int i=0;i<26;i++) {

			k=0;
			workingList.get(i);
			Collections.sort(LetterObject.assignedList, (p1, p2) -> p1.getWord().compareTo(p2.getWord()));
			workingList.get(i);
			List<WordObject> tmpList = LetterObject.assignedList;
			System.out.println(workingList.get(i).letter);
			while(k < tmpList.size()){
				if(!tmpList.get(k).getWord().compareTo(imiona.Anna.toString())) {
					imiona.Anna.addCount(tmpList.get(k).fileIndex);
				}
				if(!tmpList.get(k).getWord().compareTo(imiona.Piotr.toString())) {
					imiona.Piotr.addCount(tmpList.get(k).fileIndex);
				}
				if(!tmpList.get(k).getWord().compareTo(imiona.Tomasz.toString())) {
					imiona.Tomasz.addCount(tmpList.get(k).fileIndex);
				}
				
				System.out.println(tmpList.get(k).getWord());
				/*
				switch (tmpList.get(k).getWord()) {
				case "Anna": imiona.Anna.addCount(tmpList.get(k).fileIndex);
					break;
				case "Piotr": imiona.Piotr.addCount(tmpList.get(k).fileIndex);
					break;
				case "Tomasz": imiona.Tomasz.addCount(tmpList.get(k).fileIndex);
					break;
				}*/
				k++;
			}	
			
				
			}
		

		
	
			
	}
	
	public static List<WordObject> checkDuplicates(List<WordObject> list) {
		List<WordObject> tmpList = new ArrayList<>();
		tmpList = list;
		
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(tmpList.get(j).getWord() == list.get(i).getWord()) list.get(i).addDuplicate();
			}
		}
		return list;
	}

	public static void main(String[] args) throws IOException {
		List<LetterObject> letterList = new ArrayList<>();
		List<String> fileList = new ArrayList<>();
		List<String> testList = new ArrayList<>();
		EasyReader console = new EasyReader();
		
		char c = 'a';						//wypelnienie listy liter
		for(int i=0;i<26;i++) {
			letterList.add(new LetterObject(c));
			c++;
		}
		
		
		int k;
		for(int i=0;i<3;i++) {				//czytanie slow z plikow
			System.out.println("Podaj nazwe pliku: ");
			String fileName = console.readLine();
			System.out.println(fileName);
			
			EasyReader newFile = new EasyReader(fileName);
			
			String line = newFile.readLine();//tworzenie listy z zawartoscia pliku
			while(line != null){
			   fileList.add(line);
			   line = newFile.readLine();
			}
			newFile.close();
			
			System.out.println(fileList);
			
			
			for(int j=0;j<26;j++) { 		//wypelniane listy slow dla kazdej litery
				k = 0;
				while(k < fileList.size()){
						if(fileList.get(k).charAt(0) == Character.toUpperCase(letterList.get(j).letter)) {
							System.out.println(fileList.get(k));
							System.out.println(fileList.get(k).charAt(0));
							System.out.println(letterList.get(j).letter);
							
							letterList.get(j);
							LetterObject.assignedList.add(new WordObject(fileList.get(k),i));
							testList.add(fileList.get(k));
							}	
						k++;
						
					}
				System.out.println(testList);
				testList.clear();
				
			}
			fileList.clear();
			

			
		}
		
		nameCounter(letterList); 			//zliczanie imion
		
		for(int i=0;i<26;i++) {				//sprawdzenie duplikatow
			letterList.get(i);
			letterList.get(i);
			LetterObject.assignedList = checkDuplicates(LetterObject.assignedList);
		}
		
		for(int i=0;i<3;i++) {	
		System.out.println("W pliku: " + i + " Anna wystepuje: " + imiona.Anna.getCount(i) + " razy, Piotr wystepuje: " + imiona.Piotr.getCount(i) + " razy, Tomasz wystepuje: " + imiona.Tomasz.getCount(i) + " razy.");
		}
	}
	
}
