package dvduy.javacore.Lambda;

public class Cat extends Animal {

    @Override
    public void showSound() {
        System.out.println("meo meo");
    }

    @Override
    public void onRunninh() {
        super.onRunninh();
        System.out.println("this is cat");
    }
}
