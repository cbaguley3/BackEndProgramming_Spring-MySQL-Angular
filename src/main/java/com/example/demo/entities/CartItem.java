package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="cart_items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="vacation_id")
    private Vacation vacation;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "excursion_cartitem", // Name of the join table
            joinColumns = @JoinColumn(name = "excursion_id"), // Foreign key column in the join table
            inverseJoinColumns = @JoinColumn(name = "cart_item_id") // Foreign key column in the other entity's table
    )
    private Set<Excursion> excursions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @CreationTimestamp
    @Column(name="create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name="last_update")
    private Date last_update;

}