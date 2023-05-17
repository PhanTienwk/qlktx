
package model;


public class ThongTinHoaDonSV {
    private String thang;
    private String maSV;
    private String maPhong;
    private double tienPhi;
    private byte thanhToan;

    public ThongTinHoaDonSV(String thang, String maSV, String maPhong, double tienPhi, byte thanhToan) {
        this.thang = thang;
        this.maSV = maSV;
        this.maPhong = maPhong;
        this.tienPhi = tienPhi;
        this.thanhToan = thanhToan;
    }

    public ThongTinHoaDonSV() {
    }
    

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public double getTienPhi() {
        return tienPhi;
    }

    public void setTienPhi(double tienPhi) {
        this.tienPhi = tienPhi;
    }

    public byte getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(byte thanhToan) {
        this.thanhToan = thanhToan;
    }
    
    
    
    
    
}
