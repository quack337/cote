package programmers.p42893;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    static class Solution {

        String[] getPageUrls(String[] pages) throws Exception {
            final String URL_PATTERN = "(?i)<meta property=\"og:url\" content=\"https://([^\"]+)\"";
            String[] urls = new String[pages.length];
            Pattern pattern = Pattern.compile(URL_PATTERN);
            for (int i = 0; i < pages.length; ++i) {
               Matcher m = pattern.matcher(pages[i]);
               if (!m.find()) throw new Exception("my url not found");
               urls[i] = m.group(1);
            }
            return urls;
        }

        @SuppressWarnings("unchecked")
        Set<String>[] getLinks(String[] pages) throws Exception {
            final String LINK_PATTERN = "(?i)<a href=\"https://([^\"]+)\"";
            var links = new HashSet[pages.length];
            Pattern pattern = Pattern.compile(LINK_PATTERN);
            for (int i = 0; i < pages.length; ++i) {
               links[i] = new HashSet<String>();
               Matcher m = pattern.matcher(pages[i]);
               while (m.find()) {
                  String url = m.group(1);
                  if (links[i].contains(url)) throw new Exception("duplicate link found");
                  links[i].add(url);
               }
            }
            return links;
        }

        int[] getKeywordCounts(String[] pages, String keyword) {
            final String SPACE_PATTERN = "(<[^>]+>)|([0-9]+)";
            final String keyword_pattern = "(?i)\\b" + keyword + "\\b";
            for (int i = 0; i < pages.length; ++i)
                pages[i] = pages[i].replaceAll(SPACE_PATTERN, " ");
            int[] counts = new int[pages.length];
            Pattern pattern = Pattern.compile(keyword_pattern);
            for (int i = 0; i < pages.length; ++i) {
               Matcher m = pattern.matcher(pages[i]);
               while (m.find()) ++counts[i];
            }
            return counts;
        }

        public int solution(String word, String[] pages) throws Exception {
            String[] urls = getPageUrls(pages);
            Set<String>[] links = getLinks(pages);
            int[] 기본점수 = getKeywordCounts(pages, word);
            double 최대점수 = 0;
            int answer = 0;
            for (int i = 0; i < pages.length; ++i) {
               double 링크점수 = 0;
               for (int j = 0; j < pages.length; ++j) {
                   if (links[j].contains(urls[i]))
                       링크점수 += (double)기본점수[j] / links[j].size();
               }
               double 매칭점수 = 링크점수 + 기본점수[i];
               if (매칭점수 > 최대점수) {
                   최대점수 = 매칭점수;
                   answer = i;
               }
            }
            return answer;
        }
    }

    public static void main(String[] args) throws Exception {
        String[] pages1 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
        String[] pages2 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        System.out.println(new Solution().solution("blind", pages1));
        System.out.println(new Solution().solution("muzi", pages2));
    }
}