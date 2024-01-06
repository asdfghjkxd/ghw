package sort.test;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import sort.Sort;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertThrows;

public class SortTest {
    private final static List<Integer> sortedAscending = new ArrayList<>(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    private final static List<Integer> sortedDescending = new ArrayList<>(
            List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
    private final static List<Integer> randomList = new ArrayList<>(
            List.of(5, 6, 7, 10, 9, 3, 1, 4, 2, 8));
    private final static List<Comparable<?>> unsortableList = new ArrayList<>(
            List.of(1, "Hello", 1.33333333)
    );
    private final static List<Integer> repeatedList = new ArrayList<>(
            List.of(1, 1, 2, 10, 1, 99, 7, 1, 1, 1)
    );
    private final static List<Integer> repeatedSorted = new ArrayList<>(
            List.of(1, 1, 1, 1, 1, 1, 2, 7, 10, 99)
    );

    @Test
    public void sort_validSortedInput_valid() {
        List<Integer> toSort = new ArrayList<>(sortedAscending);
        Sort.sort(toSort);

        assertTrue(toSort.equals(sortedAscending));
    }

    @Test
    public void sort_validDescendingInput_valid() {
        List<Integer> toSort = new ArrayList<>(sortedDescending);
        Sort.sort(toSort);

        assertTrue(toSort.equals(sortedAscending));
    }

    @Test
    public void sort_validRandomInput_valid() {
        List<Integer> toSort = new ArrayList<>(randomList);
        Sort.sort(toSort);

        assertTrue(toSort.equals(sortedAscending));
    }

    @Test
    public void sort_unsortableList_invalid() {
        List<Comparable> toSort = new ArrayList<>(unsortableList);

        // it is safe to suppress this warning as we expect this method to fail
        // anyways
        @SuppressWarnings("unchecked")
        ThrowingRunnable throwingRunnable = () -> Sort.sort(toSort);

        assertThrows(ClassCastException.class, throwingRunnable);
    }

    @Test
    public void sort_repeatedList_valid() {
        List<Integer> toSort = new ArrayList<>(repeatedList);
        Sort.sort(toSort);

        System.out.println(toSort);

        assertTrue(toSort.equals(repeatedSorted));
    }
}
