package com.example.code;

import java.util.Objects;

/**
 * Representation class for canadian cities.
 * @author unknown
 * @version 0.1.0
 */
public class City implements Comparable<City> {
    /**
     * City name capitalized.
     */
    private String name;

    /**
     * Province name capitalized
     */
    private String province;

    /**
     * We compare cities by their names without using province to tie break
     * @param c the object to be compared.
     * @return 0 if equal, positive if greater, negative if less.
     */
    @Override
    public int compareTo(City c) {
        return this.name.compareTo(c.getName());
    }

    /**
     * We want city objects to be considered the same if they have the same name
     * and province.
     * @param other_city City to compare against.
     * @return Are these both cities with the same name and province?
     */
    @Override
    public boolean equals(Object other_city) {
        if (other_city instanceof City) {
            City other = (City)other_city;
            return other.name.equals(name) && other.province.equals(province);
        }
        return false;
    }

    /**
     * The only way to create a new city.
     * @param name
     * @param province
     */
    public City(String name, String province) {
        this.name = name;
        this.province = province;
    }

    /**
     *
     * @return city name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for city name.
     * @param name the city name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for province name
     * @return province name
     */
    public String getProvince() {
        return province;
    }

    /**
     * Setter for province name
     * @param province name of canadian province
     */
    public void setProvince(String province) {
        this.province = province;
    }

}

