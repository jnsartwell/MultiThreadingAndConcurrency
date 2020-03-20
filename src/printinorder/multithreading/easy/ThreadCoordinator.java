package printinorder.multithreading.easy;

public class ThreadCoordinator {

    private boolean _FirstFinished = false;
    private boolean _SecondFinished = false;

    public boolean firstFinished(){
        return _FirstFinished;
    }

    public void set_FirstFinished(boolean value) {
        _FirstFinished = value;
    }

    public boolean secondFinished(){
        return _SecondFinished;
    }

    public void set_SecondFinished(boolean value) {
        _SecondFinished = value;
    }

}
