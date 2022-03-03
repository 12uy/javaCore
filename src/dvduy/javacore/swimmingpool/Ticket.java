package dvduy.javacore.swimmingpool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Ticket {
    String code;
    Date registerDate;

    static  List<Character> cList = new ArrayList<>();
    static List<Integer> indexList= new ArrayList<>();

    public Ticket() {
    }

    public String getCode() {
        return code;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public void autoGenerateCode(){
        //tự động sinh code
        code="";
        insertChar();
        for (int i = 0; i < indexList.size(); i++) {
            int currentIndex = indexList.get(i);
            System.out.println("current index = "+ currentIndex);
            code += String.valueOf(cList.get(currentIndex));

        }
        int lastIndex = indexList.size() - 1;
        indexList.set(lastIndex, indexList.get(lastIndex) + 1);
        for (int i = indexList.size()-1;i>0;i--){
            if(indexList.get(i)<cList.size())
                break;
            indexList.set(i,0);
            indexList.set(i-1,indexList.get(i-1)+1);
        }

    }

    private void insertChar(){
        if(cList.size()>0) return;
        //add tất cả các ký tự cho phép vào 1 list
        for (int i = (int) 'a'; i < (int) 'z' ; i++) {
            cList.add((char) i);
        }
        for (int i = (int) 'A'; i < (int) 'Z' ; i++) {
            cList.add((char) i);
        }
        for (int i = (int) '0'; i < (int) '9' ; i++) {
            cList.add((char) i);
        }

        //khởi tạo 1 chuỗi 6 ký tự ban đầu là aaaaaa
        for (int i =0; i<6;i++){
            indexList.add(0);
        }
    }
}
