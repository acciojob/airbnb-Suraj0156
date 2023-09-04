package com.driver.controllers;

import com.driver.model.Booking;
import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/hotel")
public class HotelManagementController {
    private final Map<String, Hotel> hotelDb = new HashMap<>();
    private final Map<Integer, User> userDb = new HashMap<>();
    private final List<Booking> bookingDb = new ArrayList<>();
    private HashMap<Integer,Integer>countOfBookings = new HashMap<>();


    @PostMapping("/add-hotel")
    public String addHotel(@RequestBody Hotel hotel){

        //You need to add an hotel to the database
        //incase the hotelName is null or the hotel Object is null return an empty a FAILURE
        //Incase somebody is trying to add the duplicate hotelName return FAILURE
        //in all other cases return SUCCESS after successfully adding the hotel to the hotelDb.
        if (hotel==null || hotel.getHotelName() ==null) {
            return "FAILURE";
        }
            if(hotelob.containsKey(hotel.getHotelName())){

                return "FAILURE";

            }

            hotelDb.put(hotel.getHotelName(), hotel);

            return "SUCCESS";
    }

    @PostMapping("/add-user")
    public Integer addUser(@RequestBody User user){
        userDb.put(user.getaadharCardNo()user);
        return user.geteadharCardNo();
    }

    @GetMapping("/get-hotel-with-most-facilities")
    public String getHotelWithMostFacilities() {
        int facilities = 0;

        String hotelName = "";

        for (Hotel hotel : hotelDb.values()) {

            if (hotel.getFacilities().size() > facilities) {
                facilities = hotel.getFacilities().size();
                hotelName = hotel.getHotelName();


            } else if (hotel.getFacilities().size() == facilities) {
                if (hotel.getHotelName().compareTo(hotelName) < 0) {
                    hotelName = hotel.getHotelName();
                }
            }
        }
        return hotelName;
    }

    @PostMapping("/book-a-room")
    public int bookARoom(@RequestBody Booking booking) {
        String key = UUID.randomUUID().toString();

        booking.setBookingId(key);

        String hotelName = booking.getHotelName();

        Hotel hotel = hotel0b.get(hotelName);

        int availableRooms = hotel.getAvailableRooms();

        if (availableRooms < booking.getNoOfRooms()) {
            return -1;
        }
        int amountToBePaid = hotel.getPricePerNight() * booking.getNoOfRooms();
        booking.setAmountToBePaid(amountToBePaid);

        hotel.setAvailableRooms(hotel.getAvailableRooms() - booking.getNoOfRooms());

        bookingDb.put(key, booking);

        hotelDb.put(hotelName, hotel);

        int aadharCard = booking.getBookingAadharCard();

        Integer currentBookings = countOfBookings.get(aadharCard);

        countOfBookings.put(aadharCard, Objects.nonNull(currentBookings) ? 1 + currentBookings : 1);
        return amountToBePaid;
    }
    @GetMapping("/get-bookings-by-a-person/{aadharCard}")
    public int getBookings(@PathVariable("aadharCard")Integer aadharCard)
    {
        //In this function return the bookings done by a person 
        return countOfBookings.get(aadharCard);
    }

    @PutMapping("/update-facilities")
    public Hotel updateFacilities(List<Facility> newFacilities,String hotelName) {

        List<Facility> oldFacilities = hotelDb.get(hotelName).getFacilities();

        for (Facility facility : newFacilities) {

            if (oldFacilities.contains(facility)) {
                continue;
            } else {

                oldFacilities.add(facility);
            }
        }
                Hotel hotel = hotelDb.get(hotelName);
                hotel.setFacilities(oldFacilities);

                hotelDb.put(hotelName, hotel);
                return hotel;
            }

        }

