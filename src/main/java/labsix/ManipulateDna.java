package labsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * This class will accept user input and output a series of modifications.
 * The program will display an initial input DNA string and multiple modifications.
 *
 * <p>Bugs: This program has no known bugs!
 *
 * @author Vanessa R. Thomas
 */

public class ManipulateDna {
  /** The main entry point for ManipulateDna.
    *  The source code inside of this method will be executed when the program is
    *  run in the command-line. The output of this program will appear in the
    *  terminal window. The println statements make the program display output.
    *  The program will display a DNA string input as well as a series of
    *  modified outputs. :-)
    *  
    * @param args The command-line arguments
    **/
  public static void main(String[] args) {
    // display the name of the programmer and the date
    System.out.println("Vanessa R. Thomas " + new Date());
    // declare the starting file and scanner
    File dnaInputsFile = null;
    Scanner scanner = null;
    // connect the scanner to the input file
    try {
      dnaInputsFile = new File("input/dna_inputs.txt");
      scanner = new Scanner(dnaInputsFile);
    } catch (FileNotFoundException noFile) {
      System.out.println("Unable to locate file");
    }
    // Step One: Read in and display the chosen DNA string
    String dna = scanner.nextLine();
    final int dnaLength = dna.length();
    System.out.println("Okay, I'll manipulate " + dna.toUpperCase() + ".");
    // Step Two: Compute the complement of the DNA String
    String dnaComp = dna.replace('a','T').replace('t','A').replace('c','G')
        .replace('g','C').toUpperCase();
    System.out.println("The complement of " + dna.toUpperCase() + " is " + dnaComp + ".");
    // Step Three: Insert a randomly chosen DNA letter into the DNA String
    Random rand = new Random();
    int addPosition = rand.nextInt(dnaLength - 1) + 1;
    int addLetter = rand.nextInt(dnaLength - 1) + 1;
    char randLetter = dna.toUpperCase().charAt(addLetter);
    String dnaAdd = dna.substring(0,addPosition) + dna.charAt(addLetter) 
        + dna.substring(addPosition,dnaLength);
    System.out.println("I'm adding a(n) " + randLetter 
        + " at position " + addPosition + ". That makes " + dnaAdd.toUpperCase() + ".");
    // Step Four: Delete a DNA letter from a randomly chosen position in the DNA string
    int delPosition = rand.nextInt(dnaLength - 1) + 1;
    char delLetter = dna.toUpperCase().charAt(delPosition);
    String dnaDel = dna.substring(0,delPosition) + dna.substring(delPosition + 1,dnaLength);
    System.out.println("I'm subtracting the letter in position " + delPosition 
        + ". That makes " + dnaDel.toUpperCase() + ".");
    // Step Five: Change a random position in the DNA String to a randomly chosen DNA letter
    int changePosition = rand.nextInt(dnaLength - 1) + 1;
    int changeLetter = rand.nextInt(dnaLength - 1) + 1;
    String dnaChange = dna.toUpperCase().substring(0,changePosition) 
        + dna.toUpperCase().charAt(changeLetter) 
        + dna.toUpperCase().substring(changePosition + 1,dnaLength);
    System.out.println("I'm randomly replacing the letter in position " + changePosition 
        + " with a(n) " + dna.toUpperCase().charAt(changeLetter) 
        + ". That makes " + dnaChange + ".");
    // Step Six: Display a final thankyou message
    System.out.println("Thanks for using the ManipulateDna program!");
    System.out.println("Have a great day!");
  }

}
