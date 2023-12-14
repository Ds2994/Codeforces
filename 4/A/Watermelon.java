import java.io.*;

public class Watermelon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int weight = Integer.parseInt(reader.readLine());

        if(weight == 2) {
            System.out.println("NO");
        } else {
            if(weight % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}