package com.example.football.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class XmlParserImpl implements XmlParser{

    @Override
    @SuppressWarnings("unchecked")
    public <E> E parse(String path, Class<E> entity) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(entity);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (E) unmarshaller.unmarshal(new File(path));
    }
}
