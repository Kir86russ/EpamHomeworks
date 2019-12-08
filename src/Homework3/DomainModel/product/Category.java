package Homework3.DomainModel.product;

public enum Category {

    A("Very fragile"),
    B("Medium fragile"),
    C("Not fragile");

    private String description;

    Category(String description) {
        this.description = description;
    }
}
