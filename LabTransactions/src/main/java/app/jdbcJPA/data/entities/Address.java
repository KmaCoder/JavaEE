package app.jdbcJPA.data.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;
    private String zipcode;
    private String country;
// Constructors, getters, setters

    public Address() {

    }

    public Address(String street, String city, String zipcode, String country) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street1) {
        this.street = street1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getId(), address.getId()) &&
                Objects.equals(getStreet(), address.getStreet()) &&
                Objects.equals(getCity(), address.getCity()) &&
                Objects.equals(getZipcode(), address.getZipcode()) &&
                Objects.equals(getCountry(), address.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStreet(), getCity(), getZipcode(), getCountry());
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street1='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
