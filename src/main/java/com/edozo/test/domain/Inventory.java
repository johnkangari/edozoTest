package com.edozo.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "inventory_id")
    private int id;
    @Column(name = "film_id")
    private short filmId;
    @Column(name = "store_id")
    private short storeId;
    @Column(name = "last_update")
    private Date lastUpdate;

    public Inventory() {
    }

    public Inventory(int id, short filmId, short storeId, Date lastUpdate) {
        this.id = id;
        this.filmId = filmId;
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public short getStoreId() {
        return storeId;
    }

    public void setStoreId(short storeId) {
        this.storeId = storeId;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
