package com.mabel.problems.bigrams.tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;



import com.mabel.problems.bigrams.CountingBigrams;
import com.mabel.problems.bigrams.ParsingFile;

public class CountingBigramTest {

	
	@Test
	public void biGram_test1() throws IOException {
		
		ParsingFile parsingFile = new ParsingFile();
				
		String[] wordList = parsingFile.turningTextIntoList(
				"The quick brown fox and the quick blue hare. The quick brown fox.");
		
		CountingBigrams countingBigrams = new CountingBigrams();
		
		HashMap<String, Long> trieGramList = countingBigrams.createNGramFreqList(wordList, 2);
		
		assertTrue(trieGramList.get("the quick") == 2);
	}
	
	@Test
	public void SbiGram_test2() throws IOException {
		
		ParsingFile parsingFile = new ParsingFile();
				
		String[] wordList = parsingFile.turningTextIntoList(
				"The quick brown fox and the quick blue hare. The quick brown fox.");
		
		CountingBigrams countingBigrams = new CountingBigrams();
		
		HashMap<String, Long> trieGramList = countingBigrams.createNGramFreqList(wordList, 2);
		
		assertTrue(trieGramList.get("quick brown") == 2);
	}
	
	@Test
	public void biGram_test3() throws IOException {
		
		ParsingFile parsingFile = new ParsingFile();
				
		String[] wordList = parsingFile.turningTextIntoList(
				"The quick brown fox and the quick blue hare. The quick brown fox.");
		
		CountingBigrams countingBigrams = new CountingBigrams();
		
		HashMap<String, Long> trieGramList = countingBigrams.createNGramFreqList(wordList, 2);
		
		assertTrue(trieGramList.get("brown fox") == 2);
	}
	
	@Test
	public void biGram_test4() throws IOException {
		
		ParsingFile parsingFile = new ParsingFile();
				
		String[] wordList = parsingFile.turningTextIntoList(
				"The quick brown fox and the quick blue hare. The quick brown fox.");
		
		CountingBigrams countingBigrams = new CountingBigrams();
		
		HashMap<String, Long> trieGramList = countingBigrams.createNGramFreqList(wordList, 2);
		
		assertTrue(trieGramList.get("blue hare") == 1);
	}
	
	@Test
	public void quadGram_test1() throws IOException {
		
		ParsingFile parsingFile = new ParsingFile();

		String[] wordList = parsingFile.turningTextIntoList(
				"The quick brown fox and the quick blue hare. The quick brown fox.");
		
		CountingBigrams countingBigrams = new CountingBigrams();
		
		HashMap<String, Long> trieGramList = countingBigrams.createNGramFreqList(wordList, 4);
		
		assertTrue(trieGramList.get("the quick brown fox") == 2);
		
	}
	
	@Test
	public void trieGram_test1() throws IOException {
		
		ParsingFile parsingFile = new ParsingFile();

		String[] wordList = parsingFile.turningTextIntoList(
				"The quick brown fox and the quick blue hare. The quick brown fox.");
		
		CountingBigrams countingBigrams = new CountingBigrams();
		
		HashMap<String, Long> trieGramList = countingBigrams.createNGramFreqList(wordList, 3);
		
		assertTrue(trieGramList.get("the quick brown") == 2);
		
	}
	
}
