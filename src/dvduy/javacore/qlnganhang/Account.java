package dvduy.javacore.qlnganhang;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Account implements IFileInfor{
    String fullName, stk, phoneNumber, address;
    int money;

    List<Receiver> receiverList = new ArrayList<>();
    List<Tranfer> tranferList = new ArrayList<>();

    public Account() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Receiver> getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(List<Receiver> receiverList) {
        this.receiverList = receiverList;
    }

    public List<Tranfer> getTranferList() {
        return tranferList;
    }

    public void setTranferList(List<Tranfer> tranferList) {
        this.tranferList = tranferList;
    }

    @Override
    public String toString() {
        return "TaiKhoanNganHang{" +
                "fullName='" + fullName + '\'' +
                ", stk='" + stk + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", money=" + money +
                '}';
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho va ten:");
        fullName= sc.nextLine();
        System.out.println("Nhap stk: ");
        stk=sc.nextLine();
        System.out.println("Nhap sdt: ");
        phoneNumber=sc.nextLine();
        System.out.println("Nhap dia chi");
        address=sc.nextLine();

        money = 0;
    }

    public void addMoney(){
        Receiver receiver = new Receiver();
        receiver.input();

        receiverList.add(receiver);
        money+=receiver.getMoney();
    }

    public void tranfer(){
        Tranfer tranfer = new Tranfer();
        tranfer.input(money);

        tranferList.add(tranfer);

        //trừ tiền trong tk
        money-=tranfer.getMoney();
    }

    public void displayReceiverHistory(){
        System.out.println("Lich su nhan tien");
        receiverList.forEach(receiver -> System.out.println(receiver.toString()));
    }

    public void displayTranferHistory(){
        System.out.println("Lich su chuyen tien");
        tranferList.forEach( tranfer -> System.out.println(tranfer.toString()));
    }

    public static String getHeader(){
        return "Infor";
    }

    @Override
    public String getFileInfor() {
        return fullName+","+stk+","+phoneNumber+","+address+","+money;
    }

    @Override
    public void putFileInfor(String data) {
        String[] param = data.split(",");
        fullName = param[0];
        stk =param[1];
        phoneNumber=param[2];
        address=param[3];
        money= Integer.parseInt(param[4]);
    }
}

