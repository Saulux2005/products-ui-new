package lt.bit.products.ui.service.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfileEntity {

  @Id
  private Integer userId;
  private String name;
  private String address;
  private String email;
  private String phone;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer id) {
    this.userId = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}