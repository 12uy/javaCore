package dvduy.javacore.dahinh;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.running();

        Cat cat = new Cat();
        cat.running();
        cat.showSounds();

        Animal abc = new Cat();
        abc.running();
        //đối tượng abc lúc này có 2 kiểu:
        //1 compile time: (lúc viết code) thì nó hiểu abc là animal chỉ gọi được các phương thức của animal
        //2 runtime: (khi chạy chương trình) thì nó hiểu abc là đôi dược cat và chạy các phương thức của lớp cat nếu được gọi
        //Nếu muốn gọi tất cả các phương thức của Cat thì cần
        if(abc instanceof Cat){
            ((Cat) abc).showSounds();
        }
        // cách này sử dụng khi phương thức ko khai báo ở lớp cha nhưng khai báo ở lớp con

        // Đa hình có thể dùng để lập 1 list gồm nhiều loại vd lập 1 list cac dong vat trong list do cha cac loai đv khac nhau : cat dog ...
    }
}
