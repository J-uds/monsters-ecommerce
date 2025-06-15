package com.monsters.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//genera automáticamente muchas cosas útiles en una clase:
//Los getters (métodos para leer atributos)
//Los setters (métodos para escribir atributos)
//Un método toString() para imprimir el objeto como texto
//Métodos equals() y hashCode() para comparar objetos
//Un constructor por defecto si no hay otros
@AllArgsConstructor
//Crea un constructor con todos los argumentos
@NoArgsConstructor
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
}
