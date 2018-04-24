package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Cart;
import it.sopra.stage.fullmoda.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
