package com.bridgelabz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HotelReservationSystem {
    Map<String, Hotel> hotelReservation = new HashMap<>();
    public void addHotel() {
        Hotel obj1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
        Hotel obj2 = new Hotel("Bridgewood", 4, 150, 50, 110, 50);
        Hotel obj3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
        hotelReservation.put(obj1.getHotelName(), obj1);
        hotelReservation.put(obj2.getHotelName(), obj2);
        hotelReservation.put(obj3.getHotelName(), obj3);
    }
    public int findCheapestHotel() {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekDayRate)).collect(Collectors.toList());
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekDayRate());
            return (hotelObjList.get(0).getWeekDayRate());
    }
    public int findCheapestHotelForWeekdayAndWeekend() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 dates in yyyymmdd format: ");
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();
        int weekEnds1 = 0;
        DayOfWeek day1 = LocalDate.parse(date1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(date2).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds1++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds1++;
        }
        if (weekEnds1 == 0) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekDayRate)).collect(Collectors.toList());
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + hotelObjList.get(0).getWeekDayRate() * 2);
            return hotelObjList.get(0).getWeekDayRate() * 2;
        } else if (weekEnds1 == 2) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
            return hotelObjList.get(0).getWeekendRate() * 2;
        } else {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate()) {
                System.out.println("The cheapest hotels are " + hotelObjList.get(0).getHotelName() + " and " + hotelObjList.get(1).getHotelName() + ", Total Rates = $" + (hotelObjList.get(0).getAvgRate()));
                return hotelObjList.get(0).getAvgRate();
            } else {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + (hotelObjList.get(0).getWeekDayRate() + hotelObjList.get(0).getWeekendRate()));
                return hotelObjList.get(0).getWeekDayRate() + hotelObjList.get(0).getWeekendRate();
            }
        }
    }
        public int findCheapestBestRatedHotel() {
            int weekEnds2 = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the 2 dates in yyyymmdd format: ");
            String date1 = sc.nextLine();
            String date2 = sc.nextLine();
            DayOfWeek day11 = LocalDate.parse(date1).getDayOfWeek();
            DayOfWeek day22 = LocalDate.parse(date2).getDayOfWeek();
            if (day11.equals(DayOfWeek.SUNDAY) || day11.equals(DayOfWeek.SATURDAY)) {
                weekEnds2++;
            }
            if (day22.equals(DayOfWeek.SUNDAY) || day22.equals(DayOfWeek.SATURDAY)) {
                weekEnds2++;
            }
            if (weekEnds2 == 0) {
                List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekDayRate)).collect(Collectors.toList());
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekDayRate() * 2);
                return hotelObjList.get(0).getWeekDayRate() * 2;
            }
            if (weekEnds2 == 2) {
                List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());

                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
                return hotelObjList.get(0).getWeekendRate() * 2;
            }
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate() && hotelObjList.get(0).getRating() < hotelObjList.get(1).getRating()) {
                System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating " + hotelObjList.get(1).getRating() + ", Total Rates = $" + (hotelObjList.get(1).getWeekDayRate() + hotelObjList.get(1).getWeekendRate()));
                return hotelObjList.get(1).getAvgRate();
            }
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate() && hotelObjList.get(0).getRating() > hotelObjList.get(1).getRating()) {

                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekDayRate() + hotelObjList.get(0).getWeekendRate()));
                return hotelObjList.get(0).getAvgRate();
            } else {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekDayRate() + hotelObjList.get(0).getWeekendRate()));
                return hotelObjList.get(0).getWeekDayRate() + hotelObjList.get(0).getWeekendRate();
            }
        }
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservationSystem hotel = new HotelReservationSystem();
        hotel.addHotel();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Cheapest hotel.\n2.Cheapest hotel for weekday and weekend.\n3.best rated cheapest hotel");
            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    hotel.findCheapestHotel();
                    break;
                case 2:
                    hotel.findCheapestHotelForWeekdayAndWeekend();
                    break;
                case 3:
                    hotel.findCheapestBestRatedHotel();
                    break;
                default:
                    System.out.println("You Entered Incorrect Choice....!");
                    break;
            }
        }
    }
}
