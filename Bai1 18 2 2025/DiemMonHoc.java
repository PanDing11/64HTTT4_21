class DiemMonHoc {
    // Các biến lưu điểm của 5 môn học
    private double lapTrinhHuongDoiTuong;
    private double quanLyDuAn;
    private double hocMay;
    private double coSoDuLieu;
    private double lapTrinhUngDungTBDD;

    // Constructor khởi tạo mặc định điểm của các môn là 0
    public DiemMonHoc() {
        this.lapTrinhHuongDoiTuong = 0;
        this.quanLyDuAn = 0;
        this.hocMay = 0;
        this.coSoDuLieu = 0;
        this.lapTrinhUngDungTBDD = 0;
    }

    // Các phương thức "setter" để gán điểm cho từng môn học
    public void setLapTrinhHuongDoiTuong(double diem) { this.lapTrinhHuongDoiTuong = diem; }
    public void setQuanLyDuAn(double diem) { this.quanLyDuAn = diem; }
    public void setHocMay(double diem) { this.hocMay = diem; }
    public void setCoSoDuLieu(double diem) { this.coSoDuLieu = diem; }
    public void setLapTrinhUngDungTBDD(double diem) { this.lapTrinhUngDungTBDD = diem; }

    // Các phương thức "getter" để lấy điểm từng môn
    public double getLapTrinhHuongDoiTuong() { return lapTrinhHuongDoiTuong; }
    public double getQuanLyDuAn() { return quanLyDuAn; }
    public double getHocMay() { return hocMay; }
    public double getCoSoDuLieu() { return coSoDuLieu; }
    public double getLapTrinhUngDungTBDD() { return lapTrinhUngDungTBDD; }

    // Tính điểm trung bình của sinh viên
    public double tinhDiemTrungBinh() {
        return (lapTrinhHuongDoiTuong + quanLyDuAn + hocMay + coSoDuLieu + lapTrinhUngDungTBDD) / 5;
    }
}
