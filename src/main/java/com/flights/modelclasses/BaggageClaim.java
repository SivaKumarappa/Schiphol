
package com.flights.modelclasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaggageClaim {

    private List<String> belts = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BaggageClaim() {
    }

    /**
     * 
     * @param belts
     */
    public BaggageClaim(List<String> belts) {
        super();
        this.belts = belts;
    }

    public List<String> getBelts() {
        return belts;
    }

    public void setBelts(List<String> belts) {
        this.belts = belts;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BaggageClaim.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("belts");
        sb.append('=');
        sb.append(((this.belts == null)?"<null>":this.belts));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
