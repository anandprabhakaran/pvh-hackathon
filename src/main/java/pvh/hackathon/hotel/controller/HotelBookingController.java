package pvh.hackathon.hotel.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pvh.hackathon.hotel.model.HotelModel;
import pvh.hackathon.hotel.service.HotelBookingService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/hotels")
public class HotelBookingController {

    @Autowired
    HotelBookingService hotelBookingService;

    @SneakyThrows
    @GetMapping("/city/{city}")
    public ResponseEntity<ObjectNode> getHotelDetails(String city)  {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(hotelBookingService.getHotelDetails(city));
        ObjectNode objectNode = mapper.createObjectNode().set("data", json);

        return ResponseEntity.ok(objectNode);
    }
}

// 1746443
