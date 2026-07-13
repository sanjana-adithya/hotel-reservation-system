package com.hilton.hotel.controller;


import com.hilton.hotel.domain.Room;
import com.hilton.hotel.dto.request.CreateRoomRequest;
import com.hilton.hotel.dto.response.RoomResponse;
import com.hilton.hotel.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRooms() {
        List<RoomResponse> rooms = roomService.getAllRooms()
                .stream().map(RoomResponse::from).toList();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{room_id}")
    public ResponseEntity<RoomResponse> getRoomById(@PathVariable("room_id") Long roomId) {
        return ResponseEntity.ok(RoomResponse.from(roomService.getRoomById(roomId)));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RoomResponse> createRoom(@Valid @RequestBody CreateRoomRequest request) {
        Room room = roomService.createRoom(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(RoomResponse.from(room));
    }
}
