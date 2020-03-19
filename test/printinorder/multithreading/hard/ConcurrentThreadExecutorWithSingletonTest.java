package printinorder.multithreading.hard;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import printinorder.multithreading.MockSystemWrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ConcurrentThreadExecutorWithSingletonTest {

    @Test
    @Order(1)
    public void testFooIsASingleton() {
        assertSame(FooSingleton.getInstance(), FooSingleton.getInstance());
    }

    @Test
    @Order(2)
    void testCaseOne() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{1, 2, 3});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    @Order(3)
    void testCaseTwo() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{1, 3, 2});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    @Order(4)
    void testCaseThree() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{2, 1, 3});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    @Order(5)
    void testCaseFour() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{2, 3, 1});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    @Order(6)
    void testCaseFive() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{3, 1, 2});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    @Order(7)
    void testCaseSix() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{3, 2, 1});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    @Order(8)
    void testCaseSeven() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{1});
       assertEquals("first", systemWrapper.getPrintBuffer());
    }

    @Test
    @Order(9)
    void testCaseEight() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{1, 2});
        assertEquals("firstsecond", systemWrapper.getPrintBuffer());
    }

    @Test
    @Order(10)
    void testCaseNine() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{2, 1});
        assertEquals("firstsecond", systemWrapper.getPrintBuffer());
    }


}
