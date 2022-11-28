package com.example.football.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <E> E parse(String path, Class<E> entity) throws JAXBException;
}
