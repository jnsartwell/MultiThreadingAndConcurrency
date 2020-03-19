package easy.multithreading.system;

class SystemWrapper implements ISystemWrapper {

    public SystemWrapper() {
    }

    @Override
    public void print(String thingToPrint) {
        System.out.print(thingToPrint);
    }

}
