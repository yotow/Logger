import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;

public class FilterTest {
    @Test
    public void filterOutTest() {

        int treshold = 5;

        final List<Integer> ordinal = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ordinal.add(i);
        }

        final List<Integer> shouldBeInList = new ArrayList<>();
        for (int i = treshold; i < 10; i++) {
            shouldBeInList.add(i);
        }

        final List<Integer> shouldNotBeInList = new ArrayList<>();
        for (int i = 0; i < treshold; i++) {
            shouldBeInList.add(i);
        }

        Filter filter = new Filter(treshold);
        List<Integer> res = filter.filterOut(ordinal);

        assertThat(res, hasSize(5));
        assertThat(res, containsInAnyOrder(9, 8, 7, 6, 5));
        assertThat(res, everyItem(not(isIn(shouldNotBeInList))));
        assertThat(res, everyItem(isIn(shouldBeInList)));
    }
}
