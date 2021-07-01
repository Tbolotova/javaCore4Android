import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static lesson14HW.Task2ArrOnesFours.checkArrOneFour;

public class Task2ArrOnesFoursTest {
    private static final int[] arr1 = {1, 1, 1, 4, 4, 1, 4, 4};
    private static final int[] arr2 = {1, 1, 1, 1, 1, 1};
    private static final int[] arr3 = {4, 4, 4, 4};
    private static final int[] arr4 = {1, 4, 4, 1, 1, 4, 3};



    @ParameterizedTest
    @MethodSource("dataForCheckArrOneFour")
    public void testCheckArrOneFour(int[] arr, boolean result){
        Assertions.assertEquals(checkArrOneFour(arr), result);
    }

    public static Stream<Arguments> dataForCheckArrOneFour() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(arr1, true));
        out.add(Arguments.arguments(arr2, false));
        out.add(Arguments.arguments(arr3, false));
        out.add(Arguments.arguments(arr4, false));
        return out.stream();
    }

}
