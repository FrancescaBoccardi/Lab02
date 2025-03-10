package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	//private List<Word> words;
	private List<WordEnhanced> words;
	
	public AlienDictionary() {
		//this.words = new LinkedList<Word>();
		this.words = new LinkedList<WordEnhanced>();
	}

//	public void addWord(String alienWord, String translation) {
//		for(Word w : words) {
//			if(w.equals(alienWord)) {
//				w.setTranslation(translation);
//				return;
//			}
//		}
//		
//		Word temp = new Word(alienWord, translation);
//		words.add(temp);
//	}
//	
//	public String translateWord(String alienWord) {
//		for(Word w : words) {
//			if(w.equals(alienWord)) {
//				return "Traduzione di "+alienWord+": "+w.getTranslation();
//			}
//		}
//		
//		return null;
//	}
	
	public void addWord(String alienWord, String translation) {
		for(WordEnhanced w : words) {
			if(w.equals(alienWord)) {
				w.addTranslation(translation);
				return;
			}
		}
		 WordEnhanced temp = new WordEnhanced(alienWord, translation);
		 words.add(temp);
	}
	
	public String translateWord(String alienWord) {
		String risultato = "Traduzione/i:";
		boolean esiste = false;
		for(WordEnhanced w : words) {
			if(w.equals(alienWord) || w.getAlienWord().matches(alienWord)) {
				risultato += " "+w.getTranslations()+",";
				esiste = true;
			}
		}
		
		if(esiste) {
			return risultato.substring(0,risultato.length()-1);
		}else {
			return null;
		}
		
	}

}
