package pvh.hackathon.hotel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pvh.hackathon.hotel.config.HotelBookingClient;

@Slf4j
@Service
public class HotelBookingService {

    @Autowired
    HotelBookingClient hotelBookingClient;

    public String getHotelDetails(String city){
        return hotelBookingClient.getHotelDestId(city);
    }

}
