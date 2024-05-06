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
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_first_name")
    @JsonProperty("firstName")
    private String firstName;

    @Column(name = "customer_last_name")
    @JsonProperty("lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    @JsonProperty("postal_code")
    private String postal_code;

    @Column(name = "phone")
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {
            if (cart != null) {
                if(carts == null) {
                    carts = new HashSet<>();
                }
                carts.add(cart);
                cart.setCustomer(this);
            }
    }
}