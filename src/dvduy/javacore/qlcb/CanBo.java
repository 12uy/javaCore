package dvduy.javacore.qlcb;

import java.util.Date;
import java.util.Scanner;

public class CanBo {
    private String fullname,birthDay,gender,address;


    public CanBo() {
    }

    public CanBo(String fullname, String gender, String address, String birthDay) {
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.birthDay = birthDay;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "fullname='" + fullname + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void display(){
        System.out.println(this);
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten: ");
        fullname=sc.nextLine();
        System.out.println("Nhap ngay sinh: ");
        birthDay=sc.nextLine();
        System.out.println("Nhap gioi tinh: ");
        gender=sc.nextLine();
        System.out.println("Nhap dia chi: ");
        address=sc.nextLine();
    }
}
