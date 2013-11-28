package Save;



import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Saving {
  public static int ending;
  public Saving(String save) throws IOException{
    //Saving text = new Saving(save);
    
    //treat as a small file
    List<String> lines = this.readSmallTextFile(FILE_NAME);
    log(lines);
    lines.add(save);
    //end(lines);
    
    this.writeSmallTextFile(lines, FILE_NAME);
    end(lines);
    
    //treat as a large file - use some buffering
    
    //this.readLargerTextFile(FILE_NAME);
   // lines = Arrays.asList("Down to the Waterline", "Water of Love");
  //  text.writeLargerTextFile(OUTPUT_FILE_NAME, lines);   
    System.out.println(ending);
  }

  final static String FILE_NAME = "C:\\DistortionSave\\Save.txt";
  final static String OUTPUT_FILE_NAME = "C:\\DistortionSave\\Save.txt";
  final static Charset ENCODING = StandardCharsets.UTF_8;
  
  //For smaller files

  /**
   Note: the javadoc of Files.readAllLines says it's intended for small
   files. But its implementation uses buffering, so it's likely good 
   even for fairly large files.
  */  
  List<String> readSmallTextFile(String aFileName) throws IOException {
    Path path = Paths.get((aFileName));
    //File file = new File(Saving.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    return Files.readAllLines(path, ENCODING);
  }
  
  void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    Files.write(path, aLines, ENCODING);
  }

  //For larger files
  /*
  void readLargerTextFile(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    try (Scanner scanner =  new Scanner(path, ENCODING.name())){
      while (scanner.hasNextLine()){
        //process each line in some way
        log(scanner.nextLine());
      }      
    }
  }
  
  void readLargerTextFileAlternate(String aFileName) throws IOException {
    Path path = Paths.get(aFileName);
    try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
      String line = null;
      while ((line = reader.readLine()) != null) {
        //process each line in some way
        log(line);
      }      
    }
  }
  
  void writeLargerTextFile(String aFileName, List<String> aLines) throws IOException {
    Path path = Paths.get(aFileName);
    try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
      for(String line : aLines){
        writer.write(line);
        writer.newLine();
      }
    }
  }
  */
  private static void log(Object aMsg){
	    System.out.println(String.valueOf(aMsg));
	  }
  private static int end(Object aMsg){
	  String text = String.valueOf(aMsg);
	  String textt = text;
	  String cat = "[]";
	  String cat1 = "[A]";
	  String cat2 = "[A, A]";
	  String bat = "cat";
    System.out.println(String.valueOf(aMsg));
    System.out.println(textt);
    
    if(textt.equals(cat)){
    	 System.out.println("Check works");
    	 int ending = 1;
    	 Ending end = new Ending(ending);
    	 endingreturner(ending);
    	 System.out.println(ending);
    	 
    }
   
    else if(textt.equals(cat1)){
   	 System.out.println("Check works");
   	 int ending = 2;
   	Ending end = new Ending(ending);
   	System.out.println(ending);
   	 
   }
    else if(textt.equals(cat2)){
	   	 System.out.println("Check works");
	   	 int ending = 3;
	   	Ending end = new Ending(ending);
	   	endingreturner(ending);
	   	System.out.println(ending);
	   	 
	   }
    else{
    	 int ending = 5;
 	   	Ending end = new Ending(ending);
    }
    return ending;
	//return ending;
    
  }
  
  public static int endingreturner(int ending){
	  //Ending e = new Ending();
	return ending;
	
	
	  
  }
  
} 