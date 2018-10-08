/**
 * The following sources have been used to write this code
 *"http://javadevnotes.com/java-read-text-file-examples"
 * The wordlist comes from the following source:
 * "https://drive.google.com/file/d/0B9-WNydZzCHrdDVEc09CamJOZHc/view"
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Dictionary {
    private LinkedList <String> [] hash = new LinkedList[200];

    public Dictionary(int length) {
        for (int i = 0; i < hash.length; i++) {
            hash[i] = new LinkedList<>();
        }
        read(length);

    }


    private void read (int length) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/Users/bernhard1/Desktop/_Uni/So 18/INFO 2/Übung/Exercise 11 scrabble/words.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                if(line.length() <= length && line.length() > 1) {
                    long c = 0;
                    for (int i = 0; i < line.length(); i++) {
                        c += (Integer.valueOf(line.charAt(i)) - 64);
                    }
                    doHash(c, line);
                    // System.out.println(c);
                }
            }

        } catch (IOException e) {
            //do something
        }

    }

    private void doHash (long i, String str) {
         int ii = (int) i % hash.length;
        hash [ii].add(str);

    }

    private void printTable () {
        for (int i = 0; i < hash.length; i++) {
            //System.out.println(i + ": "  + hash[i].size());
            for(int j = 0; j<hash[i].size(); j++) {
                  System.out.println(hash[i].get(j));

            }
        }
    }

    private String[] lookup (String line){
        line = line.toUpperCase();
        long c = 0;
        for (int i = 0; i < line.length(); i++) {
            c += (Integer.valueOf(line.charAt(i))-64);
        }
        int ii = (int) c % hash.length;
        String[] strings = new String[hash[ii].size()];

        for (int i = 0; i < hash[ii].size(); i++) {
            strings [i] = hash[ii].get(i);
        }
        return strings;

    }

    private boolean isPermuation (String a, String b) {
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        Arrays.sort(charsa);
        Arrays.sort(charsb);
        return Arrays.equals(charsa, charsb);
    }

    public String[] getPermuations (String word) {
        word = word.toUpperCase();
        ArrayList<String> permutations = new ArrayList<>();
        for(String str: lookup(word)) {
/*            if(isPermuation(word,str) && !word.equals(str))*/
                if(isPermuation(word,str))
                permutations.add(str);
        }

        String[] permarray = new String [permutations.size()];
        permarray = permutations.toArray(permarray);
       // if(permarray.length == 0) System.out.println("no permutation found :(");
        return permarray;
    }

    public void printPermutations (String word) {
        word = word.toUpperCase();
        for(String str: getPermuations(word) ){
/*            System.out.println("Permutation found for " + word+ ": "+ str);*/
            System.out.println(str);

        }

    }






}


