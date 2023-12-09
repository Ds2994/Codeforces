import java.io.*;

public class Rook {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());
        String[] input = new String[testCases];

        for(int i=0; i<testCases; i++) {
            input[i] = reader.readLine();
        }

        for(int i=0; i<testCases; i++) {
            printPath(input[i]);
        }
    }

    public static void printPath(String startingPoint) {
        char column = startingPoint.charAt(0);
        int row = startingPoint.charAt(1) - '0';

        for(int i=1; i<=8; i++) {
            if(i != row) {
                System.out.println(column + "" + i);
            }
        }

        for(char i = 'a'; i<='h'; i++) {
            if(i != column) {
                System.out.println(i + "" + row);
            }
        }
    }
}