package com.tregula.graedukacyjna.domain.database.entity.converter;

import com.tregula.graedukacyjna.base.converter.Converter;
import com.tregula.graedukacyjna.domain.database.entity.Continent;
import com.tregula.graedukacyjna.domain.database.entity.Location;
import com.tregula.graedukacyjna.domain.remote.data.ContinentJson;

public class ContinentConverter implements Converter<ContinentJson, Continent> {

    private final Converter<String, Location> locationConverter;

    public ContinentConverter(Converter<String, Location> locationConverter) {
        this.locationConverter = locationConverter;
    }

    @Override
    public Continent convert(ContinentJson continentJson) {
        Location location = locationConverter.convert(continentJson.continent_latitude
                + ","
                + continentJson.continent_longitude);

        return new Continent(continentJson.continent_name,
                location,
                continentJson.continent_wiki);
    }
}
