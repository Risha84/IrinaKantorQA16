package com.tran16;

public class ContactData {
    private  String firstname;
    private  String lastname;
    private  String address;
    private String nickname;
    private String company;
    private String email;

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }
    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }
    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getNickname() {
        return nickname;
    }
    public String getCompany() {
        return company;
    }
    public String getEmail() {
        return email;
    }


}
