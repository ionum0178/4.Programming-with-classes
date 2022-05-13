package by.javalearning.homework.theme4;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
 * 4. Programming with classes
 * ���������� ������ � �������.
 * ������ 10. ������� ����� Airline, ������������ �������� ��������� ����. 
 * ���������� ������������, set-� get-������ � �����  toString(). ������� 
 * ������ �����, ������������ ������ ���� Airline, � ����������� �������������� 
 * � ��������. ������ �������� ������ ������ � ������� ��� ������ �� �������. 
 * Airline: ����� ����������, ����� �����, ��� ��������, ����� ������, ��� ������. 
 * ����� � �������: a) ������ ������ ��� ��������� ������ ����������; 
 * b) ������ ������ ��� ��������� ��� ������; c) ������ ������ ��� ��������� 
 * ��� ������, ����� ������ ��� ������� ������ ���������.
 */

public class Airline {
    
    private String destination;
    private String flightNr;
    private String aircraftType;
    private LocalTime depart;
    private int[] weekDay = new int[7];
    private static AirlineBase flights = new AirlineBase();

    public Airline(String destination, String flightNr, String aircraftType, LocalTime depart, int[] weekDay) {
	this.destination = destination;
	this.flightNr = flightNr;
	this.aircraftType = aircraftType;
	this.depart = depart;
	for (int i=0; i<weekDay.length; i++) 
	    this.weekDay[i]=weekDay[i];
    }
    
    public Airline() {}

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightNr() {
        return flightNr;
    }

    public void setFlightNr(String flightNr) {
        this.flightNr = flightNr;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public LocalTime getDepart() {
        return depart;
    }

    public void setDepart(LocalTime depart) {
        this.depart = depart;
    }

    public int[] getWeekDays() {
        return weekDay;
    }

    public void setWeekDays(int[] weekDay) {
        this.weekDay = weekDay;
    }

    public void newFlight(String destination, String flightNr, String aircraftType, LocalTime depart, int[] weekDay) {
	Airline flight = new Airline(destination, flightNr, aircraftType, depart, weekDay);
	flights.addFlight(flight);
    }

    public void getList() {
	for (var c : flights.getflightsList())
	    System.out.println(c.toString());
    }

    @Override
    public String toString() {
	String week = "";
	for(int i=0; i<getWeekDays().length; i++) {
	    if (getWeekDays()[i]!=0)
	    week += DayOfWeek.of(getWeekDays()[i]).getDisplayName(TextStyle.NARROW, Locale.getDefault()) + " ";
	}
	return String.format("%-14s %14s %9s %4s %23s", destination, depart, flightNr, aircraftType, week);
    }


}


