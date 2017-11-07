package lab3;


import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lab32 {
	
	public static enum imiona{
		Anna("Anna"), Piotr("Piotr"), Tomasz("Tomasz");
		private String nazwa;
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
		
		@Override
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
	
	public static List<WordObject> sortWords(List<WordObject> list) {
		Collections.sort(list, (p1, p2) -> p1.getWord().compareTo(p2.getWord()));
		return list;
	}
	
	public static void nameCounter(List<LetterObject> workingList) {
		for(int i=0;i<26;i++) {
			workingList.get(i).assignedList = sortWords(workingList.get(i).assignedList);
			System.out.println(workingList.get(i).letter);
			for(int j=0;j<workingList.get(i).assignedList.size();j++) {
				System.out.println("---------\n" + workingList.get(i).assignedList.get(j).getWord());
				switch(workingList.get(i).assignedList.get(j).getWord()) {
				case "Anna": 
					System.out.println(workingList.get(i).assignedList.get(j).fileIndex);
					imiona.Anna.addCount(workingList.get(i).assignedList.get(j).fileIndex);	
					break;
				case "Piotr":
					System.out.println(workingList.get(i).assignedList.get(j).fileIndex);
					imiona.Piotr.addCount(workingList.get(i).assignedList.get(j).fileIndex);
					break;
				case "Tomasz":
					System.out.println(workingList.get(i).assignedList.get(j).fileIndex);
					imiona.Tomasz.addCount(workingList.get(i).assignedList.get(j).fileIndex);
					break;
				}
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
		List<String> desperationList = new ArrayList<>();
		List<String> testList = new ArrayList<>();
		EasyReader console = new EasyReader();
		
		char c = 'a';					//wypelnienie listy liter
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
			
			String line = newFile.readLine();
			while(line != null){
			   desperationList.add(line);
			   line = newFile.readLine();
			}
			newFile.close();
			
			System.out.println(desperationList);
			
			c = 'a';
			for(int j=0;j<26;j++) {

				k = 0;
				do {
					
						if(desperationList.get(k).charAt(0) == c || desperationList.get(k).charAt(0) == Character.toUpperCase(c)) {
							System.out.println(c);
							System.out.println(desperationList.get(k));
							System.out.println(letterList.get(j).letter);
							
							letterList.get(j).assignedList.add(new WordObject(desperationList.get(k),i));
							testList.add(desperationList.get(k));
						}
					
					k++;
				}while(k < desperationList.size());
				c++;
				
			}
			desperationList.clear();
			
			System.out.println(testList);
			testList.clear();
			
		}
		
		for(int i=0;i<26;i++) {				//sprawdzenie duplikatow
			letterList.get(i);
			letterList.get(i);
			LetterObject.assignedList = checkDuplicates(LetterObject.assignedList);
		}
		

		nameCounter(letterList); //zliczanie imion

		for(int i=0;i<3;i++) {
			
		System.out.println("W pliku: " + i + " Anna wystepuje: " + imiona.Anna.getCount(i) + " razy, Piotr wystepuje: " + imiona.Piotr.getCount(i) + " razy, Tomasz wystepuje: " + imiona.Tomasz.getCount(i) + " razy.");
		}
	}
	
}
