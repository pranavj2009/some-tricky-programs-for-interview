package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Integer> rightMap = new HashMap<>();
        Map<Long, Integer> leftMap = new HashMap<>();

        for (long item:arr) {
            rightMap.put(item,rightMap.getOrDefault(item,0)+1);
        }
        long count = 0;
        for(int i=0; i<arr.size(); i++){
            long midterm = arr.get(i);
            long c1 = 0, c3 = 0;
            rightMap.put(midterm,rightMap.getOrDefault(midterm,0)-1);

            if(leftMap.containsKey(midterm/r) && midterm%r==0){
                c1 = leftMap.get(midterm/r);
            }

            if(rightMap.containsKey(midterm*r)){
                c3 = rightMap.get(midterm*r);
            }

            count+= c1 * c3;

            leftMap.put(midterm,leftMap.getOrDefault(midterm,0)+1);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);
        System.out.println(ans);

        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
