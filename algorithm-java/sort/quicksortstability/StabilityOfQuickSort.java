package quicksortstability;
import java.util.Arrays;
import java.util.Comparator;

public class StabilityOfQuickSort {
    
    public static void main(String args[]) {

        Book[] books = new Book[10];

        books[0] = new Book(5, "My Book 5 copy 1");
        books[1] = new Book(1, "My Book 1");
        books[2] = new Book(5, "My Book 5");
        books[3] = new Book(1, "My Book 1 copy 2");
        books[4] = new Book(3, "My Book 3");
        books[5] = new Book(2, "My Book 2");
        books[6] = new Book(4, "My Book 4 copy 1");
        books[7] = new Book(4, "My Book 4");
        books[8] = new Book(1, "My Book 1 copy 1");
        books[9] = new Book(4, "My Book 4 copy 2");

        // Sort books using quick sort.
        Book[] copyOfBooks1 = copyBooks(books);
        QuickSortForBooks quickSort = new QuickSortForBooks(copyOfBooks1);
        quickSort.executeSorting(0, copyOfBooks1.length - 1);
        printBooks(copyOfBooks1); // Not stable.

        System.out.println("================================");

        // Sort books using java.utils.Arrays (which is using merge sort).
        Book[] copyOfBooks2 = copyBooks(books);
        Arrays.sort(copyOfBooks2, Comparator.comparingInt(Book::getId));
        printBooks(copyOfBooks2); // Stable!
    }

    private static Book[] copyBooks(Book[] books1) {
        Book[] books2 = new Book[books1.length];
        for (int i = 0; i < books1.length; i++) {
            books2[i] = books1[i];
        }
        return books2;
    }

    private static void printBooks(Book[] books) {
        for (Book book : books) {
            System.out.println("id: " + book.getId() + ", title: " + book.getTitle());
        }
    }
}