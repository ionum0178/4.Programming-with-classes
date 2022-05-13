package by.javalearning.homework.theme4;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Scanner;

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

public class ClassesBasicEx10 {

    static AirlineBase flights = new AirlineBase();
    static Airline flight;
    static String destination;
    static String flightNr;
    static String aircraftType;
    static LocalTime depart;
    static int[] weekDay = new int[7];

    public static void main(String[] args) throws FileNotFoundException {
	setDefaultFlightsTimeTable();
	startMenu();
    }
    
    private static void setDefaultFlightsTimeTable() {
	File file = new File(
		"D:\\Documents\\�������\\������\\���\\����� �����\\Eclipse\\ClassesBasicEx10\\src\\by\\javalearning\\theme4\\TimeTable.txt");
	Scanner sc = null;
	try {
	    sc = new Scanner(file).useDelimiter("\\t|:|\\r\\n");
	    while (sc.hasNextLine()) {
		destination = sc.next();
		String weekseq = sc.next();
		for(int i=0; i<weekDay.length; i++) {
		    weekDay[i]=0;
		    if(Character.isDigit(weekseq.charAt(i))) {
			weekDay[i]=Character.digit(weekseq.charAt(i), 10);
		    }
		}
		int hours = Integer.parseInt(sc.next());
		int minutes = Integer.parseInt(sc.next());
		depart = LocalTime.of(hours, minutes);
		flightNr = sc.next();
		aircraftType = sc.next();
		flight = new Airline(destination, flightNr, aircraftType, depart, weekDay);
		flight.newFlight(destination, flightNr, aircraftType, depart, weekDay);
		continue;
	    }
	} catch (FileNotFoundException e) {
	    System.out.println("File not found");
	    e.printStackTrace();
	    System.exit(1);
	}
    }

    public static void startMenu() {
	Scanner sc = new Scanner(System.in);
	int i = -1;
	while (i != 7) {
	    System.out.println("1-������� ���� ������ ������ (�� ���������)");
	    System.out.println("2-������� ������ ������ ��� ��������� ������ ����������");
	    System.out.println("3-������� ������ ������ ��� ��������� ��� ������");
	    System.out.println("4-������� ������ ������ ������ ��� ��������� \r\n"
	    	+ " ��� ������, ����� ������ ������� ������ ���������");
	    System.out.println("5-��������� ���������");
	    if (sc.hasNextInt()) {
		i = sc.nextInt();
		sc.nextLine();
	    } else {
		System.out.println("���������� ��� ���!");
		System.exit(1);
	    }
	    switch (i) {
	    case 1: {
		flights.getList();
		break;
	    }
	    case 2: {
		System.out.print("������� ����� ����������: ");
		String destination = sc.nextLine();
		flights.getFlightsByDestination(destination);
		break;
	    }
	    case 3: {
		System.out.println("�������� ���� ������: ");
		System.out.println("1-�����������");
		System.out.println("2-�������");
		System.out.println("3-�����");
		System.out.println("4-�������");
		System.out.println("5-�������");
		System.out.println("6-�������");
		System.out.println("7-�����������");
		int day = sc.nextInt();
		if (day<1 || day>7) {
		    System.out.println("�� ����� �������� �����!");
		    System.out.println("���������� ��� ���!");
		    break;
		}
		flights.getWeekDayFlights(day);
		break;
	    }
	    case 4: {
		System.out.println("�������� ���� ������: ");
		System.out.println("1-�����������");
		System.out.println("2-�������");
		System.out.println("3-�����");
		System.out.println("4-�������");
		System.out.println("5-�������");
		System.out.println("6-�������");
		System.out.println("7-�����������");
		int day = sc.nextInt();
		if (day<1 || day>7) {
		    System.out.println("�� ����� �������� �����!");
		    System.out.println("���������� ��� ���!");
		    break;
		}
		System.out.print("������� ����� ������ (����): ");
		int hours = Integer.parseInt(sc.next());
		System.out.print("������� ����� ������ (������): ");
		int minutes = Integer.parseInt(sc.next());
		depart = LocalTime.of(hours, minutes);
		flights.getWeekDayTimeFlights(day, depart);
		break;
	    }
	    case 5: {
		sc.close();
		System.exit(1);
	    }
	    }

	}
    }
}
