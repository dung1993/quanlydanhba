package src;

import java.util.List;
import java.util.Objects;

public class SoDanhBa {
    private String phoneNumber;
    private String nhomDanhBa;
    private String fullName;
    private String gioiTinh;
    private String diachi;
    private String ngaysinh;
    private String Email;

    public List<SoDanhBa> soDanhBa;

    public SoDanhBa() {
    }

    public SoDanhBa(String phoneNumber, String nhomDanhBa, String fullName, String gioiTinh, String diachi, String ngaysinh, String email) {
        this.phoneNumber = phoneNumber;
        this.nhomDanhBa = nhomDanhBa;
        this.fullName = fullName;
        this.gioiTinh = gioiTinh;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.Email = email;
    }

    public static SoDanhBa parseSoDanhBa(String MySoDanhBa){
        String[] array = MySoDanhBa.split(",");
        SoDanhBa soDanhBa = new SoDanhBa();
        soDanhBa.setPhoneNumber(array[0]);
        soDanhBa.setNhomDanhBa(array[1]);
        soDanhBa.setFullName(array[2]);
        soDanhBa.setGioiTinh(array[3]);
        soDanhBa.setDiaChi(array[4]);
        soDanhBa.setNgaysinh(array[5]);
        soDanhBa.setEmail(array[6]);
        return soDanhBa;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNhomDanhBa() {
        return nhomDanhBa;
    }

    public void setNhomDanhBa(String nhomDanhBa) {
        this.nhomDanhBa = nhomDanhBa;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diachi;
    }

    public void setDiaChi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                phoneNumber,
                nhomDanhBa,
                fullName,
                gioiTinh,
                diachi,
                ngaysinh,
                Email);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SoDanhBa soDanhBa = (SoDanhBa) obj;
        return phoneNumber.equals(soDanhBa.phoneNumber);
    }

    public int hashCode() {
        return Objects.hashCode(phoneNumber);
    }
}
