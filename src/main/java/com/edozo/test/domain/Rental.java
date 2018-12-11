package com.edozo.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @Column(name = "rental_id")
    private int id;
    @Column(name = "rental_date", nullable = false)
    private Date rentalDate;
    @Column(name = "inventory_id", nullable = false)
    private int inventoryId;
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Column(name = "return_date")
    private Date returnDate;
    @Column(name = "staff_id", nullable = false)
    private short staffId;
    @Column(name = "last_update", nullable = false)
    private Date lastUpdate;

    public Rental() {
    }

    public Rental(int id, Date rentalDate, int inventoryId, int customerId, Date returnDate, short staffId, Date lastUpdate) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.inventoryId = inventoryId;
        this.customerId = customerId;
        this.returnDate = returnDate;
        this.staffId = staffId;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public short getStaffId() {
        return staffId;
    }

    public void setStaffId(short staffId) {
        this.staffId = staffId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
