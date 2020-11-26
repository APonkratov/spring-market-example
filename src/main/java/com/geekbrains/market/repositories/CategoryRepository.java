package com.geekbrains.market.repositories;

import com.geekbrains.market.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
