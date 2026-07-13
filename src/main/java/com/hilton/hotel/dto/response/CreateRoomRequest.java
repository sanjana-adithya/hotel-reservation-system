package com.hilton.hotel.dto.response;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRoomRequest {

    @NotBlank(message = "Room Number is required")
    @Size(max = 10, message = "Room number cannot exceed 10 character")
    private String roomNumber;

    @NotNull(message = "Room Type is required")
    @DecimalMin(value = "1.00", message = "Price must be at least 1.00")
    @Digits(integer = 8, fraction = 2, message = "Capacity cannot exceed 5")
    private Integer capacity;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;
}
