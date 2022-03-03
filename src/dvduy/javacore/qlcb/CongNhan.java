package dvduy.javacore.qlcb;

import java.util.Scanner;

public class CongNhan extends CanBo{
    private static final int BAC_MAX = 7;
    private int bac;

    public CongNhan() {
    }

    public CongNhan(String fullname, String gender, String address, String birthDay, int bac) {
        super(fullname, gender, address, birthDay);
        this.bac = bac;
    }

    @Override
    public String toString() {
        return super.toString() + "CongNhan{" +
                "bac=" + bac +
                '}';
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Nhap bac:");
        Scanner sc = new Scanner(System.in);
        bac = sc.nextInt();
    }
}
