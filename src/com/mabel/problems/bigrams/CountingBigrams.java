package com.mabel.problems.bigrams;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CountingBigrams {
	
	public HashMap<String, Long> createNGramFreqList(String[] wordList, int n){
		
		HashMap<String, Long> nGramList = new LinkedHashMap<String, Long>(); //Creating the list to store the nGrams and frequency

		if(wordList != null) {
			int wordListSize = wordList.length; 

			for (int i = 0; i <= wordListSize - n ; i++) {
				long count = 1;
				
				//Creating the nGram Words for the list, i.e. if the n gram is 3 then the values should be "the quick brown"
				String nGramWord = "";
				
				if(n == 2) {
					nGramWord = wordList[i] + " " + wordList[i+1];
				} else if(n == 3) {
					nGramWord = wordList[i] + " " + wordList[i+1] + " " + wordList[i + 2];
				} else if(n == 4) {
					nGramWord = wordList[i] + " " + wordList[i+1] + " " + wordList[i + 2]  + " " + wordList[i + 3];
				}
				
				//Counting the frequency of the n gram word's appearance
				if(nGramList.containsKey(nGramWord)) {
					count++;
					nGramList.put(nGramWord, count);
				} else {
					nGramList.put(nGramWord, count);
				}				
			}
		}
		return nGramList;
		
	}	

	
}