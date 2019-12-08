package Homework3.DomainModel.product;

import java.util.Objects;

public class Product {

    private int id;
    private double weight_to_kg;
    private double cost;
    private double width;
    private double height;
    private boolean insurance;
    private Category category;
    private ClassOfDelivery classOfDelivery;

    public Product(int id, double weight_to_kg, double cost, double width, double height, boolean insurance, Category category, ClassOfDelivery classOfDelivery) {
        this.id = id;
        this.weight_to_kg = weight_to_kg;
        this.cost = cost;
        this.width = width;
        this.height = height;
        this.insurance = insurance;
        this.category = category;
        this.classOfDelivery = classOfDelivery;
    }

    public double getWeight_to_kg() {
        return weight_to_kg;
    }

    public void setWeight_to_kg(double weight_to_kg) {
        this.weight_to_kg = weight_to_kg;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassOfDelivery getClassOfDelivery() {
        return classOfDelivery;
    }

    public void setClassOfDelivery(ClassOfDelivery classOfDelivery) {
        this.classOfDelivery = classOfDelivery;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.weight_to_kg, weight_to_kg) == 0 &&
                Double.compare(product.cost, cost) == 0 &&
                Double.compare(product.width, width) == 0 &&
                Double.compare(product.height, height) == 0 &&
                insurance == product.insurance &&
                category == product.category &&
                classOfDelivery == product.classOfDelivery;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, weight_to_kg, cost, width, height, insurance, category, classOfDelivery);
    }
}
