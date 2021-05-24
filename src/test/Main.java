/*
 *Trần Thiên Trọng
 *517H0174
 *17050310
 *DSA 2
 */
package test;

import java.util.Arrays;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        String definition;
        boolean quit = false;
        int menuItem;
        String[] array = new String[0];
        final int N = array.length;
        LatinDictionary dictionary = new LatinDictionary();
        Scanner in = new Scanner(System.in);
        System.out.println("|1] LOAD Dictionary");
        System.out.println("|2] LOOK UP Word");
        System.out.println("|3] PRINT Range Of Words");
        System.out.println("|4] ADD Word");
        System.out.println("|5] DELETE Word");
        System.out.println("|6] GUIDE");
        System.out.println("|7] EXIT");
        do {
            System.out.print("[Choose your Option]: ");
            menuItem = in.nextInt();

            switch (menuItem) {
                case 1:
                    String arrayOfFileName[] = new String[1];
                    Scanner scanCase1 = new Scanner(System.in);
                    System.out.print("Type your file name: ");
                    arrayOfFileName[0] = scanCase1.nextLine();
                    dictionary.loadDictionary(arrayOfFileName[0] + ".txt");
                    break;
                case 2:
                    System.out.print("Type your WORD you want to FIND : ");
                    Scanner scanCase2 = new Scanner(System.in);
                    String[] words = {scanCase2.nextLine()};
                    for (int i = 0; i < words.length; i++) {
                        definition = dictionary.getDefinition(words[i]);
                        if (dictionary.containsWord(words[i]) == false)
                            System.out.println(
                                    "Sorry, " + words[i] + " was not found.\n");
                        else
                            System.out.println(
                                    "The definition of " + words[i] + " is:" + definition + ".\n");
                    }
                    break;
                case 3:
                    System.out.print("Type your first word you want to search: ");
                    Scanner scanCase3 = new Scanner(System.in);
                    String startWord = scanCase3.nextLine();
                    System.out.print("Type your edge word you want to search: ");
                    Scanner scanD = new Scanner(System.in);
                    String endWord = scanD.nextLine();
                    String[] myWords = dictionary.getRange(startWord, endWord);
                    for (int i = 0; i < myWords.length; i++) {
                        System.out.println(myWords[i] + "=" + dictionary.getDefinition(myWords[i]));
                    }
                    break;
                case 4:
                    System.out.print("Type your word you want to insert: ");
                    Scanner scanCase4 = new Scanner(System.in);
                    String words3 = scanCase4.nextLine();
                    System.out.print("Type the definiton of that word: ");
                    Scanner scanCase41 = new Scanner(System.in);
                    String words32 = scanCase41.nextLine();
                    dictionary.insertWord(words3, words32);
                    definition = dictionary.getDefinition(words3);
                    break;
                case 5:
                    System.out.print("Type your word you want to delete: ");
                    Scanner scanCase5 = new Scanner(System.in);
                    String words5 = scanCase5.nextLine();
                    dictionary.deleteWord(words5);
                    definition = dictionary.getDefinition(words5);
                    if (definition == null) {
                        System.out.println(
                                "Delete Success");
                    }

                    break;
                case 6:
                    System.out.print("_____________________________________________________________INSTRUCTION________________________________________________________________\n");
                    System.out.println("|                                                                                                                                      |");
                    System.out.print("|                                          This is the simulator dictionary performed by Java.                                         |\n" +
                            "|                                                         You have 7 options include exit option.                                               |\n" +
                            "| Before doing something, you need to choose 1 to load the dictionary, the application only allows text file, so type your files name. |\n" +
                            "|               Continually to option 2, type the word you want to find and its word and definition will appear on your control screen.|\n" +
                            "|                                  Next to option 4, you can add any word and its definition correctly.                                |\n" +
                            "| Opposite to option 4, option 5 lets you destroy any word you want, cool right! You have almost full permission with this dictionary. |\n" +
                            "|                                                    Option 6, which you are reading now!.                                             |\n" +
                            "|                                           Last but not least, choose Option 7 to exit the program.                                   |\n");
                    System.out.println("|                                                                                                                                      |");
                    System.out.println("_____________________________________________________________The END____________________________________________________________________");
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Hmmmm... Please Choose Again!.");
            }
        } while (!quit);
        System.out.println("Bye-bye!");
    }
}
