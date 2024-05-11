package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="excursions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="excursion_id", nullable = false)
    private Long id;

    @Column(name="excursion_title")
    private String excursion_title;

    @Column(name="excursion_price")
    private BigDecimal excursion_price;

    @Column(name="image_url")
    private String image_URL;

    @CreationTimestamp
    @Column(name="create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name="last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name="vacation_id", insertable = false, updatable = false) // <-- corrected for cart_items table population (error: vacation_id cannot be null)
    private Vacation vacation;

    @ManyToMany(cascade = CascadeType.ALL) // <--- keep this here
    @JoinTable(
            name = "excursion_cartitem", // Name of the newly created table
            joinColumns = @JoinColumn(name = "excursion_id"), // Primary key column in the first join table
            inverseJoinColumns = @JoinColumn(name = "cart_item_id")) // Primary key column in the second join table

    private Set<CartItem> cartitems = new HashSet<>();

}
