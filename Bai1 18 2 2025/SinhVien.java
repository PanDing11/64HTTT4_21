class SinhVien {
    private String firstName;
    private String lastName;
    private String birthdate;
    private String address;
    private String className;
    private DiemMonHoc diemMonHoc;

    public SinhVien(String firstName, String lastName, String birthdate, String address, String className) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.address = address;
        this.className = className;
        this.diemMonHoc = new DiemMonHoc();
    }

    // Getters và setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getAddress() {
        return address;
    }

    public String getClassName() {
        return className;
    }

    public DiemMonHoc getDiemMonHoc() {
        return diemMonHoc;
    }

    public char getRank() {
        double diemTrungBinh = diemMonHoc.tinhDiemTrungBinh();
        if (diemTrungBinh >= 8.5) return 'A';
        else if (diemTrungBinh >= 7.0) return 'B';
        else if (diemTrungBinh >= 5.5) return 'C';
        else if (diemTrungBinh >= 4.0) return 'D';
        else return 'F';
    }

    @Override
    public String toString() {
        return String.format("%-15s %-15s %-12s %-20s %-10s %.2f (%c)",
                firstName, lastName, birthdate, address, className,
                diemMonHoc.tinhDiemTrungBinh(), getRank());
    }
}
