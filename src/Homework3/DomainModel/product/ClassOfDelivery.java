package Homework3.DomainModel.product;

public enum ClassOfDelivery {
    A("1 class"),
    B("2 class"),
    C("default");

    private String description;

    ClassOfDelivery(String description) {
        this.description = description;
    }
}
