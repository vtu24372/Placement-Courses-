import java.util.*;

public class UniqueEmailAddresses {
    public static void main(String[] args) {
        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };

        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0].replace(".", "");
            unique.add(local + "@" + parts[1]);
        }

        System.out.println(unique.size());
    }
}