package model;

import java.util.Objects;

public class Goods {

    private Integer id;
    private String nameProduct;
    private String unitProduct;
    private String description;

    public Goods() {
    }

    public Goods(Integer id, String nameProduct, String unitProduct, String description) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.unitProduct = unitProduct;
        this.description = description;
    }

    public Goods(String nameProduct, String unitProduct, String description) {
        this.nameProduct = nameProduct;
        this.unitProduct = unitProduct;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getUnitProduct() {
        return unitProduct;
    }

    public void setUnitProduct(String unitProduct) {
        this.unitProduct = unitProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(id, goods.id) &&
                Objects.equals(nameProduct, goods.nameProduct) &&
                Objects.equals(unitProduct, goods.unitProduct) &&
                Objects.equals(description, goods.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, unitProduct, description);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", unitProduct='" + unitProduct + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
