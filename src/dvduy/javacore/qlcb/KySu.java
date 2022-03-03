package dvduy.javacore.qlcb;

import java.util.Scanner;

public class KySu extends CanBo{
    private String nghanhDaoTao;

    public KySu() {
    }

    public KySu(String fullname, String gender, String address, String birthDay, String nghanhDaoTao) {
        super(fullname, gender, address, birthDay);
        this.nghanhDaoTao = nghanhDaoTao;
    }

    public String getNghanhDaoTao() {
        return nghanhDaoTao;
    }

    public void setNghanhDaoTao(String nghanhDaoTao) {
        this.nghanhDaoTao = nghanhDaoTao;
    }

    @Override
    public String toString() {
        return super.toString()+ "KySu{" +
                "nghanhDaoTao='" + nghanhDaoTao + '\'' +
                '}';
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Nhap nganh dao tao:");
        Scanner sc = new Scanner(System.in);
        nghanhDaoTao=sc.nextLine();
    }
}
