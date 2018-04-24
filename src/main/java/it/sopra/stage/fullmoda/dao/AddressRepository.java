package it.sopra.stage.fullmoda.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.sopra.stage.fullmoda.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{

}
