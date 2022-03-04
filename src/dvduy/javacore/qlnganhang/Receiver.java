package dvduy.javacore.qlnganhang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Receiver implements IFileInfor {
    int money;
    String note;
    Date createAt;

    public Receiver() {
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void input(){
        System.out.println("Nhap thong tin chuyen tien");
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap so tien");
        money = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap noi dung :");
        note= sc.nextLine();
        createAt = new Date();
    }

    @Override
    public String toString() {
        return "Receiver{" +
                "money=" + money +
                ", note='" + note + '\'' +
                ", createAt=" + getCreateAtToString() +
                '}';
    }

    public String getCreateAtToString(){
        SimpleDateFormat  sdf = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        String str = sdf.format(createAt);
        return str;

    }

    public static String getHeader(){
        return "Receiver";
    }

    @Override
    public String getFileInfor() {
        return money+","+note+","+getCreateAtToString();
    }

    @Override
    public void putFileInfor(String data) {
        String[] param = data.split(",");
        money=Integer.parseInt(param[0]);
        note=param[1];

        SimpleDateFormat sdf = new  SimpleDateFormat("hh:mm:ss dd/MM/yyyy");

        try {
            createAt = sdf.parse(param[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
