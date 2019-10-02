package edu.mum.cs.domain;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class Calculator implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6257027669788890853L;
    
    String add1;
    String add2;
    String mult1;
    String mult2;
    String sum;
    String product;
    public void calSum() {
        this.sum = String.valueOf(Double.valueOf(this.add1) + Double.valueOf(this.add2));
    }
    public void calProduct() {
        this.product = String.valueOf(Double.valueOf(this.mult1) * Double.valueOf(this.mult2));
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getMult1() {
        return mult1;
    }

    public void setMult1(String mult1) {
        this.mult1 = mult1;
    }

    public String getMult2() {
        return mult2;
    }

    public void setMult2(String mult2) {
        this.mult2 = mult2;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}