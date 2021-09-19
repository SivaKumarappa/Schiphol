package com.flights.modelclasses; 
import java.util.List; 
public class Route{
    public List<String> destinations;
    public List<String> getDestinations() {
		return destinations;
	}
	public void setDestinations(List<String> destinations) {
		this.destinations = destinations;
	}
	public String getEu() {
		return eu;
	}
	public void setEu(String eu) {
		this.eu = eu;
	}
	public boolean isVisa() {
		return visa;
	}
	public void setVisa(boolean visa) {
		this.visa = visa;
	}
	public String eu;
    public boolean visa;
}
