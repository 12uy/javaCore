package dvduy.javacore.qlnganhang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Account account = null;

    public static void main(String[] args) {
        login();
        System.out.println("Next step");
        int choose;
        do {
            showMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    account = new Account();
                    account.input();
                    break;
                case 2:
                    if (account !=null){
                        account.addMoney();
                    }
                    else
                        System.err.println("TK khong ton tai");
                    break;
                case 3:
                    if (account !=null){
                        account.tranfer();
                    }
                    else
                        System.err.println("TK khong ton tai");
                    break;
                case 4:
                    if (account !=null){
                        account.displayReceiverHistory();
                    }
                    else
                        System.err.println("TK khong ton tai");
                    break;
                case 5:
                    if (account !=null){
                        account.displayTranferHistory();
                    }
                    else
                        System.err.println("TK khong ton tai");
                    break;
                case 6:
                        saveFile();
                    break;
                case 7:
                        readFile();
                    break;
                case 8:
                    System.out.println(account.toString());
                    break;
                case 9:
                    System.out.println("Thoat!");
                    break;
                default:
                    System.out.println("Nhap sai");
                    break;
            }
        }while (choose!=9);
    }

    private static void readFile() {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream("Account.txt");

            isr = new InputStreamReader(fis);

            br = new BufferedReader(isr);

            String line = null;

            account = new Account();

            while ((line = br.readLine())!=null){
                if(line.isEmpty())
                    continue;
                if(line.equalsIgnoreCase("Infor")){
                    String data = br.readLine();
                    account.putFileInfor(data);
                }
                else if (line.equalsIgnoreCase("Receiver")){
                    while (!(line= br.readLine()).equalsIgnoreCase("Tranfer")){
                        Receiver receiver = new Receiver();
                        String data = line;
                        receiver.putFileInfor(data);
                        account.receiverList.add(receiver);
                    }
                }
                else{
                        Tranfer tranfer = new Tranfer();
                        String data = line;
                        tranfer.putFileInfor(data);
                        account.tranferList.add(tranfer);
                }


            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void saveFile() {
        FileOutputStream fos = null;
        try {
            fos=new FileOutputStream("Account.txt");

            String line = Account.getHeader() + "\n";

            byte[] data = line.getBytes();
            //header
            fos.write(data);
            //than
            line = account.getFileInfor() + "\n";
            fos.write(line.getBytes());

            //lich su nhan tien
            line = Receiver.getHeader() + "\n";
            fos.write(line.getBytes());

            for( Receiver receiver : account.getReceiverList()){
                line = receiver.getFileInfor()+"\n";
                fos.write(line.getBytes());
            }

            //lich su chuyen tien
            line = Tranfer.getHeader() + "\n";
            fos.write(line.getBytes());

            for( Tranfer tranfer : account.getTranferList()){
                line = tranfer.getFileInfor()+"\n";
                fos.write(line.getBytes());
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    static void showMenu(){
        System.out.println("1.Khoi tao tai khoan");
        System.out.println("2.Nap tien");
        System.out.println("3.Chuyen tien");
        System.out.println("4.Xem lich su nap tien");
        System.out.println("5.Xem lich su gui tien");
        System.out.println("6.Luu file");
        System.out.println("7.Doc du lieu");
        System.out.println("8.Kiem tra tai khoan");
        System.out.println("9.Thoat");
        System.out.println("Chon");


    }

    static void login(){
        System.out.println("=====WELLCOME=====");
        System.out.println("User name: ");
        String userName = sc.nextLine();

        System.out.println("Password: ");
        String password = sc.nextLine();

        if(userName.equalsIgnoreCase("duy")&&password.equalsIgnoreCase("duy123")){
            System.out.println("login success");
        }
        else {
            System.err.println("Login Failed");
            login();
        }
    }
}
