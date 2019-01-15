package com.tregula.graedukacyjna.domain.database.entity.converter;

import com.tregula.graedukacyjna.base.converter.Converter;
import com.tregula.graedukacyjna.domain.database.entity.Country;
import com.tregula.graedukacyjna.domain.database.entity.Location;
import com.tregula.graedukacyjna.domain.remote.CapitolJson;
import com.tregula.graedukacyjna.domain.remote.CountryJson;

public class CountryConverter implements Converter<CountryJson, Country> {

    private final Converter<String, Location> locationConverter;

    public CountryConverter(Converter<String, Location> locationConverter) {
        this.locationConverter = locationConverter;
    }

    @Override
    public Country convert(CountryJson countryJson) {
        Location countryLocation = locationConverter.convert(countryJson.country_latitude +
                "," +
                countryJson.country_longitude);

        CapitolJson capitolJson = countryJson.capitol;
        Location capitolLocation = locationConverter.convert(capitolJson.capitol_latitude +
                "," +
                capitolJson.capitol_longitude);

        return new Country(countryJson.country_name,
                countryLocation,
                capitolJson.capitol_name,
                capitolLocation,
                countryJson.country_wiki,
                capitolJson.capitol_wiki);
    }
}
