package com.cust.Entity;


public class User {

  private int id;
  private String nikename;
  private int gender;
  private String province;
  private String city;
  private String country;
  private String openid;


  public long getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getNikename() {
    return nikename;
  }

  public void setNikename(String nikename) {
    this.nikename = nikename;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }


  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public String getOpenid() {
    return openid;
  }

  public void setOpenid(String openid) {
    this.openid = openid;
  }

}
