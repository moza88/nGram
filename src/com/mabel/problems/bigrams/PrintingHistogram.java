package com.mabel.problems.bigrams;

import java.util.HashMap;

public class PrintingHistogram {

	public PrintingHistogram(HashMap<String, Long> createNGramFreqList) {
		createNGramFreqList.entrySet().forEach(entry->{
			System.out.println(entry.getKey() + " " + entry.getValue());  
		});
	}
}

