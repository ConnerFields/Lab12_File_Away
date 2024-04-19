import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Lab_12_File_Away {

    public static void main(String[] args)
    {

        JFileChooser fileChooser = new JFileChooser();  // Create a file chooser dialog


        int returnValue = fileChooser.showOpenDialog(null); // Show the dialog and get the user's selection


        if (returnValue == JFileChooser.APPROVE_OPTION) // Check if the user selected a file
        {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile); //process file
        } else
        {
            System.out.println("No file selected."); //lets user know no file selected
        }
    }

    private static void processFile(File file)
    {
        BufferedReader reader = null;
        try
        {
            reader = new BufferedReader(new FileReader(file)); //creates the BufferedReader to read file
            String line;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while ((line = reader.readLine()) != null)
            {
                lineCount++; //track line count
                String[] words = line.split("\\s+"); // Split the line into words using whitespace as delimiter
                wordCount += words.length; //track word count
                charCount += line.replaceAll("\\s", "").length(); //math for character count
            }


            System.out.println("Summary Report:"); // Print summary report
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);

        } catch (IOException e)
        {
            System.err.println("Error reading the file: " + e.getMessage()); //displays that an error occurred reading the file
        } finally
        {
            if (reader != null) //Close the BufferReader
            {
                try
                {
                    reader.close();
                } catch (IOException e)
                {
                    System.err.println("Error closing the file: " + e.getMessage()); //displays error closing file
                }
            }
        }
    }
}