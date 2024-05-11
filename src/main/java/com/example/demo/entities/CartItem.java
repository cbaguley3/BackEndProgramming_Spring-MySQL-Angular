package com.example.demo.entities;

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
    @Column(name="cart_item_id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false, updatable = false) // <--- fixed for cart_items table population
    private Vacation vacation;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @CreationTimestamp
    @Column(name="create_date", updatable = false)
    private Date create_date;

    @UpdateTimestamp
    @Column(name="last_update", updatable = false)
    private Date last_update;

    @ManyToMany
    @JoinTable(
            name = "excursion_cartitem", // Name of the newly created table
            joinColumns = @JoinColumn(name = "cart_item_id"), // Primary key column in the first join table
            inverseJoinColumns = @JoinColumn(name = "excursion_id")) // Primary key column in the second join table//, cascade = CascadeType.ALL) <-- causes warning (vacation property modified but not updated because immutable....
    private Set<Excursion> excursions = new HashSet<>();

}