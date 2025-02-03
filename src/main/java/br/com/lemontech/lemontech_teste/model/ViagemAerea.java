package br.com.lemontech.lemontech_teste.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "viagens")
public class ViagemAerea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String passagerName; // nome

    @Column( nullable = false)
    private String flightCompany; // source

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime departureDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime arrivalDate;

    @Column(nullable = false)
    private String originCity;

    @Column(nullable = false)
    private String destinyCity;

    public ViagemAerea() {}

    public Long getId() {
        return id;
    }

    public ViagemAerea setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPassagerName() {
        return passagerName;
    }

    public ViagemAerea setPassagerName(String passagerName) {
        this.passagerName = passagerName;
        return this;
    }

    public String getFlightCompany() {
        return flightCompany;
    }

    public ViagemAerea setFlightCompany(String flightCompany) {
        this.flightCompany = flightCompany;
        return this;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public ViagemAerea setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public ViagemAerea setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
        return this;
    }

    public String getOriginCity() {
        return originCity;
    }

    public ViagemAerea setOriginCity(String originCity) {
        this.originCity = originCity;
        return this;
    }

    public String getDestinyCity() {
        return destinyCity;
    }

    public ViagemAerea setDestinyCity(String destinyCity) {
        this.destinyCity = destinyCity;
        return this;
    }
}
