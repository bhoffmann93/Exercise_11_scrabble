import java.util.Map;
import java.util.TreeMap;

/**Following sources used:
 * "https://www.youtube.com/watch?v=nYFd7VHKyWQ"
 */
public class Permutator {

    public Permutator(String word) {
        word = word.toUpperCase();
        char [] chars = word.toCharArray();
        permute(chars);

    }

    private void permute (char [] input){
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            countMap.compute(ch, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val +1;
                }
            });
        }
        char [] str = new char[countMap.size()];
        int [] count = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getKey();
            index++;
        }
        char result [] = new char[input.length];
        permuteUtil(str, count, result, 0);

    }

    public void permuteUtil(char str[], int count[], char result[], int level) {
        if (level == result.length) {
            printArray(result);
            return;
        }

        for(int i=0; i<str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1);
            count[i]++;

        }

    }

    public void printArray (char input[]) {
        String str = "";
        for(char ch : input) {
            str += ch;
        }

        System.out.println(str);
    }
}
