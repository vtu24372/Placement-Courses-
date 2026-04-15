import java.util.Arrays;

public class FloodFill {
    static void dfs(int[][] img, int i, int j, int orig, int color) {
        if (i<0 || i>=img.length || j<0 || j>=img[0].length || img[i][j]!=orig) return;
        img[i][j] = color;
        dfs(img, i+1, j, orig, color);
        dfs(img, i-1, j, orig, color);
        dfs(img, i, j+1, orig, color);
        dfs(img, i, j-1, orig, color);
    }

    public static void main(String[] args) {
        int[][] img = {{1,1,1},{1,1,0},{1,0,1}};
        if (img[1][1] != 2) dfs(img, 1, 1, img[1][1], 2);
        for (int[] row : img)
            System.out.println(Arrays.toString(row));
    }
}