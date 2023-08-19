package com.example.demo.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

import com.example.demo.model.enums.FoodType;

// String Enum in Datenbank eintragen 
// https://www.baeldung.com/jpa-persisting-enums-in-jpa

// nicht verwendet da enums in Postgres sehr problematisch mit Hibernate!!!
// mit MySQL geht scheinbar

@Converter(autoApply = true) // PA will automatically apply the conversion logic to all mapped attributes of a Category type.
public class FeedingConverter implements AttributeConverter<FoodType, String> {
	
	@Override
    public String convertToDatabaseColumn(FoodType category) {
        if (category == null) {
            return null;
        }
        return category.getName();
    }

    @Override
    public FoodType convertToEntityAttribute(String name) {
        if (name == null) {
            return null;
        }

        return Stream.of(FoodType.values())
          .filter(c -> c.getName().equals(name))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }

}
