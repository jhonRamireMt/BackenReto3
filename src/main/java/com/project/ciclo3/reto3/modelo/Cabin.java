package com.project.ciclo3.reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="cabin")
public class Cabin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String brand;

    private Integer rooms;

    @Column(length = 250)
    private String description;

   @ManyToOne
   @JoinColumn(name="categoryId")
   @JsonIgnoreProperties("cabins")
   private Category category;

   @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
   @JsonIgnoreProperties({"cabin","client"})
   private List<Message> messages;

   @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "cabin")
   @JsonIgnoreProperties({"cabin","messages"})
   private List<Reservation> reservations;

}
