package TxtFileCompression;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class CountCharacters {

    /*
     * Prompts the user to input their file that they want to be compressed
     * and then passes off arguments in the .txt file to the countCharacters method
     */
    public static void userInput() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file you would like to be compressed: ");
        String userIn = scanner.nextLine();

        try {
            HashMap<Character, Integer> result = countCharacters(userIn);
            System.out.println(result);

        } catch (FileNotFoundException e) {
            System.out.println("The file that you input was not found. Please try again");
            userInput();
        }
    }

    /*
     * Takes the users input, reads line by line, then creates a hashmap and records
     * each occurrence of the letters that appear in the .txt file
     */
    public static HashMap<Character, Integer> countCharacters(String filePath) throws FileNotFoundException {

        Scanner in = new Scanner(new FileReader(filePath));
        HashMap<Character, Integer> map = new HashMap<>();

        //Counts every character in a given string
        while (in.hasNext()) {
            String text = in.nextLine();
            for (int i = 0; i < text.length(); i++) {

                char current = text.charAt(i);

                if (map.containsKey(text.charAt(i))) {
                    int value = map.get(text.charAt(i));
                    map.put(text.charAt(i), value + 1);
                } else {
                    map.put(current, 1);
                }
            }
        }
        in.close();
        return map;
    }
}