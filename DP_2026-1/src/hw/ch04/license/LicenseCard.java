package hw.ch04.license;

import hw.ch04.framework.Product;

public class LicenseCard extends Product {
    private String holder; // 운전자명
    private int licenseNumber; // 면허 번호
    private String issuedDate; // 발급 날짜
    private String expiryDate; // 만료 날짜

    LicenseCard(String holder, int licenseNumber, String issueDate, String expiryDate) {
        System.out.println(holder + "의 운전면허증을 " + licenseNumber + "번으로 만듭니다.");
        this.holder = holder;
        this.licenseNumber = licenseNumber;
        this.issuedDate = issueDate;
        this.expiryDate = expiryDate;
    }

    @Override
    public void use() {
        System.out.println(this + "을 사용합니다.");
    }

    @Override
    public String toString() {
        return "[LicenseCard:" + holder + "(" + licenseNumber + ")] - 유효기간: " + issuedDate + " ~ " + expiryDate;
    }
    public String getHolder() {
        return holder;
    }
    public int getLicenseNumber() {
        return licenseNumber;
    }
    public String getIssueDate() {
        return issuedDate;
    }
    public String getExpiryDate() {
        return expiryDate;
    }



}
