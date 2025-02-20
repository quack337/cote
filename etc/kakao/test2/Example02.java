package net.skhu.kakao.test2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example02 {

    public static void main(String[] args) {
        String[] a = new String[] { "1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*" };
        String regex = "([0-9]+)([SDT])([#*]?)";
        Pattern pattern = Pattern.compile(regex);

        for (String s : a) {
            int[] 점수 = new int[3];
            int i = 0;
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                점수[i] = Integer.valueOf(matcher.group(1).toString());
                String 보너스 = matcher.group(2).toString();
                String 옵션 = matcher.group(3).toString();

                if (보너스.equals("D"))
                    점수[i] = 점수[i] * 점수[i];  // 제곱
                else if (보너스.equals("T"))
                    점수[i] = 점수[i] * 점수[i] * 점수[i]; // 세제곱

                if (옵션.equals("#"))
                    점수[i] = -점수[i];
                else if (옵션.equals("*")) {
                    점수[i] *= 2;
                    if (i > 0) 점수[i-1] *= 2;
                }
                ++i;
            }
            System.out.println(점수[0] + 점수[1] + 점수[2]);
        }
    }
}
