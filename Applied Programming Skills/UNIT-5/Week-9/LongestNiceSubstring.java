public class LongestNiceSubstring {
    static String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.contains(String.valueOf(Character.toUpperCase(c))) &&
                s.contains(String.valueOf(Character.toLowerCase(c)))) continue;

            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));
            return left.length() >= right.length() ? left : right;
        }

        return s;
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        System.out.println(longestNiceSubstring(s));
    }
}