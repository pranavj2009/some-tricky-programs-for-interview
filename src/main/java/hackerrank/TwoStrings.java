package hackerrank;

import java.io.*;
import java.util.*;

class ResultTwoStrings {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

        public static String twoStrings(String s1, String s2) {
            Set<Character> cSet1 = new HashSet<>();
            Set<Character> cSet2 = new HashSet<>();
            for (char c: s1.toCharArray() ) {
                cSet1.add(c);
            }

            for (char c: s2.toCharArray() ) {
                cSet2.add(c);
            }


                if (s1.isEmpty() || s2.isEmpty()) {
                    return "NO";
                }
                cSet1.retainAll(cSet2);

                if(!cSet1.isEmpty()){
                    return "YES";
                }else{
                    return "NO";
                }
        }

}

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = bufferedReader.readLine();

            String s2 = bufferedReader.readLine();

            String result = ResultTwoStrings.twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}