package com.winzfast.repository;

import com.winzfast.entity.Booking;
import com.winzfast.entity.Product;
import com.winzfast.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ADMIN
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    List<Booking> findByProduct(Product product);

}
