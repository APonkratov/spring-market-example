package com.geekbrains.market.repositories;

import com.geekbrains.market.entities.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
}
