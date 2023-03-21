import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
* The program reads the input and then outputs to text files.
*
* @author  Adrijan Vranjkovic
* @version 1.0
* @since   2023-03-16
*/

public final class FileIo {
    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */
    private FileIo() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */
    public static void main(String[] args) {
        try {
            // Get input from the file.
            final File input = new File("testInput.txt");
            final Scanner scanInput = new Scanner(input);
            // Print to output file.
            final FileWriter output = new FileWriter("output.txt");
            while (scanInput.hasNextLine()) {
                // Create variable for error checking.
                boolean noError = true;
                // These are the variables for the loops.
                int sum = 0;
                int counter = 0;
                // Split the file at any white spaces.
                final String[] fromFile = scanInput.nextLine().split(" ");
                while (counter < fromFile.length) {
                    try {
                        // Convert strings to integers.
                        sum += Integer.parseInt(fromFile[counter]);
                    } catch (NumberFormatException err) {
                        // Checking if the line is empty.
                        if (fromFile[counter].isEmpty()) {
                            output.write("Error: Empty line found.\n");
                        } else {
                            // Display is a non number is found.
                            output.write("Error: \"" + fromFile[counter]
                                        + "\" is not a valid integer.\n");
                        }
                        // This tells us if there is a error.
                        noError = false;
                        // If there is an error stop adding to this line.
                        break;
                    }
                    // Add one to the counter.
                    counter++;
                }
                // If no error has occurred.
                if (noError) {
                    // Output sum of all integers on the line to output file.
                    output.write(sum + "\n");
                }
            }
            // Close writer.
            output.close();

        } catch (IOException err) {
            // Error message.
            System.err.println("Error: " + err.getMessage());
        }
    }
}
