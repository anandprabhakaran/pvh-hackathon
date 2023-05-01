package pvh.hackathon.hotel.config;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class HotelBookingClient {

    @SneakyThrows
    public String getHotelDestId(String city) {

        String bookingUrl = "https://booking-com.p.rapidapi.com/v1/hotels/locations?name=%s&locale=en-gb";

        var url = String.format(bookingUrl,city);


        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("X-RapidAPI-Key", "b93d25d914msh63d0a021b6c8d11p15b007jsnb875a9dcbed4")
                .header("X-RapidAPI-Host", "booking-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        JSONArray jsonArray = new JSONArray(response.body());

        JSONObject firstObj = jsonArray.getJSONObject(0);
        String destId = firstObj.getString("dest_id");

        System.out.println(destId);

        System.out.println(getHotels(destId));

//        List<Integer> destIds = new ArrayList<>();
//
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            String destIdStr = jsonObject.getString("dest_id");
//            int destId = Integer.parseInt(destIdStr);
//            destIds.add(destId);
//        }



        return getHotels(destId);

    }

    @SneakyThrows
    public String getHotels(String destId){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://booking-com.p.rapidapi.com/v1/hotels/search?checkin_date=2023-09-27&dest_type=city&units=metric&checkout_date=2023-09-28&adults_number=2&order_by=popularity&dest_id="+destId+"&filter_by_currency=AED&locale=en-gb&room_number=1&children_number=2&children_ages=5%2C0&categories_filter_ids=class%3A%3A2%2Cclass%3A%3A4%2Cfree_cancellation%3A%3A1&page_number=0&include_adjacency=true"))
                .header("X-RapidAPI-Key", "b93d25d914msh63d0a021b6c8d11p15b007jsnb875a9dcbed4")
                .header("X-RapidAPI-Host", "booking-com.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }

}
