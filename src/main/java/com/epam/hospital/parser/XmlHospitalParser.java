package com.epam.hospital.parser;

import com.epam.hospital.entity.Hospital;
import com.epam.hospital.exception.XmlOutInException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XmlHospitalParser {

    public Hospital parse(String fileName) throws XmlOutInException {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xmlText = new String(Files.readAllBytes(Paths.get(fileName)));
            return xmlMapper.readValue(xmlText, Hospital.class);
        } catch (IOException e) {
            throw new XmlOutInException("can't parse file Xml name = [" + fileName + "]", e);
        }
    }
}