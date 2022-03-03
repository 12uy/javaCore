package dvduy.javacore.Lambda;

public abstract class Animal implements IRunning{
    String Name;

    public Animal() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public abstract void showSound();

    @Override
    public void onRunninh() {
        System.out.println("animal is running");
    }
}
