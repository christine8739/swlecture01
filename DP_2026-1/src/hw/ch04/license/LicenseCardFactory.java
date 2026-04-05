package hw.ch04.license;

import hw.ch04.framework.Factory;
import hw.ch04.framework.Product;

public class LicenseCardFactory extends Factory {
    private int licenseCounter = 100; // 100부터 시작
    private String baseDate;

    public LicenseCardFactory(String baseDate) {
        this.baseDate = baseDate;
    }

    @Override
    protected Product createProduct(String holder){
        return new LicenseCard(holder,licenseCounter++,baseDate,calcExpiryDate(baseDate));
    }

    @Override
    protected void registerProduct(Product product){
        System.out.println(product +"을 등록했습니다." );
    }

    // 발급일 기준 5년 후 만료일 계산
    private String calcExpiryDate(String base){
        int year = Integer.parseInt(base.substring(0, 4)) + 5;
        return year + base.substring(4);
    }
}