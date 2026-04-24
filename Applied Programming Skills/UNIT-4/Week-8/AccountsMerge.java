import java.util.*;

public class AccountsMerge {
    static int[] parent;

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));

        int n = accounts.size();
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Map<String, Integer> emailOwner = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (emailOwner.containsKey(email)) {
                    parent[find(i)] = find(emailOwner.get(email));
                } else {
                    emailOwner.put(email, i);
                }
            }
        }

        Map<Integer, TreeSet<String>> groups = new HashMap<>();
        for (String email : emailOwner.keySet()) {
            int root = find(emailOwner.get(email));
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (int root : groups.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(root).get(0));
            merged.addAll(groups.get(root));
            result.add(merged);
        }

        System.out.println(result);
    }
}