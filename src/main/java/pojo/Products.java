package pojo;

public class Products {
    private String productName;
    private double dollarPrice;
    private double euroPrice;
    private double poundSterlingPrice;

    public Products(String productName, double dollarPrice, double euroPrice, double poundSterlingPrice) {
        this.productName = productName;
        this.dollarPrice = dollarPrice;
        this.euroPrice = euroPrice;
        this.poundSterlingPrice = poundSterlingPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getDollarPrice() {
        return dollarPrice;
    }

    public void setDollarPrice(double dollarPrice) {
        this.dollarPrice = dollarPrice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        this.euroPrice = euroPrice;
    }

    public double getPoundSterlingPrice() {
        return poundSterlingPrice;
    }

    public void setPoundSterlingPrice(double poundSterlingPrice) {
        this.poundSterlingPrice = poundSterlingPrice;
    }





}
