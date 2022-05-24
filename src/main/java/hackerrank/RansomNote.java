package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RansomNote {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> magazineWords = new HashMap<>();

        for (String word: magazine) {
            if(magazineWords.containsKey(word)){
                int count = magazineWords.get(word);
                count++;
                magazineWords.put(word, count);
            }else {
                magazineWords.put(word, 1);
            }
        }

        for (String word: note) {
            if(!magazineWords.containsKey(word)){
                System.out.println("No");
                return;
            }else{
                if(magazineWords.get(word)<=0){
                    System.out.println("No");
                    return;
                }else {
                    int count = magazineWords.get(word)-1;
                    magazineWords.put(word,count);
                }
            }
        }
        System.out.println("Yes");
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        List<String> note = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

        RansomNote.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
