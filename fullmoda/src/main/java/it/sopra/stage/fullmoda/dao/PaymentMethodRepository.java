package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, String> {

}
