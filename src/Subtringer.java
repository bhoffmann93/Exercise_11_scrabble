import java.util.ArrayList;
import java.util.HashSet;

public class Subtringer {
    private  String word = "";
    private Dictionary scrabbler;

    public Subtringer(String word) {
        this.word = word;
        scrabbler = new Dictionary(word.length());
        cheat(getBags(getSubstrings(word)));

    }

    private HashSet<String> getSubstrings (String word) {
        String sub = "";
        HashSet<String> substrings = new HashSet<>();

        for(int i=0; i<word.length(); i++) {
            for(int j=1; j<=word.length()-i; j++) {
                sub = word.substring(i, i+j);
                if(sub.length() > 1) {
                    substrings.add(sub);
                }
            }
        }
        return substrings;
    }

/*    private void printSubstrings (HashSet <String> substr) {
        for (String strg: substr ) {
            System.out.println(strg);

        }
    }*/

    private ArrayList<String>[] getBags (HashSet<String> substr) {
        ArrayList<String>[] bags = new ArrayList[this.word.length()-1];
        for (int i=0; i < bags.length; i++) {
            bags[i] = new ArrayList<>();
        }

        for(int i=0; i<bags.length; i++) {
            bags[i] = getFilledList(substr, i);
        }
        return bags;
    }

    private ArrayList<String> getFilledList (HashSet<String> str, int count) {
        ArrayList<String> al = new ArrayList<>();
        for (String currentword: str) {
            if(currentword.length() == word.length()-count) {
                al.add(currentword);
            }
        }
        return al;
    }

    private void printBags(ArrayList<String>[] bags) {
        for (int i = 0; i< bags.length; i++) {
            System.out.println("Bag " + i + " contains:");
            System.out.println();
            for(String str: bags[i]) {
                System.out.println(str);
            }
            System.out.println();
        }
    }

    private void cheat(ArrayList<String>[] bags) {
        //printBags(bags);
        System.out.println("The following words were found for your letters:");
        System.out.println();
        for (int i = 0; i < bags.length; i++) {
            for (String str : bags[i]) {
                scrabbler.printPermutations(str);
            }
        }

    }


}
