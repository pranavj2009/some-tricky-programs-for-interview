package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LonelyInteger {
    /*
    * EXOR Operation solves it
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer rawInputTokenizer = new StringTokenizer(reader.readLine());
        int[] inputArray = new int[n];
        int cnt=0;
        while(rawInputTokenizer.hasMoreElements()){
            inputArray[cnt] = Integer.parseInt(rawInputTokenizer.nextToken());
            cnt++;
        }

        System.out.println(lonelyInteger(inputArray));

    }

    static int lonelyInteger(int... inputArray){
        int result = 0;
        for (int i = 0; i < inputArray.length; i++) {
            result^=inputArray[i];
        }
        return result;
    }
}
