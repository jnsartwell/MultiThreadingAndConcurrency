package easy.multithreading;

import hard.multithreading.system.ISystemWrapper;

public class MockSystemWrapper implements ISystemWrapper {

    private String printString = "";

    @Override
    public void print(String thingToPrint) {
        printString = printString.concat(thingToPrint);
    }

    String getPrintBuffer() {
        return this.printString;
    }

}
