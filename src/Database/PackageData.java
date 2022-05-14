package Database;
import Class.*;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private User user;
    private PhoneNumbers phoneNumbers;
    private String login;
    private int id;
    private ArrayList<PhoneNumbers> phoneNumbersArrayList;

    public PackageData() {
    }

    public PackageData(String operationType, String login, User user) {
        this.operationType = operationType;
        this.user = user;
        this.login = login;
    }

    public PackageData(String operationType, PhoneNumbers phoneNumbers, User user) {
        this.operationType = operationType;
        this.user = user;
        this.phoneNumbers = phoneNumbers;
    }

    public PackageData(String operationType, int id) {
        this.operationType = operationType;
        this.id = id;
    }

    public PackageData(String operationType, String login) {
        this.operationType = operationType;
        this.login = login;
    }

    public PackageData(User user) {
        this.user = user;
    }

    public PackageData(String operationType, User user) {
        this.operationType = operationType;
        this.user = user;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public PackageData(String operationType, PhoneNumbers phoneNumbers) {
        this.operationType = operationType;
        this.phoneNumbers = phoneNumbers;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PhoneNumbers getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(PhoneNumbers phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<PhoneNumbers> getPhoneNumbersArrayList() {
        return phoneNumbersArrayList;
    }

    public void setPhoneNumbersArrayList(ArrayList<PhoneNumbers> phoneNumbersArrayList) {
        this.phoneNumbersArrayList = phoneNumbersArrayList;
    }
}
