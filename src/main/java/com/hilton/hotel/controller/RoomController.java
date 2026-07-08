package com.hilton.hotel.controller;

import com.hilton.hotel.domain.Room;
import com.hilton.hotel.domain.RoomStatus;
import com.hilton.hotel.domain.RoomType;
import com.hilton.hotel.dto.response.RoomResponse;
import com.hilton.hotel.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomResponse>> getAllRooms() {

        List<RoomResponse> rooms = roomService.getAllRooms()
                .stream().map(room -> RoomResponse.from(room)).toList();

        return ResponseEntity.ok(rooms);
    }
}
