package com.mywork.food_delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "food_order")
@NamedQueries({
        @NamedQuery(name = "findByRestaurant", query = "select f from FoodOrderEntity f where f.restaurantName=:rest"),
        @NamedQuery(name = "findByItem", query = "select f from FoodOrderEntity f where f.foodItem =:item"),
        @NamedQuery(name = "findByItemAndRestaurant", query = "select f from FoodOrderEntity f where f.foodItem=:item and f.restaurantName=:rest"),
        @NamedQuery(name = "findByPriceGreaterThan", query = "select f from FoodOrderEntity f where f.price > :amount"),
        @NamedQuery(name = "UpdateFoodItemByRestaurantName", query = "update FoodOrderEntity f set f.foodItem =:item where f.restaurantName=:name and f.id=:id"),
        @NamedQuery(name = "UpdatePriceByFoodItem", query = "update FoodOrderEntity f set  f.price=:price where f.foodItem=:item and f.id=:id"),
        @NamedQuery(name = "updateQuantityByFoodItem", query = "update FoodOrderEntity f set f.quantity=:quantity where f.foodItem=:item and f.id=:id")
})
public class FoodOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @Column(name = "restaurant_name")
    @NotBlank
    @Size(min = 3, max = 30, message = "restaurantName should between 3 to 30 characters")
    private String restaurantName;

    @Column(name = "food_item")
    @NotBlank
    @Size(min = 2, max = 50, message = "foodItem should between 2 to 50")
    private String foodItem;

    @Column(name = "quantity")
    @Min(value = 1, message = "min quantity is 3")
    @Max(value = 20, message = "max quantity is 20")
    private Integer quantity;

    @Column(name = "price")
    @Min(value = 10, message = "min price is 10")
    private Double price;

    @Column(name = "delivery_address")
    @NotBlank
    @Size(min = 5, max = 100, message = "deliveryAddress should between 5 to 100 characters")
    private String deliveryAddress;

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @PrePersist
    public void prePersist() {
        this.orderTime = LocalDateTime.now();
    }
}