import java.io.*;
import java.util.*;

public class BinaryImbalance {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        ArrayList<TestCase> testCaseList = new ArrayList<>();

        for(int i=0; i<testCases; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            int zeroes = 0;

            String third = reader.readLine();
            for(int j=0; j<n; j++) {
                arr[j] = third.charAt(j) - '0';
                if(arr[j] == 0) {
                    zeroes++;
                }
            }
            testCaseList.add(new TestCase(n, zeroes, arr));
        }

        testCaseList.forEach(testCase -> {
            if(canBalance(testCase.n, testCase.zeroes, testCase.arr))
                System.out.println("YES");
            else
                System.out.println("NO");
        });
    }

    public static boolean canBalance(int n, int zeroes, int[] arr) {
        int ones = n-zeroes;
        if(zeroes > ones) {
            return true;
        }

        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] == 0 && arr[i+1] == 1) {
                return true;
            } else if(arr[i] == 1 && arr[i+1] == 0) {
                return true;
            }
        }

        return false;
    }
}

class TestCase {
    int n;
    int zeroes;
    int[] arr;

    public TestCase(int n, int zeroes, int[] arr) {
        this.n = n;
        this.zeroes = zeroes;
        this.arr = arr;
    }
}