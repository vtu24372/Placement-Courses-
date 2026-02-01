public class MinRemoveParenthesesVS {
    public static String minRemoveToMakeValid(String s) {
        int n = s.length();
        boolean[] remove = new boolean[n];

        int balance = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') balance++;
            else if (c == ')') {
                if (balance == 0) remove[i] = true;
                else balance--;
            }
        }

        int openToRemove = balance;
        for (int i = n - 1; i >= 0 && openToRemove > 0; i--) {
            if (s.charAt(i) == '(' && !remove[i]) {
                remove[i] = true;
                openToRemove--;
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!remove[i]) ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)")); // lee(t(c)o)de
        System.out.println(minRemoveToMakeValid("a)b(c)d"));       // ab(c)d
        System.out.println(minRemoveToMakeValid("))(("));          // ""
    }
}
