import java.io.*;
import java.util.*;

public class HalloumiBoxes {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        ArrayList<TestCase> testCaseList = new ArrayList<>();

        for(int i=0; i<testCases; i++) {
            String second = reader.readLine();
            int n = Integer.parseInt(second.split(" ")[0]);
            int k = Integer.parseInt(second.split(" ")[1]);

            int[] boxes = new int[n];
            String[] third = reader.readLine().split(" ");

            for(int j=0; j<n; j++) {
                boxes[j] = Integer.parseInt(third[j]);
            }

            testCaseList.add(new TestCase(n, k, boxes));
        }

        testCaseList.forEach(testCase -> {
            if(solve(testCase.n, testCase.k, testCase.arr))
                System.out.println("YES");
            else
                System.out.println("NO");
        });
    }

    public static boolean solve(int n, int k, int[] boxes) {
        if(isSorted(boxes)) {
            return true;
        }

        if(k >= 2) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n-1; j++) {
                    if(boxes[j] > boxes[j+1]) {
                        int temp = boxes[j];
                        boxes[j] = boxes[j+1];
                        boxes[j+1] = temp;
                    }
                }
            }
            return true;
        }

        return false;
    }

    public static boolean isSorted(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}

class TestCase {
    int n;
    int k;
    int[] arr;

    public TestCase(int n, int k, int[] arr) {
        this.n = n;
        this.k = k;
        this.arr = arr;
    }
}