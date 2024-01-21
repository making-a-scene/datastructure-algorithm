package knapsackproblem;

public class DynamicProgramming {
    public static void main(String args[]) {
        Item[] items = new Item[5];

        items[0] = new Item(3, 5);
        items[1] = new Item(9, 12);
        items[2] = new Item(1, 2);
        items[3] = new Item(5, 4);
        items[4] = new Item(7, 9);

        int maxValue = getMaxValue(15, items);
        System.out.println(String.format("Max Value: %d", maxValue));
    }

    private static int getMaxValue(int numSpace, Item[] items) {
        int numItems = items.length;
        int cache[][] = new int[numItems][numSpace + 1];

        for (int i = 1; i <= numSpace; i++) {
            if (items[0].getSpace() >= numSpace) {
                cache[0][i] = items[0].getValue();
            } else {
                cache[0][i] = 0;
            }
        }

        for (int j = 1; j < numItems; j++) {
            for (int i = 1; i <= numSpace; i++) {
                if (items[j].getSpace() >= numSpace) {
                    cache[j][i] = cache[j - 1][i] + items[j].getValue();
                } else {
                    int currVal = items[j].getValue() + (cache[j - 1][numSpace - items[j].getSpace()]);
                    cache[j][i] = (cache[j - 1][i] > currVal) ? cache[j - 1][i] : currVal;
                }
            }
        }

        return cache[numItems - 1][numSpace];
    }
}