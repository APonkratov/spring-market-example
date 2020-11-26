package com.geekbrains.market.repositories;

import com.geekbrains.market.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
