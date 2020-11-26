package com.geekbrains.market.repositories;

import com.geekbrains.market.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
