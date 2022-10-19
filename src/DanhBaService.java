package src;

import java.util.ArrayList;
import java.util.List;

public class DanhBaService {
    public final static String Path = "D:\\quanlydanhba\\data\\danhba.csv";
    private static DanhBaService instance;

    public static DanhBaService getInstance() {
        if (instance == null) {
            instance = new DanhBaService();
        }
        return instance;
    }

    public List<SoDanhBa> findAll() {
        List<SoDanhBa> danhBa = new ArrayList<>();
        List<String> records = CSVUntils.read(Path);
        for (String record : records) {
            danhBa.add(SoDanhBa.parseSoDanhBa(record));
        }
        return danhBa;
    }

    public void addDanhBa(SoDanhBa soDanhBa){
        List<SoDanhBa> danhBa = findAll();
        danhBa.add(soDanhBa);
        CSVUntils.write(Path,danhBa);
    }

    public void editDanhBa(SoDanhBa newDanhBa) {
        List<SoDanhBa> danhBa = findAll();
        for (SoDanhBa oldSoDanhBa : danhBa) {
            if (oldSoDanhBa.getPhoneNumber().equals(newDanhBa.getPhoneNumber())) {
                String nhom = newDanhBa.getNhomDanhBa();
                if (nhom != null && !nhom.isEmpty()) {
                    oldSoDanhBa.setNhomDanhBa(nhom);
                }
                String fullName = newDanhBa.getFullName();
                if (fullName != null && !fullName.isEmpty()) {
                    oldSoDanhBa.setFullName(fullName);
                }
                String gioiTinh = newDanhBa.getGioiTinh();
                if (gioiTinh != null && !gioiTinh.isEmpty()) {
                    oldSoDanhBa.setGioiTinh(gioiTinh);
                }
                String address = newDanhBa.getDiaChi();
                if (address != null && !address.isEmpty()) {
                    oldSoDanhBa.setDiaChi(address);
                }
                String birthDate = newDanhBa.getNgaysinh();
                if (birthDate != null && !birthDate.isEmpty()) {
                    oldSoDanhBa.setNgaysinh(birthDate);
                }
                String email = newDanhBa.getEmail();
                if (email != null && !email.isEmpty()) {
                    oldSoDanhBa.setEmail(email);
                }
                CSVUntils.write(Path, danhBa);
            }
        }
    }

    public void removeDanhBa(String phoneNumber){
        List<SoDanhBa> danhBa = findAll();
        danhBa.removeIf(number -> number.getPhoneNumber().equals(phoneNumber));
        CSVUntils.write(Path,danhBa);
    }

    public SoDanhBa findPhone (String phoneNumber){
        List<SoDanhBa> danhBa = findAll();
        for (SoDanhBa soDanhBa : danhBa){
            if (soDanhBa.getPhoneNumber().equals(phoneNumber)){
                return soDanhBa;
            }
        }
        return null;
    }

    public boolean exitsPhone(String numberPhone) {
        return findPhone(numberPhone) != null;
    }
}