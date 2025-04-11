package etcc.line.e2022;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {

    static String solution(int k, String[] dic, String chat) {
        String dic2 = String.join(" ", dic);
        String[] chat2 = chat.split(" ");
        var builder = new StringBuilder();
        for (String word : chat2) {
            String regex = "\\b" + word.replace(".", ".{1," + k + "}") + "\\b";
            Matcher matcher = Pattern.compile(regex).matcher(dic2);
            builder.append(matcher.find() ? "#".repeat(word.length()) : word)
                   .append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        var dic = new String[] { "slang", "badword" };
        var chat = "badword ab.cd bad.ord .word sl.. bad.word";
        System.out.println(solution(2, dic, chat));

        dic = new String[] { "abcde", "cdefg", "efgij" };
        chat = ".. ab. cdefgh .gi. .z.";
        System.out.println(solution(3, dic, chat));
    }
}