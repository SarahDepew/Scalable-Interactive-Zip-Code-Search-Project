/* Assignment 6
Name: Sarah Depew
E-mail: sdepew@brynmawr.edu Course: CS 206
Submitted: December 8, 2016
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Assigment6 {
    //Variables used in program
    static String[] options = {"Yes", "No"}; //array for continuing zip code loop
    static int response = 0; //initializes response static Place search = null;
    static Place search = null;
    static Scanner input;
    static String line, userInput, answer;
    static HashMap<String, Place> places = new HashMap<String, Place>();
    static URL webFileName;
    static BufferedReader console;
    static double tries, totalTries, totalSearches, unsuccessfulTries, successfulTries, totalUnsuccessfulSearches, totalSuccessfulSearches;

    public static void main(String[] args) { //variables
        console = new BufferedReader(new InputStreamReader(System.in)); //makes it so that you can read from the console
        readData(); //reads and parses data

        try {
            do {
                //Get input from user, make sure it isn't empty or
                System.out.println("Please enter a town name and a state abbreviation for which you would like to search: ");
                userInput = console.readLine(); //input in console if(userInput != null){ //checks if the input is empty
                System.out.println("Query: " + userInput);
                search = search(places, userInput); //value of search to use to get index found."

                if (search == null) {
                    System.out.println(userInput + " not found.");
                } else {
                    System.out.println("Found...");
                    System.out.println(search); //prints out the toString() in the class
                }
                //Ask user if they want to do it again
                System.out.println("Do you want me to search again? Please type 'yes' or 'no'.");
                answer = console.readLine();
                if (answer.toUpperCase().equals(options[0].toUpperCase())) response =
                        0;
                else {
                    response = 1;
                    console.close();
                    System.out.println("Thank you. Good Bye!");
                }
            } while (response == 0); //user continues to search
        } catch (IOException e) {
            System.exit(1);
        }
    } //main()


    public static void readData() { //Variables for readData()
        String[] pieces;
        String line;
        int y = 0;
        Scanner input;

        //Handles the reading and parsing of the data file
        try {
            //Open an input stream to the data file
            webFileName = new URL("http://cs.brynmawr.edu/cs206/DataFiles/uszipcodes.csv"); //local webFile
            input = new Scanner(webFileName.openStream());

            //Read the first line from it and extract relevant data
            line = input.nextLine();
            pieces = line.split(",");
            y = pieces.length - 1; //length of a normal number of values in the data file fills pieces
            while (input.hasNextLine()) { //Read each line
                line = input.nextLine();
                //Parse each line into pieces
                pieces = line.split(","); //splits on a comma and
                // Check for duplicates
                Place searchZip = places.get(pieces[1].toUpperCase() + pieces[2].toUpperCase());
                if (pieces.length == y) { //accounts for the ,,, in some data entries
                    if (searchZip == null) {
                        places.put(pieces[1].toUpperCase() + pieces[2].toUpperCase(), new Place(pieces[0], pieces[1], pieces[2], Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Integer.parseInt(pieces[5])));
                    } else {
                        searchZip.addZip(pieces[0]);
                        searchZip.addPop(Integer.parseInt(pieces[3]));
                        searchZip.addMalePop(Integer.parseInt(pieces[4]));
                        searchZip.addFemalePop(Integer.parseInt(pieces[5]));
                    }
                } else {
                    if (searchZip == null) {
                        places.put(pieces[1].toUpperCase() + pieces[2].toUpperCase(), new Place(pieces[0], pieces[1], pieces[2], 0, 0, 0));
                    } else {
                        searchZip.addZip(pieces[0]);
                        searchZip.addPop(0);
                        searchZip.addMalePop(0);
                        searchZip.addFemalePop(0);
                    }
                }
            }

            input.close(); //close the URL stream once done with it
            System.out.println("The size of the hashmap is: " + places.size() + ".");
        } catch (MalformedURLException f) { //possible exceptions
            System.out.println("Error in opening the webpage: " + webFileName);
            System.exit(1);
        } catch (IOException g) {
            System.out.println("Error in opening the stream.");
            System.exit(1);
        }
    }//readData()

    public static Place search(HashMap<String, Place> p, String input) {
        String[] pieces;
        String userInputTown, userInputState;
        pieces = input.split(","); //makes sure the input is valid
        if (pieces.length == 2) {
            userInputTown = pieces[0].trim().toUpperCase();
            userInputState = pieces[1].trim().toUpperCase();
//Constructs a new place out of the userInput and sees if a place with a matching town and state exists in the tree
            return p.get(userInputTown + userInputState);
        }
        return null;
    }//search()
}//Assignment6

