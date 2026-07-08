package com.hilton.hotel.repository;

import com.hilton.hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long > {

}
