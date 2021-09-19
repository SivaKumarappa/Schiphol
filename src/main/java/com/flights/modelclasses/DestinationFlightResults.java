package com.flights.modelclasses;

import java.util.Date;
import java.util.List;

public class DestinationFlightResults {
    public String flightName;
    public int flightNumber;
    public Date scheduleDateTime;
    public String scheduleDate;
    public String scheduleTime;
    public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Date getScheduleDateTime() {
		return scheduleDateTime;
	}
	public void setScheduleDateTime(Date scheduleDateTime) {
		this.scheduleDateTime = scheduleDateTime;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getIataMain() {
		return iataMain;
	}
	public void setIataMain(String iataMain) {
		this.iataMain = iataMain;
	}
	public List<String> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}
	public String iataMain;
    public List<String> destinations;
    

}
