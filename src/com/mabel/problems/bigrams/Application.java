package com.mabel.problems.bigrams;

import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException {
		
		ParsingFile parsingFile = new ParsingFile();
		
		String[] wordList = parsingFile.turningTextIntoList(parsingFile.readingFileContents(parsingFile.captureFileName()));
		
		CountingBigrams countingBigrams = new CountingBigrams();
		
		PrintingHistogram printingHistogram = new PrintingHistogram(countingBigrams.createNGramFreqList(wordList, 2));
		
	}
}
