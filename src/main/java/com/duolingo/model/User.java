package com.duolingo.model;

//import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LANGUAGE_ID", nullable = false)
    private Language language;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "SHOP_USER",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private Set<Product> products;

    @OneToOne(mappedBy = "user")
    private Ranking ranking;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Course> courses;


    public User() {}

    public User(short id, String name, String password, int experience, int money, String avatar, String email, Language language, Set<Product> products, Ranking ranking, Set<Course> courses) {
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
        this.courses = courses;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
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
