package org.shumskih.spring.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "manufacturers")
public class Manufacturer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.PostgresUUIDType")
    private UUID id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "manufacturer")
    private Set<Product> products = new HashSet<>();

    public Manufacturer() {

    }

    public Manufacturer(UUID id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ID: " + id + '\n' +
                "Name: " + name + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return products != null ? products.equals(that.products) : that.products == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (products != null ? products.hashCode() : 0);
        return result;
    }
}
