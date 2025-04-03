package kakao.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example01 {

    public static void main(String[] args) {
        String[] a = new String[] { "1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*" };
        String regex = "([0-9]+)([SDT])([#*]?)";
        Pattern pattern = Pattern.compile(regex);

        for (String s : a) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                int 점수 = Integer.valueOf(matcher.group(1).toString());
                String 보너스 = matcher.group(2).toString();
                String 옵션 = matcher.group(3).toString();

                System.out.printf("%d %s %s; ", 점수, 보너스, 옵션);
            }
            System.out.println();
        }
    }
}