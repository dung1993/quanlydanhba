package src;

import java.util.Scanner;

public class Menu {
    public static void view(){
        Scanner scanner =new Scanner(System.in);
        int choice;
        do {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Trình Quản Lý Danh Bạ<<<<<<<<<<<<<<<<<<<<<<<<<<");
            System.out.println("*******************************************************************************");
            System.out.println(">>                           1.Danh sách danh bạ                             <<");
            System.out.println(">>                           2.Thêm danh bạ                                  <<");
            System.out.println(">>                           3.Cập nhật danh bạ                              <<");
            System.out.println(">>                           4.Xóa danh bạ                                   <<");
            System.out.println(">>                           5.Tìm kiếm danh bạ                              <<");
            System.out.println(">>                           6.Đọc Từ File                                   <<");
            System.out.println(">>                           7.Ghi vào File                                  <<");
            System.out.println(">>                           8.Thoát                                         <<");
            System.out.println("*******************************************************************************");
            System.out.println("Chọn chức năng:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    DanhBaView.showPhoneList();
                    break;
                case 2:
                    DanhBaView.addPhone();
                    break;
                case 3:
                    DanhBaView.editPhone();
                    break;
                case 4:
                    DanhBaView.removePhone();
                    break;
                case 5:
                    DanhBaView.findPhone();
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        } while (choice != 8);
    }
}
