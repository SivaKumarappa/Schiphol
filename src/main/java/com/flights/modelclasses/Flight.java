package com.flights.modelclasses;

import java.util.Date;

public class Flight{
    public Date lastUpdatedAt;
    public Object actualLandingTime;
    public Object actualOffBlockTime;
    public String aircraftRegistration;
    public AircraftType aircraftType;
    public Object baggageClaim;
    public CheckinAllocations checkinAllocations;
    public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	public Object getActualLandingTime() {
		return actualLandingTime;
	}
	public void setActualLandingTime(Object actualLandingTime) {
		this.actualLandingTime = actualLandingTime;
	}
	public Object getActualOffBlockTime() {
		return actualOffBlockTime;
	}
	public void setActualOffBlockTime(Object actualOffBlockTime) {
		this.actualOffBlockTime = actualOffBlockTime;
	}
	public String getAircraftRegistration() {
		return aircraftRegistration;
	}
	public void setAircraftRegistration(String aircraftRegistration) {
		this.aircraftRegistration = aircraftRegistration;
	}
	public AircraftType getAircraftType() {
		return aircraftType;
	}
	public void setAircraftType(AircraftType aircraftType) {
		this.aircraftType = aircraftType;
	}
	public Object getBaggageClaim() {
		return baggageClaim;
	}
	public void setBaggageClaim(Object baggageClaim) {
		this.baggageClaim = baggageClaim;
	}
	public CheckinAllocations getCheckinAllocations() {
		return checkinAllocations;
	}
	public void setCheckinAllocations(CheckinAllocations checkinAllocations) {
		this.checkinAllocations = checkinAllocations;
	}
	public Codeshares getCodeshares() {
		return codeshares;
	}
	public void setCodeshares(Codeshares codeshares) {
		this.codeshares = codeshares;
	}
	public Object getEstimatedLandingTime() {
		return estimatedLandingTime;
	}
	public void setEstimatedLandingTime(Object estimatedLandingTime) {
		this.estimatedLandingTime = estimatedLandingTime;
	}
	public Object getExpectedTimeBoarding() {
		return expectedTimeBoarding;
	}
	public void setExpectedTimeBoarding(Object expectedTimeBoarding) {
		this.expectedTimeBoarding = expectedTimeBoarding;
	}
	public Object getExpectedTimeGateClosing() {
		return expectedTimeGateClosing;
	}
	public void setExpectedTimeGateClosing(Object expectedTimeGateClosing) {
		this.expectedTimeGateClosing = expectedTimeGateClosing;
	}
	public Object getExpectedTimeGateOpen() {
		return expectedTimeGateOpen;
	}
	public void setExpectedTimeGateOpen(Object expectedTimeGateOpen) {
		this.expectedTimeGateOpen = expectedTimeGateOpen;
	}
	public Object getExpectedTimeOnBelt() {
		return expectedTimeOnBelt;
	}
	public void setExpectedTimeOnBelt(Object expectedTimeOnBelt) {
		this.expectedTimeOnBelt = expectedTimeOnBelt;
	}
	public String getExpectedSecurityFilter() {
		return expectedSecurityFilter;
	}
	public void setExpectedSecurityFilter(String expectedSecurityFilter) {
		this.expectedSecurityFilter = expectedSecurityFilter;
	}
	public String getFlightDirection() {
		return flightDirection;
	}
	public void setFlightDirection(String flightDirection) {
		this.flightDirection = flightDirection;
	}
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
	public String getGate() {
		return gate;
	}
	public void setGate(String gate) {
		this.gate = gate;
	}
	public String getPier() {
		return pier;
	}
	public void setPier(String pier) {
		this.pier = pier;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isOperationalFlight() {
		return isOperationalFlight;
	}
	public void setOperationalFlight(boolean isOperationalFlight) {
		this.isOperationalFlight = isOperationalFlight;
	}
	public String getMainFlight() {
		return mainFlight;
	}
	public void setMainFlight(String mainFlight) {
		this.mainFlight = mainFlight;
	}
	public String getPrefixIATA() {
		return prefixIATA;
	}
	public void setPrefixIATA(String prefixIATA) {
		this.prefixIATA = prefixIATA;
	}
	public String getPrefixICAO() {
		return prefixICAO;
	}
	public void setPrefixICAO(String prefixICAO) {
		this.prefixICAO = prefixICAO;
	}
	public int getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(int airlineCode) {
		this.airlineCode = airlineCode;
	}
	public Object getPublicEstimatedOffBlockTime() {
		return publicEstimatedOffBlockTime;
	}
	public void setPublicEstimatedOffBlockTime(Object publicEstimatedOffBlockTime) {
		this.publicEstimatedOffBlockTime = publicEstimatedOffBlockTime;
	}
	public PublicFlightState getPublicFlightState() {
		return publicFlightState;
	}
	public void setPublicFlightState(PublicFlightState publicFlightState) {
		this.publicFlightState = publicFlightState;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public int getTerminal() {
		return terminal;
	}
	public void setTerminal(int terminal) {
		this.terminal = terminal;
	}
	public TransferPositions getTransferPositions() {
		return transferPositions;
	}
	public void setTransferPositions(TransferPositions transferPositions) {
		this.transferPositions = transferPositions;
	}
	public String getSchemaVersion() {
		return schemaVersion;
	}
	public void setSchemaVersion(String schemaVersion) {
		this.schemaVersion = schemaVersion;
	}
	public Codeshares codeshares;
    public Object estimatedLandingTime;
    public Object expectedTimeBoarding;
    public Object expectedTimeGateClosing;
    public Object expectedTimeGateOpen;
    public Object expectedTimeOnBelt;
    public String expectedSecurityFilter;
    public String flightDirection;
    public String flightName;
    public int flightNumber;
    public String gate;
    public String pier;
    public String id;
    public boolean isOperationalFlight;
    public String mainFlight;
    public String prefixIATA;
    public String prefixICAO;
    public int airlineCode;
    public Object publicEstimatedOffBlockTime;
    public PublicFlightState publicFlightState;
    public Route route;
    public Date scheduleDateTime;
    public String scheduleDate;
    public String scheduleTime;
    public String serviceType;
    public int terminal;
    public TransferPositions transferPositions;
    public String schemaVersion;
}
