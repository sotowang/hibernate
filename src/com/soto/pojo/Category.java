package com.soto.pojo;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category_")
public class Category {
    int id;
    String name;
    Set<Product> products;

//    fetch=FetchType.EAGER 表示不进行延迟加载(FetchType.LAZY表示要进行延迟加载)
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="cid")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
//    默认映射
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}