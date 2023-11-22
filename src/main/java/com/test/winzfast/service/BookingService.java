package com.test.winzfast.service;


import com.test.winzfast.dto.BookingDTO;
import com.test.winzfast.model.Product;
import com.test.winzfast.model.User;

import java.util.List;

/**
 * @author ADMIN
 */
public interface BookingService {

    void createBooking(BookingDTO bookingDTO, User user, Product product);
    List<BookingDTO> getOwnBookings(User user);
    List<BookingDTO> getProductBookings(Product product);
}
