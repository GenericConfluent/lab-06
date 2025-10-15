package com.example.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A set of city objects.
 */
public class CityList {
    /**
     * The place the cities are kept.
     */
    private List<City> cities = new ArrayList<>();

    /**
     * Add city to the list if it does not exist.
     * @param city the city to add.
     * @throws IllegalArgumentException if city is already in the list
     */
    public void addCity(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * Remove a city from the list.
     * @param city they city to remove
     * @throws IllegalArgumentException if city is not in the list
     */
    public void removeCity(City city) {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);
    }

    /**
     * Number of cities currently stored
     * @return The number of cities currently stored.
     */
    public int countCity() {
        return cities.size();
    }

    /**
     * Get a distince list of cities.
     * @return sorted list of cities
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Check if a city is in the CityList.
     * @param city City to check.
     * @return Wether or not it's in the list.
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }
}
