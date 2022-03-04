package dvduy.javacore.qlnganhang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Tranfer implements IFileInfor{
    String tranferSTK,note;
    int money;
    Date createAt;

    public Tranfer() {
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTranferSTK() {
        return tranferSTK;
    }

    public void setTranferSTK(String tranferSTK) {
        this.tranferSTK = tranferSTK;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Date getCreateAt() {
        return createAt;

    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Tranfer{" +
                "tranferSTK='" + tranferSTK + '\'' +
                ", note='" + note + '\'' +
                ", money=" + money +
                ", createAt=" + getCreateAtToString() +
                '}';
    }

    public void input(int maxMoney){
        System.out.println("Nhap thong tin chuyen tien");
        Scanner sc= new Scanner(System.in);
        System.out.println("Nhap stk nguoi nhan");
        tranferSTK= sc.nextLine();
        for (;;){
            System.out.println("Nhap so tien chuyen :");
            money = Integer.parseInt(sc.nextLine());
            if(money <=maxMoney)
                break;
            else
                System.err.println("So tien chuyen vuot qua so du");
        }
        System.out.println("Nhap noi dung:");
        note= sc.nextLine();
        createAt = new Date();
    }
    public String getCreateAtToString(){
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        String str = sdf.format(createAt);
        return str;

    }

    public static String getHeader(){
        return "Tranfer";
    }

    @Override
    public String getFileInfor() {
        return tranferSTK+","+money+","+note+","+getCreateAtToString();
    }

    @Override
    public void putFileInfor(String data) {
        String[] param = data.split(",");
        tranferSTK = param[0];

        money = Integer.parseInt(param[1]);

        note = param[2];

        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        try {
            createAt = format.parse(param[3]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
