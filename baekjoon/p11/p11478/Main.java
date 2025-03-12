
public class Main {
    public static void main(String[] args) throws java.io.IOException {
        var reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        var set = new java.util.HashSet<String>();
        var s = reader.readLine();
        for (int a = 0; a < s.length(); a++)
            for (int b = a + 1; b <= s.length(); b++)
                set.add(s.substring(a, b));
        System.out.print(set.size());
    }
}