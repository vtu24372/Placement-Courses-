public class ReverseString {

    // This matches the LeetCode-style function: input is a char array
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s1 = {'h','e','l','l','o'};
        char[] s2 = {'H','a','n','n','a','h'};

        System.out.println("Before reverse s1: " + String.valueOf(s1));
        reverseString(s1);
        System.out.println("After  reverse s1: " + String.valueOf(s1));

        System.out.println();

        System.out.println("Before reverse s2: " + String.valueOf(s2));
        reverseString(s2);
        System.out.println("After  reverse s2: " + String.valueOf(s2));
    }
}
