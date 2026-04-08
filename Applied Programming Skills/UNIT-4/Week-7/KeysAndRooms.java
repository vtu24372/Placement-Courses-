import java.util.*;
public class KeysAndRooms {
    public static void main(String[] args) {
        System.out.println(canVisit(Arrays.asList(Arrays.asList(1),Arrays.asList(2),Arrays.asList(3),Arrays.asList())));         // true
        System.out.println(canVisit(Arrays.asList(Arrays.asList(1,3),Arrays.asList(3,0,1),Arrays.asList(2),Arrays.asList(0)))); // false
    }
    static boolean canVisit(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, visited, 0);
        for (boolean v : visited) if (!v) return false;
        return true;
    }
    static void dfs(List<List<Integer>> rooms, boolean[] visited, int i) {
        visited[i] = true;
        for (int key : rooms.get(i))
            if (!visited[key]) dfs(rooms, visited, key);
    }
}