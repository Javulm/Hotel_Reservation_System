package com.bridgelabz;

public class Hotel {
    String hotelName;
    int rating;
    int weekDayRate;
    int weekendRate;
    int specialWeekDayRate;
    int specialWeekendRate;
    int avgRate;
    int specialAvgRate;

    public Hotel(String hotelName, int rating, int weekDayRate, int weekendRate, int specialWeekDayRate, int specialWeekendRate) {
        this.hotelName = hotelName;
        this.rating = rating;
        this.weekDayRate = weekDayRate;
        this.weekendRate = weekendRate;
        this.specialWeekDayRate = specialWeekDayRate;
        this.specialWeekendRate = specialWeekendRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getWeekDayRate() {
        return weekDayRate;
    }

    public void setWeekDayRate(int weekDayRate) {
        this.weekDayRate = weekDayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(int weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getSpecialWeekDayRate() {
        return specialWeekDayRate;
    }

    public void setSpecialWeekDayRate(int specialWeekDayRate) {
        this.specialWeekDayRate = specialWeekDayRate;
    }

    public int getSpecialWeekendRate() {
        return specialWeekendRate;
    }

    public void setSpecialWeekendRate(int specialWeekendRate) {
        this.specialWeekendRate = specialWeekendRate;
    }

    public int getAvgRate() {
        return avgRate;
    }

    public void setAvgRate(int avgRate) {
        this.avgRate = avgRate;
    }

    public int getSpecialAvgRate() {
        return specialAvgRate;
    }

    public void setSpecialAvgRate(int specialAvgRate) {
        this.specialAvgRate = specialAvgRate;
    }
}
