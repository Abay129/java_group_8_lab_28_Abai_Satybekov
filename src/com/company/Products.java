package com.company;

import java.util.List;

public class Products {
    private int weight;
    private TypeProduct typeProduct;
    private Quality quality;
    private Integer price;

    public Products(Integer weight, TypeProduct typeProduct, Quality quality){
        this.weight = weight;
        this.typeProduct = typeProduct;
        this.quality = quality;
        price = getPrice();
    }

    @Override
    public String toString() {
        return
                "вес" + weight +
                "Продукт" + typeProduct +
                "качество" + quality +
                "цена" + price;
    }

    public Integer getPrice() {
        if (typeProduct.equals(TypeProduct.MEAT)){
            price = 40;
        }else if (typeProduct.equals(TypeProduct.DRIEDFRUITS)){
            price = 10;
        }else if (typeProduct.equals(TypeProduct.GRAIN)){
            price = 5;
        }else if (typeProduct.equals(TypeProduct.FLOUR)){
            price = 15;
        }else if (typeProduct.equals(TypeProduct.FABRICS)){
            price = 30;
        }else if (typeProduct.equals(TypeProduct.PAINT)){
            price = 70;
        }
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }
}
