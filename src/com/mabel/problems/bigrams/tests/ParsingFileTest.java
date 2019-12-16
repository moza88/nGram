package com.mabel.problems.bigrams.tests;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import com.mabel.problems.bigrams.ParsingFile;

public class ParsingFileTest {

	ParsingFile parsingFile = new ParsingFile();
	String sampleText = "The quick brown fox and the quick blue hare. The quick brown fox.";
	String testFileName = "/home/mabel/Documents/Interviews/nGram/src/resources/testDoc";

	public String createTestFile() throws IOException {
		
		//Getting file reference
		Path path = Paths.get(testFileName);
		
		//Using try-with-resource to get closeable writer instance
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(sampleText);
		}
		return testFileName;
	}
	
	
	@Test
	public void readingFileContents_test() throws IOException {

		String fileText = parsingFile.readingFileContents(createTestFile()).trim();
		String expectedText= "The quick brown fox and the quick blue hare. The quick brown fox.";
		
		assertEquals(fileText,expectedText);
	}

	@Test
	public void turningTextIntoList_test() throws IOException {
		
		String[] wordListTest = parsingFile.turningTextIntoList(sampleText);
		String[] wordListExpected = {
			"the", "quick", "brown", "fox", "and", "the", "quick", "blue", "hare", "the", "quick", "brown", "fox"
		};

		assertArrayEquals(wordListTest,wordListExpected);
	}
}
