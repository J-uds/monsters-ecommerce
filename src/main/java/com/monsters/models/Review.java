package com.monsters.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    private double rating;
    private String body;

    @ManyToOne(targetEntity = Product.class)
    //@JoinColumn(name = "id_product")
    //para cambiar el nombre de la columna añadida, por defecto será product_id
    private Product product;
}
