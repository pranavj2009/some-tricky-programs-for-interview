package hackerrank;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> anagramMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <s.length() ; j++) {
                char[] c = s.substring(i,j+1).toCharArray();
                Arrays.sort(c);
                String temp = new String(c);
                if(anagramMap.containsKey(temp)){
                    anagramMap.put(temp,anagramMap.get(temp)+1);
                }else {
                    anagramMap.put(temp,1);
                }
            }
        }

        int anagramsCount = 0;

        for (String word: anagramMap.keySet()) {
            int v = anagramMap.get(word);
            v = (v*(v-1))/2;
            anagramsCount+=v;
        }
        return anagramsCount;
    }

}

public class SherlockAndAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

