package dmitrii.model;

import java.util.List;

public class User {
    private Integer id;
    private String firstName;
    private String adress;
    private List<Car> cars;

    public User(String firstName, String adress) {
        this.firstName = firstName;
        this.adress = adress;
    }

    public User(Integer id, String firstName, String lastName, List<Car> cars) {
        this.id = id;
        this.firstName = firstName;
        this.adress = lastName;
        this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
