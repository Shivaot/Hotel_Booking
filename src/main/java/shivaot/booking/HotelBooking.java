package shivaot.booking;

public class HotelBooking {
    private String hotelName;
    private double pricePerNight;
    private int nbOfNights;

    //required for rest response body
    public HotelBooking(){}

    public HotelBooking(String hotelName, double pricePerNight, int nOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nbOfNights = nOfNights;
    }

    public String getHotelName() {
        return hotelName;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getNbOfNightsOfNights() {
        return nbOfNights;
    }

    public double getTotalPrice(){
        return pricePerNight * nbOfNights;
    }
}
