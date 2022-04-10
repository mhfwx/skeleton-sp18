import static org.junit.Assert.*;

import org.junit.Test;

public class HorriableSteveTest {
    @Test
    public void test1(){
        boolean a = Flik.isSameNumber(128,128);
        assertEquals(true, a);
    }

    @Test
    public void test2(){
        boolean a = Flik.isSameNumber(256,256);
        assertEquals(true, a);
    }

    @Test
    public void test3(){
        boolean a = Flik.isSameNumber(255,255);
        assertEquals(true, a);
    }
    @Test
    public void test4(){
        boolean a = Flik.isSameNumber(127,127);
        assertEquals(true, a);
    }
}
