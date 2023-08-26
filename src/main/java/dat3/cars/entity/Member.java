package dat3.cars.entity;

import dat3.security.entity.UserWithRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//------------------------
@Entity
@Table(name="Member")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE")
public class Member extends UserWithRoles {

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
 private boolean approved;

 @Column(name = "ranking")
 private int ranking;

 @Column(name = "created")
 private LocalDateTime created;

 @Column(name = "last_edited")
 private LocalDateTime lastEdited;

 @OneToMany(mappedBy = "member")
 private List<Reservation> reservations;

 public void addReservation(Reservation reservation){
  if(reservation != null){
   reservations = new ArrayList<>();
  }
  reservations.add(reservation);
 }
 public Member(String user, String email, String password, String first_name, String last_name, String street, String city, String zip) {
  super(user,password,email);
  this.first_name = first_name;
  this.last_name = last_name;
  this.street = street;
  this.city = city;
  this.zip = zip;
 }

}













