package test;


public class DictionaryDriver {
    public static void main(String [] args) {
        new DictionaryDriver();
    }

    public DictionaryDriver() {
        String [] words = {
                "trong","thientrong","gaudeo"};
        LatinDictionary dictionary = new LatinDictionary();
        dictionary.loadDictionary("Latin.txt");
        String definition;
        dictionary.insertWord("Trong","A walnut.  Either the nut or the tree");

        for(int i=0; i < words.length; i++) {
            definition = dictionary.getDefinition(words[i]);
            if(definition == null)
                System.out.println(
                        "Sorry, " + words[i] + " was not found.\n");
            else
                System.out.println(
                        "The definition of " + words[i] + " is:\n" +
                                definition + ".\n");
        }

        dictionary.insertWord("tieucuong","Cuto");
        definition = dictionary.getDefinition("tieucuong");

        if(definition == null)
            System.out.println(
                    "Sorry, iuglans" + " was not found.\n");
        else
            System.out.println(
                    "The definition of iuglans" + " is:\n" +
                            definition + ".\n");

        if(!dictionary.deleteWord(words[0]))
            System.out.println("ERROR, delete FAILED!!!");
        if(dictionary.getDefinition(words[0]) != null)
            System.out.println("ERROR, returned deleted definition.");

        System.out.println("Now checking the getRange method\n");
        String [] myWords = dictionary.getRange("a","c");
        for(int i=0; i < myWords.length; i++)
            System.out.println(myWords[i] + "=" + dictionary.getDefinition(myWords[i]));

    }
}