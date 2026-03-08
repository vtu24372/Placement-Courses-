import java.util.Stack;

class StockSpan {

    // Stack stores [price, span]
    private Stack<int[]> stack;

    public StockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1; // Today counts as 1

        // Merge spans of previous days with price <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.peek()[1];
            stack.pop();
        }

        // Push current day's price and span
        stack.push(new int[]{price, span});

        return span;
    }
}

public class StockSpanner {
    public static void main(String[] args) {
        StockSpan stockSpanner = new StockSpan();

        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("Input prices: ");
        for (int p : prices) {
            System.out.print(p + " ");
        }
        System.out.println("\nSpans: ");

        for (int price : prices) {
            int span = stockSpanner.next(price); // fixed name
            System.out.print(span + " ");
        }

        // Expected output: 1 1 1 2 1 4 6
    }
}
