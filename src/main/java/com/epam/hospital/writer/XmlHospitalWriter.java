package com.epam.hospital.writer;

import com.epam.hospital.entity.Hospital;
import com.epam.hospital.exception.XmlDataException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlHospitalWriter {
    public void write(Hospital hospital, String fileName) throws XmlDataException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), hospital);
        } catch (IOException e) {
            throw new XmlDataException("can't open file Xml name = [" + fileName + "]", e);
        }
    }
}
