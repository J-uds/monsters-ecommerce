package com.monsters.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

//@Data
//genera automáticamente muchas cosas útiles en una clase:
//Los getters (métodos para leer atributos)
//Los setters (métodos para escribir atributos)
//Un método toString() para imprimir el objeto como texto
//Métodos equals() y hashCode() para comparar objetos
//Un constructor por defecto si no hay otros
//@AllArgsConstructor
//Crea un constructor con todos los argumentos
//@NoArgsConstructor
//Crea un constructor vacío (sin parámetros)
@Entity
@Table(name = "products")
public class Product {

    @Id
    //hace clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //genera números enteros consecutivos
    private Long id;
    private String name;
    private double price;
    @Column(name = "image_Url")
    //escribir el nombre en la nomenclatura que se utiliza para SQL
    private String imageUrl;
    private double rating;
    @Column(name = "review_count")
    private int reviewCount;
    private boolean featured;

    @OneToMany(targetEntity = Review.class, fetch = FetchType.LAZY, mappedBy = "product")
    //LAZY trae la lista solo cuando yo se la solicite
    //mappedBy se mapea con el atributo product de la clase review, es decir ese atributo será la clave foránea
    private List<Review> reviews;

    public Product(@NotBlank(message = "Name is required") String name, @NotBlank(message = "Price is required") double price, String s, double rating, @NotBlank(message = "Availability is required") boolean featured) {
    }

    public Product(String name, double price, String imageUrl, double rating, int reviewCount, boolean featured, List<Review> reviews) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.featured = featured;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
