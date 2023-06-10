package br.com.compassuol.pb.challenge.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "'name' não pode ser nulo ou vazio")
    @Size(min = 3, message = "'name' deve ter no mínimo 3 caracteres")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "'price' não pode ser nulo ou vazio")
    @Positive(message = "'price' deve ser um valor positivo")
    private float price;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "'description' não pode ser nulo ou vazio")
    @Size(min = 3, message = "O campo 'description' deve ter no mínimo 3 caracteres")
    private String description;

    public Product() {
    }

    public Product(String name, Float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
