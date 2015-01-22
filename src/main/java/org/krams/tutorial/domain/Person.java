package org.krams.tutorial.domain;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {
 
 private static final long serialVersionUID = -5527566248002296042L;
  
 @Id
 @Column(name = "ID")
 @GeneratedValue
 private Integer id;

 @Column(name = "FIRST_NAME")

 private String firstName;
  
 @Column(name = "LAST_NAME")
 private String lastName;
  
 @Column(name = "MONEY")
 private Double money;

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public static long getSerialVersionUID() {
  return serialVersionUID;
 }

 public Integer getId() {
  return id;
 }

 public void setId(Integer id) {
  this.id = id;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 public Double getMoney() {
  return money;
 }

 public void setMoney(Double money) {
  this.money = money;
 }
}