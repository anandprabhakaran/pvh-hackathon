package pvh.hackathon.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
@Data
public class HotelModel {
    private String city;
    private String checkedInDate;
    private String checkedOutDate;
    private int adultsNumber;
    private String currency;
    private int numberORooms;
    private int childrenNumber;
    private String childrenAge;
}
