
package com.flights.modelclasses;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckinAllocations {

    private List<CheckinAllocation> checkinAllocations = null;
    private Remarks remarks;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CheckinAllocations() {
    }

    /**
     * 
     * @param checkinAllocations
     * @param remarks
     */
    public CheckinAllocations(List<CheckinAllocation> checkinAllocations, Remarks remarks) {
        super();
        this.checkinAllocations = checkinAllocations;
        this.remarks = remarks;
    }

    public List<CheckinAllocation> getCheckinAllocations() {
        return checkinAllocations;
    }

    public void setCheckinAllocations(List<CheckinAllocation> checkinAllocations) {
        this.checkinAllocations = checkinAllocations;
    }

    public Remarks getRemarks() {
        return remarks;
    }

    public void setRemarks(Remarks remarks) {
        this.remarks = remarks;
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
        sb.append(CheckinAllocations.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("checkinAllocations");
        sb.append('=');
        sb.append(((this.checkinAllocations == null)?"<null>":this.checkinAllocations));
        sb.append(',');
        sb.append("remarks");
        sb.append('=');
        sb.append(((this.remarks == null)?"<null>":this.remarks));
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
