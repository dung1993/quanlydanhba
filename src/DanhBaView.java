package src;

import java.util.List;
import java.util.Scanner;

public class DanhBaView {
    public List<SoDanhBa> soDanhBa;
    private static DanhBaService danhBaService = new DanhBaService();
    static Scanner scanner = new Scanner(System.in);

    public static void addPhone() {
        boolean flag = true;
        do {
            System.out.println();
            System.out.println("Add 'danhba");
            String numberPhone = inputPhoneNumber(ChoiceStatus.ADD);
            String nhom = inputNhom(ChoiceStatus.ADD);
            String fullName = inputFullName(ChoiceStatus.ADD);
            String gioiTinh = inputGioiTinh(ChoiceStatus.ADD);
            String address = inputDiaChi(ChoiceStatus.ADD);
            String birthDate = inputBirthDate(ChoiceStatus.ADD);
            String email = inputEmail(ChoiceStatus.ADD);
            System.out.println("Add success!");
            SoDanhBa soDanhBa = new SoDanhBa(numberPhone, nhom, fullName, gioiTinh, address, birthDate, email);
            danhBaService.addDanhBa(soDanhBa);
            Menu.view();
        } while (!flag);
    }

    public static void editPhone() {
        try {
            showPhoneList();
            System.out.println("Enter number phone you need edit");
            System.out.print("==> ");
            String phone = scanner.nextLine().trim();
            if (danhBaService.exitsPhone(phone)) {
                String nhom = inputNhom(ChoiceStatus.ADD);
                String fullName = inputFullName(ChoiceStatus.ADD);
                String gioiTinh = inputGioiTinh(ChoiceStatus.ADD);
                String address = inputDiaChi(ChoiceStatus.ADD);
                String birthDate = inputBirthDate(ChoiceStatus.ADD);
                String email = inputEmail(ChoiceStatus.ADD);
                SoDanhBa soDanhBa = new SoDanhBa(phone, nhom, fullName, gioiTinh, address, birthDate, email);
                danhBaService.editDanhBa(soDanhBa);
                System.out.println("Edit success!");
            } else {
                System.out.println("Don't find phone.");
                editPhone();
            }
            Menu.view();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void removePhone() {
        try {
            boolean flag = true;

            String phone = inputPhoneNumber(ChoiceStatus.REMOVE);
            danhBaService.removeDanhBa(phone);
            System.out.println("Remove success");
            Menu.view();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static String inputPhoneNumber(ChoiceStatus status) {
        String phoneNumber;
        switch (status) {
            case REMOVE:
            case ADD:
                System.out.println("Enter your phone number: ");
                break;
            case EDIT:
                System.out.println("Input new phone number: ");
                break;
        }
        System.out.print("=> ");
        boolean flagInputName = true;
        do {
            phoneNumber = scanner.nextLine().trim();
            if (!ValidateUtils.isPhoneValid(phoneNumber)) {
                System.out.println("Number " + phoneNumber + " Not found! Please try again. (Phone Number 10 -> 11 number and start at 0)");
                System.out.println("Enter your phone number:(EX:0123456789)");
                System.out.print("==>  ");
                continue;
            }
            break;
        } while (flagInputName);
        return phoneNumber;
    }

    public static String inputNhom(ChoiceStatus status) {
        String nhom;
        switch (status) {
            case ADD:
                System.out.println("Enter 'nhom'  ");
                break;
            case EDIT:
                System.out.println("Input new 'nhom': ");
                break;
        }
        System.out.print("==>  ");
        nhom = scanner.nextLine();
        return nhom;
    }

    public static String inputFullName(ChoiceStatus status) {
        String fullName;
        switch (status) {
            case ADD:
                System.out.println("Enter name: ");
                break;
            case EDIT:
                System.out.println("Input new name: ");
                break;
        }
        System.out.print("=> ");
        fullName = scanner.nextLine().trim();
        return fullName;
    }

    public static String inputGioiTinh(ChoiceStatus status) {
        String gioiTinh;
        switch (status) {
            case ADD:
                System.out.println("Enter gender: ");
                break;
            case EDIT:
                System.out.println("Input new gender: ");
                break;
        }
        System.out.print("==>  ");
        gioiTinh = scanner.nextLine().trim();
        return gioiTinh;
    }

    public static String inputDiaChi(ChoiceStatus status) {
        String address;
        switch (status) {
            case ADD:
                System.out.println("Enter address: ");
                break;
            case EDIT:
                System.out.println("Input new address: ");
                break;
        }
        System.out.print("==>  ");
        address = scanner.nextLine().trim();
        return address;
    }

    public static String inputBirthDate(ChoiceStatus status) {
        String birthDate;
        switch (status) {
            case ADD:
                System.out.println("Enter birthday: ");
                break;
            case EDIT:
                System.out.println("Input new birthday: ");
                break;
        }
        System.out.print("==>  ");
        birthDate = scanner.nextLine().trim();
        return birthDate;
    }

    public static String inputEmail(ChoiceStatus status) {
        String email;
        switch (status) {
            case ADD:
                System.out.println("Enter Email: ");
                break;
            case EDIT:
                System.out.println("Input new Email: ");
                break;
        }
        System.out.print("=> ");
        boolean flagInputTitle = true;
        do {
            if (!ValidateUtils.isEmailValid(email = scanner.nextLine())) {
                System.out.println("Email " + email + "của bạn không đúng định dạng! Vui lòng kiểm tra và nhập lại ");
                System.out.println("Nhập email (VD: ngdquochuy241@gmail.com)");
                System.out.print("=> ");
                continue;
            }
            break;
        } while (flagInputTitle);
        return email;
    }

    public static void showPhoneList(){
        System.out.println("═══════════════════════════════════════════════════════════════════════════════     Danh  Bạ    ════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Phone Number", "Nhóm", "Tên", "Giới Tính", "Địa chỉ", "Ngày Sinh", "Email");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        for (SoDanhBa soDanhBa : danhBaService.findAll()){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                    soDanhBa.getPhoneNumber(),
                    soDanhBa.getNhomDanhBa(),
                    soDanhBa.getFullName(),
                    soDanhBa.getGioiTinh(),
                    soDanhBa.getDiaChi(),
                    soDanhBa.getNgaysinh(),
                    soDanhBa.getEmail());
        }
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }

    public static void findPhone(){
        System.out.println("Input phone number you need find");
        String phone = scanner.nextLine().trim();
        SoDanhBa soDanhBa = danhBaService.findPhone(phone);
        System.out.println("═══════════════════════════════════════════════════════════════════════════════     Danh  Bạ    ════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "Phone Number", "Nhóm", "Tên", "Giới Tính", "Địa chỉ", "Ngày Sinh", "Email");
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",
                soDanhBa.getPhoneNumber(),
                soDanhBa.getNhomDanhBa(),
                soDanhBa.getFullName(),
                soDanhBa.getGioiTinh(),
                soDanhBa.getDiaChi(),
                soDanhBa.getNgaysinh(),
                soDanhBa.getEmail());
        System.out.println("════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════");
    }


}
