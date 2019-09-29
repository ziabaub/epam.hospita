package com.epam.hospital.writer;

import com.epam.hospital.entity.Hospital;
import com.epam.hospital.exception.XmlOutInException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlHospitalWriter {
    public void Write(Hospital hospital, String fileName) throws XmlOutInException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.writeValue(new File(fileName), hospital);
        } catch (IOException e) {
            throw new XmlOutInException("can't read file Xml name = [" + fileName + "]", e);
        }
    }
}
