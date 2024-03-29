package shivaot.booking;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
@Api(name = "Hotel Booking API",description = "methods for managing hotel bookings",stage = ApiStage.RC)
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings from database")
    public List<HotelBooking> getAll(){
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}" , method = RequestMethod.GET)
    @ApiMethod(description = "Get affordable hotels by pricePerNight as provided")
    public List<HotelBooking> getAffordableHotel(@ApiPathParam(name = "price") @PathVariable double price){
        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create" , method = RequestMethod.POST)
    @ApiMethod(description = "Create a new hotel and save it in database")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
        bookingRepository.save(hotelBooking);
        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.POST)
    @ApiMethod(description = "Remove a hotel from database by provided id")
    public List<HotelBooking> remove(@ApiPathParam(name = "id") @PathVariable long id){
        bookingRepository.deleteById(id);
        return bookingRepository.findAll();
    }

}
