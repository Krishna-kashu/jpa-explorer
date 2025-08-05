package com.mywork.grocery_shop.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "grocery_shop_details")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "select a from ItemEntity a"),
        @NamedQuery(name = "findByCategory", query = "select a from ItemEntity a where a.category=:category"),
        @NamedQuery(name = "findByItemName", query = "select a from ItemEntity a where a.itemName=:name")
})
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    @Column(name = "expiryDate")
    private LocalDate expiryDate;

}
