package dmitrii.model;

public class Car {
    private Integer id;
    private String brand;
    private Integer price;
    private User owner;

    public Car() {
    }

    public Car(Integer id, String brand, Integer price, User owner) {
        this.id = id;
        this.brand = brand;
        this.price = price;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
