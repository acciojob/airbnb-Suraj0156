package com.driver;

import com.driver.model.Facility;

import java.util.List;

public class Hotel {
    private String hotelName; //This will be the primary key and on

    private int availableRooms;

    private List<Facility> facilities;
    private int pricePerNight;|

    public Hotel (String hotelName, int availableRooms, List<Facility> facilities, int price){
        this.hotelName = hotelName;
        this.availableRooms = availableRooms;
        this.facilities = facilities;
        this.pricePerNight = pricePerNight;
}
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

        public int getAvailableRooms() { return availableRooms; }

        public void setAvailableRooms (int availableRooms) {
        this.availableRooms = availableRooms;
