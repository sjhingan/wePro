package com.ip.wePro.testing;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Pages> pages;

    public Set<Pages> getPages() {
        return pages;
    }

    public void setPages(Set<Pages> pages) {
        this.pages = pages;
    }

    public Book(){

    }

    public Book(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
