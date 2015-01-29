package com.parking.rest.entity;

import java.util.Date;

public class Parking  {

    Date parkingDate;

    Account pickedBy;

    Vehicle vehicle;

    Date whenPicked;

    private Double latitude;

    private Double longitude;

    private Long id;

    private Account account;

    private ParkingStatusEnum status;

    public Parking() {
    }

    public Date getParkingDate() {
        return parkingDate;
    }

    public void setParkingDate(Date parkingDate) {
        this.parkingDate = parkingDate;
    }

    public Account getPickedBy() {
        return pickedBy;
    }

    public void setPickedBy(Account pickedBy) {
        this.pickedBy = pickedBy;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getWhenPicked() {
        return whenPicked;
    }

    public void setWhenPicked(Date whenPicked) {
        this.whenPicked = whenPicked;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ParkingStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ParkingStatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parking)) return false;
        Parking parking = (Parking) o;
        if (!id.equals(parking.id)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * id.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingDate=" + parkingDate +
                ", pickedBy=" + pickedBy +
                ", vehicle=" + vehicle +
                ", whenPicked=" + whenPicked +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", id=" + id +
                ", account=" + account +
                ", status=" + status +
                '}';
    }
}
