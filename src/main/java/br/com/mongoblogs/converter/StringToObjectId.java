package br.com.mongoblogs.converter;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToObjectId implements Converter<String, ObjectId> {

    @Override
    public ObjectId convert(String s) {
        ObjectId objectId = new ObjectId(s.trim());
        return objectId;
    }
}
