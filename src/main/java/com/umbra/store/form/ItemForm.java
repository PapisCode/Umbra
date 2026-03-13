package com.umbra.store.form;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ItemForm {

    @NotBlank(message = "Item name is required.")
    private String name;

    @NotBlank(message = "SKU is required.")
    private String sku;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0.")
    private BigDecimal price;

    @Size(max = 500, message = "Description cannot exceed 500 characters.")
    private String description;

    @NotNull(message = "Please select a brand.")
    private Long brandId;

    @NotNull(message = "Please select a category.")
    private Long categoryId;

    public ItemForm() {
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Long getBrandId() {
        return brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}


