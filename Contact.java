package com.example.address_book_application;

public class Contact {



    private String name;
    private String phone;
    private String email;
    private String address;
    private String facebook;
    private String city;
    private String state;
    private String zip;
    private String contacttype;



    public Contact( String name, String phone, String email, String address, String facebook, String city, String state, String zip, String contacttype){


        this.name=name;
        this.phone=phone;
        this.email=email;
        this.address=address;
        this.facebook=facebook;
        this.city=city;
        this.state=state;
        this.zip=zip;
        this.contacttype=contacttype;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getContacttype() {
        return contacttype;
    }

    public void setContacttype(String contacttype) {
        this.contacttype = contacttype;
    }
}

