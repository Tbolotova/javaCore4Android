import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;

import static lesson14HW.Task1ArrFours.extractAfterLastFour;

public class Task1ArrFoursTest {

    @Test
    public void testExtractAfterFour() {
        int[] initialArrWithFours = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] initialArrNoFours = {1, 2, 2, 3, 1, 7};

        ArrayList<Integer> expectedResult = new ArrayList<>();
        ArrayList<Integer> expectedResult1 = new ArrayList<>();
        Collections.addAll(expectedResult, 1, 7);
        Collections.addAll(expectedResult1, 5, 9);

        // с четверками
        Assertions.assertEquals(expectedResult, extractAfterLastFour(initialArrWithFours));

        Assertions.assertEquals(expectedResult1, extractAfterLastFour(new int[]{1, 2, 4, 4, 2, 3, 4, 5, 9}));

        // и без
        try {
            Assertions.assertEquals(expectedResult, extractAfterLastFour(initialArrNoFours));
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
