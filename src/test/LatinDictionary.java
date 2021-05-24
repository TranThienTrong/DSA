/*
 *Trần Thiên Trọng
 *517H0174
 *17050310
 *DSA 2
 */
package test;

import java.util.Iterator;
public class LatinDictionary{
    private DictionaryADT<String, String> dictionary;
    DictionaryEntry[] entries;
    public LatinDictionary() {}

    public void loadDictionary(String fileName){
        /*To acquire the entires, we'll go to our dictionary reader and get the array.*/
        entries = DictionaryReader.getDictionaryArray(fileName);

        dictionary = new BinarySearchTree<String, String>();
        for (DictionaryEntry entry : entries) {
            dictionary.add(entry.getKey(), entry.getValue());}}
    
    public boolean insertWord(String key, String value){
        return dictionary.add(key, value);}

    public boolean deleteWord(String key){
        return dictionary.delete(key);}

    public String getDefinition(String latinWord){
        return dictionary.getValue(latinWord);}

    public boolean containsWord(String latinWord){
        return dictionary.contains(latinWord);}

    public String[] getRange(String start, String finish){
        List<String> list=new List<String>();
        Iterator<String> keys=this.words();
/*In computer science, the Boolean data type is a data type, having two values 
(usually denoted true and false), intended to represent the truth values of logic 
and Boolean algebra. It is named after George Boole, who first defined an algebraic 
system of logic in the mid 19th century. The Boolean data type is the primary 
result of conditional statements, which allow different actions and change 
control flow depending on whether a programmer-specified boolean condition 
evaluates to true or false. It is a special case of a more general logical 
data type; logic does not always have to be boolean.*/
        boolean started=false;
        boolean finished=false;
        while(keys.hasNext() && finished==false)
        {String next=(String) keys.next();
            if(next.matches(start+"*"))
                started=true;
            if(next.matches(finish+".*"))
                break;
            if(started)
                list.insertLast(next);}

        String [] array = new String [list.getCurrentSize()];
        int i=0;
        for(String entry: list) {
            array[i]=entry;
            i++;
        }
        return array;}
    /*This returns an iterator of the words in the dictionary in sorted order.*/
    public Iterator<String> words(){
        return dictionary.keys();}
    /*This will return the definition in the dictionary, in exactaly the same order
    as the iterator.*/
    public Iterator<String> definitions(){
        return dictionary.values();}}