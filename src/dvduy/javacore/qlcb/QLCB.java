package dvduy.javacore.qlcb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB {
    static List<CanBo> canBoList= new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choose;
        do{
            showMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose){
                case 1:
                    inputData();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    showData();
                    break;
                case 4:
                    System.out.println("thoat");
                    break;
                default:
                    System.out.println("Nhap sai !!!");
                    break;

            }
        }while (choose!=4);

    }

    static void showMenu(){
        System.out.println("1.Nhap");
        System.out.println("2.Tim kiem theo ho ten");
        System.out.println("3.Hien thi thong tin can bo tim duoc");
        System.out.println("4.thoat");
        System.out.println("Chon: ");
    }

    static void inputData(){
        System.out.println("So luong can bo can nhap");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            CanBo canBo = createCanBo();
            canBoList.add(canBo);
        }



    }

     static CanBo createCanBo() {
         CanBo cb=null;
         System.out.println("1. Nhap Cong Nhan");
         System.out.println("2. Nhap Ky su");
         System.out.println("3. Nhap nhan vien phuc vu");
         int choose = Integer.parseInt(sc.nextLine());
         switch (choose) {
             case 1:
                 cb = new CongNhan();
                 break;
             case 2:
                 cb = new KySu();
                 break;
             case 3:
                 cb = new NhanVienPhucVu();
                 break;
         }
         cb.input();

         return cb;
    }

    static void searchByName(){
        System.out.println("Nhap ten can bo can tim kiem:");
        String fullname=sc.nextLine();
        for (CanBo canBo :
                canBoList) {
            if (canBo.getFullname().equalsIgnoreCase(fullname)) {
                canBo.display();
            }
            }
        

    }

    static void showData(){
        for (CanBo canBo :
                canBoList) {
            canBo.display();
        }
    }
}
