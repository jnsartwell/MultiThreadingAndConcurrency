package printinorder.multithreading.hard;

import org.junit.jupiter.api.Test;
import printinorder.multithreading.MockSystemWrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConcurrentThreadExecutorWithSingletonWithSingletonTest {

    @Test
    void testCaseOne() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{1, 2, 3});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    void testCaseTwo() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{1, 3, 2});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    void testCaseThree() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{2, 1, 3});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    void testCaseFour() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{2, 3, 1});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    void testCaseFive() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{3, 1, 2});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    void testCaseSix() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{3, 2, 1});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    void testCaseSeven() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{1});
        assertEquals("first", systemWrapper.getPrintBuffer());
    }

    @Test
    void testCaseEight() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{1, 2});
        assertEquals("firstsecond", systemWrapper.getPrintBuffer());
    }

    @Test
    void testCaseNine() {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrentThreadExecutorWithSingleton(systemWrapper).execute(new int[]{2, 1});
        assertEquals("firstsecond", systemWrapper.getPrintBuffer());
    }


}
