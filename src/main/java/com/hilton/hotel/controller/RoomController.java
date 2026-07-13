package com.hilton.hotel.controller;


import com.hilton.hotel.dto.response.RoomResponse;
import com.hilton.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
