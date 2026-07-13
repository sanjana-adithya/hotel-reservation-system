package com.hilton.hotel.dto.request;

import com.hilton.hotel.domain.RoomType;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateRoomRequest {

    @NotBlank(message = "Room Number is required")
    @Size(max = 10, message = "Room number cannot exceed 10 characters")
    private String roomNumber;

    @NotNull(message = "Room Type is required")
    private RoomType type;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "1.00", message = "Price must be at least 1.00")
    @Digits(integer = 8, fraction = 2, message = "Invalid price format")
    private BigDecimal pricePerNight;

    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;
}
