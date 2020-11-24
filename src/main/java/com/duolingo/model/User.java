package com.duolingo.model;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private short id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EXPERIENCE")
    private int experience;

    @Column(name = "MONEY")
    private int money;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LANGUAGE_ID", nullable = false)
    private Language language;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "USER_PRODUCT",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private Ranking ranking;

    public User() {}

    public User(short id, String name, String password, int experience, int money, String avatar, String email, Language language, List<Product> products, Ranking ranking) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.experience = experience;
        this.money = money;
        this.avatar = avatar;
        this.email = email;
        this.language = language;
        this.products = products;
        this.ranking = ranking;
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", experience=" + experience +
                ", money=" + money +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", language=" + language +
                ", products=" + products +
                ", ranking=" + ranking +
                '}';
    }
}
