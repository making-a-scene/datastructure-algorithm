package quicksortstability;

public class QuickSortForBooks {

    private final Book[] books;

    public QuickSortForBooks(Book[] books) {
        this.books = books;
    }

    public void executeSorting(int start, int pivot) {
        if (start >= pivot) {
            return;
        }

        int pointer = start;
        for (int i = start; i < pivot; i++) {
            if (books[i].getId() <= books[pivot].getId()) {
                swap(i, pointer++);
            }
        }

        swap(pointer, pivot);

        executeSorting(start, pointer - 1);
        executeSorting(pointer + 1, pivot);
    }

    private void swap(int a, int b) {
        Book temp = books[a];
        books[a] = books[b];
        books[b] = temp;
    }
}