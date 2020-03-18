package multithreading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultithreadingConcurrencyTest {

    @Test
    public void testCaseOne() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{1, 2, 3});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    public void testCaseTwo() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{1, 3, 2});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    public void testCaseThree() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{2, 1, 3});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    public void testCaseFour() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{2, 3, 1});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    public void testCaseFive() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{3, 1, 2});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    public void testCaseSix() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{3, 2, 1});
        assertEquals("firstsecondthird", systemWrapper.getPrintBuffer());
    }

    @Test
    public void testCaseSeven() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{1});
        assertEquals("first", systemWrapper.getPrintBuffer());
    }

    @Test
    public void testCaseEight() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{1, 2});
        assertEquals("firstsecond", systemWrapper.getPrintBuffer());
    }

    @Test
    public void testCaseNine() throws Exception {
        MockSystemWrapper systemWrapper = new MockSystemWrapper();
        new ConcurrencyThreading(systemWrapper).execute(new int[]{2, 1});
        assertEquals("firstsecond", systemWrapper.getPrintBuffer());
    }


}
