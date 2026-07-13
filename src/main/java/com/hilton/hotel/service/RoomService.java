package com.hilton.hotel.service;

import com.hilton.hotel.domain.Room;
import com.hilton.hotel.dto.request.CreateRoomRequest;
import com.hilton.hotel.exception.DuplicateResourceException;
import com.hilton.hotel.exception.ResourceNotFoundException;
import com.hilton.hotel.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomService {

    private final RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + id));
    }

    @Transactional
    public Room createRoom(CreateRoomRequest request) {
        if (roomRepository.existsByRoomNumber(request.getRoomNumber())) {
            throw new DuplicateResourceException("Room already exists with number: " + request.getRoomNumber());
        }

        Room room = Room.builder()
                .roomNumber(request.getRoomNumber())
                .type(request.getType())
                .pricePerNight(request.getPricePerNight())
                .capacity(request.getCapacity())
                .description(request.getDescription())
                .build();

        return roomRepository.save(room);
    }
}
