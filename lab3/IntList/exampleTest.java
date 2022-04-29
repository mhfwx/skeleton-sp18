import static org.junit.Assert.*;

import org.junit.Test;

public class exampleTest {
    @Test
    public void test(){
        int[][] a = {{1, 2, 3}, {5,6}, {7, 8}};
        int [] x = {1,2,3,5,6,7,8};
        assertArrayEquals(x, example.flatten(a));
    }

}
