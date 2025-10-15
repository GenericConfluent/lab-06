package com.example.code;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.addCity(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.addCity(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.addCity(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.addCity(city);
        });
    }

    @Test
    public void testRemove() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City yellow = new City("Yellowknife", "Northwest Territories");
        City regina = new City("Regina", "Saskatchewan");
        cityList.addCity(yellow);
        cityList.addCity(regina);
        assertEquals(3, cityList.getCities().size());
        cityList.removeCity(mockCity());
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(yellow));
        assertTrue(cityList.getCities().contains(regina));
        assertFalse(cityList.getCities().contains(mockCity()));
    }

    @Test
    public void testCount() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCity());
        City yellow = new City("Yellowknife", "Northwest Territories");
        City regina = new City("Regina", "Saskatchewan");
        cityList.addCity(yellow);
        cityList.addCity(regina);
        assertEquals(3, cityList.countCity());
        cityList.removeCity(mockCity());
        assertEquals(2, cityList.countCity());
    }

    @Test
    public void testRemoveException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.removeCity(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(charlottetown);
        assertEquals(0, charlottetown.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        cityList.addCity(charlottetown);
        assertTrue(cityList.hasCity(charlottetown));
        assertTrue(cityList.hasCity(mockCity()));

        City city = new City("Yellowknife", "Northwest Territories");
        assertFalse(cityList.hasCity(city));
    }
}
