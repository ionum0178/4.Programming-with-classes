package by.javalearning.homework.theme4;

import java.time.LocalTime;
import java.util.ArrayList;

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

public class AirlineBase {
    
    private static ArrayList<Airline> flightsList = new ArrayList<>();

    public AirlineBase() {
    }

    public void addFlight(Airline flight) {
	flightsList.add(flight);
    }

    public ArrayList<Airline> getflightsList() {
	return flightsList;
    }

    public void getList() {
	for (var c : flightsList)
	    System.out.println(c.toString());
    }

    public void getFlightsByDestination(String destination) {
	int j = 0;
	for (int i = 0; i < flightsList.size(); i++) {
	    if (flightsList.get(i).getDestination().equalsIgnoreCase(destination)) {
		System.out.println(flightsList.get(i).toString());
		j++;
	    }
	}
	if (j == 0)
	    System.out.println("� ���� ����� ���������� ������ �� �������.");
    }

    public void getWeekDayFlights(int day) {
	int j = 0;
	for (int i = 0; i < flightsList.size(); i++) {
	    for (int k=0; k<flightsList.get(i).getWeekDays().length; k++) {
		if (flightsList.get(i).getWeekDays()[k]==day) {
		    System.out.println(flightsList.get(i).toString());
			j++;
		}
	    }
	}
    	if (j == 0)
	    System.out.println("�� ���� ���� ������ ������ �� �������.");
    }

    public void getWeekDayTimeFlights(int day, LocalTime depart) {
	int j = 0;
	for (int i = 0; i < flightsList.size(); i++) {
	    for (int k=0; k<flightsList.get(i).getWeekDays().length; k++) {
		if (flightsList.get(i).getWeekDays()[k]==day) {
		    if(flightsList.get(i).getDepart().isAfter(depart))
		    System.out.println(flightsList.get(i).toString());
			j++;
		}
	    }
	}
    	if (j == 0)
	    System.out.println("�� ���� ���� ������ ������ �� �������.");
	
    }
}
