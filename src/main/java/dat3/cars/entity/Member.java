package dat3.cars.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
//------------------------
@Entity
@Table(name="Member")

public class Member {
 @Id
 @Column(name = "username")
String user;

 @Column(name = "email")
 private String email;

 @Column(name = "password")
 private String password;

 @Column(name = "first_name")
 private String first_name;

 @Column(name = "last_name")
 private String last_name;

 @Column(name = "street")
 private String street;

 @Column(name = "city")
 private String city;

 @Column(name = "zip")
 private String zip;

 @Column(name = "approved")
 private String approved;

 @Column(name = "ranking")
 private String ranking;

 @Column(name = "created")
 private LocalDateTime created;

 @Column(name = "last_edited")
 private LocalDateTime lastEdited;

 public Member(String user, String email, String password, String first_name, String last_name, String street, String city, String zip) {
  this.user = user;
  this.email = email;
  this.password = password;
  this.first_name = first_name;
  this.last_name = last_name;
  this.street = street;
  this.city = city;
  this.zip = zip;
 }

}













