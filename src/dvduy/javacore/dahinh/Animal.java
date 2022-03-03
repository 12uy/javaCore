package dvduy.javacore.dahinh;

public class Animal {
    String name,footType;

    public Animal() {
    }

    public Animal(String name, String footType) {
        this.name = name;
        this.footType = footType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFootType() {
        return footType;
    }

    public void setFootType(String footType) {
        this.footType = footType;
    }
    public void running(){
        System.out.println("Animal is running");
    }
}
