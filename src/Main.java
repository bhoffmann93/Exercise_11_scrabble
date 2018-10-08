import java.util.Random;

public class Main {


    public static void main(String[] args) {

        char[] w = new char[7];
        Random r = new Random();
        String word = "";

        for (int i=0; i < w.length; i++) {
            int nextch =  r.nextInt(25);
            nextch += 65;
            w[i] = (char) nextch;
        }

        word = String.valueOf(w);
        System.out.println();
        System.out.print("The random letters are: ");
        for (char ch: w) { System.out.print(ch + " ");}
        System.out.println();
        System.out.println();

        Subtringer stringer = new Subtringer(word);

        //TEst 123 GITGIT

    }


}

