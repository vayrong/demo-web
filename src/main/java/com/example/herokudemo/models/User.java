package com.example.herokudemo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Data
//@Getter
//@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    private String address;
    private String password;
    private String phone;
    private String gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    private Set<Order> orders;
//    @ManyToOne
//    @JoinColumn(name="order_id", nullable=false)
//    private Order order;
//    @ManyToMany(cascade = { CascadeType.ALL })
//    @JoinTable(
//            name = "user_book",
//            joinColumns = { @JoinColumn(name = "user_id") },
//            inverseJoinColumns = { @JoinColumn(name = "book_id") }
//    )
//    Set<Book> books = new HashSet<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_subject",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "subject_id") }
    )
    Set<Subject> subjectSet = new HashSet<>();

}
