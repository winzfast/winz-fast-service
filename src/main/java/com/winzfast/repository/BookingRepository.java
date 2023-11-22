package com.winzfast.repository;

import com.winzfast.model.Booking;
import com.winzfast.model.Product;
import com.winzfast.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ADMIN
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    List<Booking> findByProduct(Product product);

}
