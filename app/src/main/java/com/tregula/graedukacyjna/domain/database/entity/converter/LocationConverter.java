package com.tregula.graedukacyjna.domain.database.entity.converter;

import com.tregula.graedukacyjna.base.converter.Converter;
import com.tregula.graedukacyjna.domain.database.entity.Location;
import com.tregula.graedukacyjna.utils.DoubleParser;

public class LocationConverter implements Converter<String, Location> {

    @Override
    public Location convert(String container) {
        String[] locations = container.split(",");
        DoubleParser parser = new DoubleParser();
        if (locations.length == 2) {
            return new Location(parser.parse(locations[0]), parser.parse(locations[1]));
        }
        return new Location(0D, 0D);
    }
}
