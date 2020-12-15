package com.wine.to.up.simple.parser.service.controller;

import com.wine.to.up.simple.parser.service.domain.entity.Brands;
import com.wine.to.up.simple.parser.service.domain.entity.Countries;
import com.wine.to.up.simple.parser.service.domain.entity.Grapes;
import com.wine.to.up.simple.parser.service.domain.entity.Wine;
import com.wine.to.up.simple.parser.service.repository.BrandsRepository;
import com.wine.to.up.simple.parser.service.repository.CountriesRepository;
import com.wine.to.up.simple.parser.service.repository.GrapesRepository;
import com.wine.to.up.simple.parser.service.repository.WineRepository;
import com.wine.to.up.simple.parser.service.simple_parser.ParserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainControllerTest {
    @Mock
    private GrapesRepository grapesRepository;
    @Mock
    private BrandsRepository brandsRepository;
    @Mock
    private CountriesRepository countriesRepository;
    @Mock
    private WineRepository wineRepository;
    @Mock
    private ParserService parserService;
    @InjectMocks
    private MainController mainController;

    @Test
    public void testRunParser() {
        assertEquals("Parser started by request", mainController.runParser(1, 1));
    }

    @Test
    public void testGetAllGrapes() {
        List<Grapes> grapes = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Grapes grape = new Grapes();
            grape.setGrapeID(UUID.fromString("5211e915-c3e2-4dcb-0776-c7b900f38ab7"));
            grape.setGrapeName("Grape " + i);
            grapes.add(grape);
        }
        when(grapesRepository.findAll()).thenReturn(grapes);
        assertEquals("Grapes(grapeID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, grapeName=Grape 1)<br>" +
                "Grapes(grapeID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, grapeName=Grape 2)<br>" +
                "Grapes(grapeID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, grapeName=Grape 3)<br>", mainController.getAllGrapes());
    }

    @Test
    public void testGetAllBrands() {
        List<Brands> brands = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Brands brand = new Brands();
            brand.setBrandID(UUID.fromString("5211e915-c3e2-4dcb-0776-c7b900f38ab7"));
            brand.setBrandName("Brand " + i);
            brands.add(brand);
        }
        when(brandsRepository.findAll()).thenReturn(brands);
        assertEquals("Brands(brandID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, brandName=Brand 1)<br>" +
                "Brands(brandID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, brandName=Brand 2)<br>" +
                "Brands(brandID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, brandName=Brand 3)<br>", mainController.getAllBrands());
    }

    @Test
    public void testGetAllCountries() {
        List<Countries> countries = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Countries country = new Countries();
            country.setCountryID(UUID.fromString("5211e915-c3e2-4dcb-0776-c7b900f38ab7"));
            country.setCountryName("Country " + i);
            countries.add(country);
        }
        when(countriesRepository.findAll()).thenReturn(countries);
        assertEquals("Countries(countryID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, countryName=Country 1)<br>" +
                "Countries(countryID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, countryName=Country 2)<br>" +
                "Countries(countryID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, countryName=Country 3)<br>", mainController.getAllCountries());
    }

    @Test
    public void testGetAllWines() {
        List<Wine> wines = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            Wine wine = new Wine();
            wine.setWineID(UUID.fromString("5211e915-c3e2-4dcb-0776-c7b900f38ab7"));
            wine.setName("Wine " + i);
            wines.add(wine);
        }
        when(wineRepository.findAll()).thenReturn(wines);
        assertEquals("Wine(wineID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, name=Wine 1," +
                        " image=null, brandID=null, countryID=null, newPrice=null, discount=null," +
                        " capacity=null, strength=null, year=0, color=null, sugar=null, grapeSort=null," +
                        " region=null, link=null, rating=null, sparkling=false, gastronomy=null, taste=null)<br>" +
                        "Wine(wineID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, name=Wine 2," +
                        " image=null, brandID=null, countryID=null, newPrice=null, discount=null," +
                        " capacity=null, strength=null, year=0, color=null, sugar=null, grapeSort=null," +
                        " region=null, link=null, rating=null, sparkling=false, gastronomy=null, taste=null)<br>" +
                        "Wine(wineID=5211e915-c3e2-4dcb-0776-c7b900f38ab7, name=Wine 3," +
                        " image=null, brandID=null, countryID=null, newPrice=null, discount=null," +
                        " capacity=null, strength=null, year=0, color=null, sugar=null, grapeSort=null," +
                        " region=null, link=null, rating=null, sparkling=false, gastronomy=null, taste=null)<br>"
                , mainController.getAllWines());
    }

    @Test
    public void testHome() {
        String expectedHTML = "<ul>";
        expectedHTML += " <li><a href='/simple-parser/run-parser'>Run parser</a></li>";
        expectedHTML += " <li><a href='/simple-parser/all-wines'>Show All Wines</a></li>";
        expectedHTML += " <li><a href='/simple-parser/all-countries'>Show All Countries</a></li>";
        expectedHTML += " <li><a href='/simple-parser/all-brands'>Show All Brands</a></li>";
        expectedHTML += " <li><a href='/simple-parser/all-grapes'>Show All Grapes</a></li>";
        expectedHTML += "</ul>";
        assertEquals(expectedHTML, mainController.home());
    }
}
