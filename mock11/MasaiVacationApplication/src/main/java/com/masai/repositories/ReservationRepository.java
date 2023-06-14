package com.masai.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {



	List<Reservation> findByUserId(Long userId);
	
	

}
