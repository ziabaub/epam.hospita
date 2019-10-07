package com.epam.hospital.parser;

import com.epam.hospital.entity.Hospital;
import com.epam.hospital.exception.XmlDataException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class XmlHospitalParser {

    /**
     *
     * @param fileName Xml file name.
     * @return Hospital object where all Patients and Doctors are saved.
     * @throws XmlDataException Exception during parsing.
     */
    public Hospital parse(String fileName) throws XmlDataException {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Path path = Paths.get(fileName);
            String xmlText = new String(Files.readAllBytes(path));
            return xmlMapper.readValue(xmlText, Hospital.class);
        } catch (IOException e) {
            throw new XmlDataException("can't parse file Xml name = [" + fileName + "]", e);
        }
    }
}