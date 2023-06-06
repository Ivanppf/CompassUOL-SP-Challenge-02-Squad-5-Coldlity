package br.com.compassuol.pb.challenge.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity(name = "Products")
public class ProductEntity {
    @Id
    @Column(name = "productid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;

    @Column(nullable = false, length = 50)
    @NotEmpty(message = "'name' não pode ser nulo ou vazio")
    @Size(min = 3, message = "'name' deve ter no mínimo 3 caracteres")
    private String name;

    @Column(nullable = false)
    @NotEmpty(message = "'price' não pode ser nulo ou vazio")
    @Positive(message = "'price' deve ser um valor positivo")
    private Float price;

    @Column(nullable = false, length = 100)
    @NotEmpty(message = "'description' não pode ser nulo ou vazio")
    @Size(min = 3, message = "O campo 'description' deve ter no mínimo 3 caracteres")
    private String description;

    public ProductEntity() {

    }

    public ProductEntity(String name, Float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return productId;
    }

    public void setId(int id) {
        this.productId = id;
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
        return "ProductEntity{" +
                "productid=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
