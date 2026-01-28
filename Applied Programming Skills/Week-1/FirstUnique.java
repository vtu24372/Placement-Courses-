import java.util.Scanner;

class FirstUnique {

    
    public int firstUniqChar(String s) {
        int[] freq = new int[26]; 

        
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1; 
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string (only lowercase letters): ");
        String s = sc.nextLine();

        FirstUnique obj = new FirstUnique();
        int index = obj.firstUniqChar(s);

        if (index == -1) {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character index: " + index);
            System.out.println("Character: " + s.charAt(index));
        }

        sc.close();
    }
}
