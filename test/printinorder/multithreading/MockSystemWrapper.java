package printinorder.multithreading;

import printinorder.multithreading.system.ISystemWrapper;

public class MockSystemWrapper implements ISystemWrapper {

    private String printString = "";

    @Override
    public void print(String thingToPrint) {
        printString = printString.concat(thingToPrint);
    }

    public String getPrintBuffer() {
        return this.printString;
    }

}
