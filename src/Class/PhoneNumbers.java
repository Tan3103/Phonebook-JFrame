package Class;

import java.io.Serializable;

public class PhoneNumbers implements Serializable, Info {
    private Integer id;
    private String name;
    private String surname;
    private String type;
    private String phoneNumber;

    public PhoneNumbers() {
    }

    public PhoneNumbers(Integer id, String name, String surname, String type, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String info() {
        return id + ") Name:" + name + ", Surname:" + surname + ", PhoneNumber:" + phoneNumber + " (" + type + ")";
    }
}
