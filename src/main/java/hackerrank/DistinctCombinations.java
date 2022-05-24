package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result3 {

    /*
     * Complete the 'totalTriplets' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY capacity
     *  2. LONG_INTEGER desiredCapacity
     */

    public static long totalTriplets(List<Integer> capacity, long desiredCapacity) {
        long result = 0;
        for(int i=0; i<capacity.size();i++){
            for(int j=i+2;j<capacity.size();j++){
                if(capacity.get(i)*capacity.get(i+1)*capacity.get(j)==desiredCapacity && i<capacity.size()-2){
                    result = result+1;
                }

            }


        }

        for(int i = capacity.size()-1; i>=2; i--){
            for(int j=i-3;j>=0;j--){
                if(capacity.get(i)*capacity.get(i-1)*capacity.get(j)==desiredCapacity){
                    result = result+1;
                }
            }
        }

        return result;
    }

}

public class DistinctCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int capacityCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> capacity = IntStream.range(0, capacityCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long desiredCapacity = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result3.totalTriplets(capacity, desiredCapacity);
        System.out.println(result);
        //bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
