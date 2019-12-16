package com.mabel.problems.bigrams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class ParsingFile {
	
	String[] wordList;
	int wordCount;
	String fileName ;

	public String captureFileName() {
		
		//Collecting conosole input
		Scanner scanner = new Scanner(System.in);
        
		System.out.println("Enter path and filename");

	    fileName = scanner.nextLine();  // Read user input
	    
	    scanner.close();

		//Checking to see if a file name was entered
	    if(fileName == null || fileName == "" || fileName.length() < 1) {
	    	captureFileName();
	    }
	    
	    //Removing additional spaces from the file path
		String regex = "^\\s+";
	    fileName = fileName.replaceAll(regex, ""); 
	    	    
		return fileName;
	}
	
	///home/mabel/Documents/Interviews/nGram/src/resources/sample_text1
    public String readingFileContents(String fileName) throws IOException {
    	
    	Path filePath = Paths.get(fileName);
        StringBuilder contentBuilder = new StringBuilder();

    	if(Files.exists(filePath) || Files.isReadable(filePath)){ //Checking if the file is valid and has appropriate read permissions
	 
	        try (Stream<String> stream = Files.lines( filePath, StandardCharsets.UTF_8)) 
	        {
	            stream.forEach(s -> contentBuilder.append(s).append("\n"));
	        }
	        catch (NoSuchFileException e) 
	        {
	    		System.out.println("File doesn't Exist. Please double check the file path and file name and run this program again.");
	        }
	        
	        System.out.println(contentBuilder.toString());
    	}else {
    		System.out.println("File doesn't Exist. Please double check the file path and file name and run this program again.");
    	}
        return contentBuilder.toString();
    }

    
	public String[] turningTextIntoList(String text) throws IOException {
		text = text.replaceAll("\\p{Punct}", "").trim().toLowerCase(); //Remove punctuation, trim each line, and make everything lowercase
			    	  
		wordList=text.split(" ");   //Split the word using space
			    	 		
		return wordList;
		
	}
}
