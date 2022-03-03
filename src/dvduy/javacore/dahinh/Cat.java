package dvduy.javacore.dahinh;

public class Cat extends Animal{
    String color;

    public Cat() {
    }

    public Cat(String name, String footType, String color) {
        super(name, footType);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showSounds(){
        System.out.println("meo meo ... ");

    }

    @Override
    public void running() {
        System.out.println("Cat is running...");
    }
}
