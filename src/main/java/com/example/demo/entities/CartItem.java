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
    @Column(name="cart_item_id", nullable = false, updatable = false, insertable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable = false, updatable = false, insertable = false)
    private Vacation vacation;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false, updatable = false, insertable = false)
    private Cart cart;

    @CreationTimestamp
    @Column(name="create_date", updatable = false)
    private Date create_date;

    @UpdateTimestamp
    @Column(name="last_update", updatable = false)
    private Date last_update;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "cartitems")
    private Set<Excursion> excursions = new HashSet<>();

}