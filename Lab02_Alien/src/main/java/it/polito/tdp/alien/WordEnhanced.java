package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations = new LinkedList<String>();
		this.addTranslation(translation);
	}
	
	public void addTranslation(String translation) {
		translations.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslations() {
		String risultato = "";
		for(String s : translations) {
			risultato += s+", ";
		}
		return risultato.substring(0,(risultato.length()-2));
	}

	public boolean equals(String s) {
		if(this.alienWord.equals(s)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
}
