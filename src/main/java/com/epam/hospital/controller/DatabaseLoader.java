package com.epam.hospital.controller;

import com.epam.hospital.entity.Hospital;
import com.epam.hospital.exception.XmlDataException;
import com.epam.hospital.parser.XmlHospitalParser;
import com.epam.hospital.singelton.SingletonHospital;
import com.epam.hospital.writer.XmlHospitalWriter;
import org.apache.log4j.Logger;

public class DatabaseLoader {

    private static final Logger logger = Logger.getLogger(DatabaseLoader.class);
    private static final String PATH = "src/main/resources/hospital.xml";

    public void load() {
        try {
                XmlHospitalParser parser = new XmlHospitalParser();
                Hospital hospitalData = parser.parse(PATH);
                SingletonHospital.init(hospitalData);
        } catch (XmlDataException e) {
            logger.warn("data not loaded .", e);
        }
    }

    public void destroy() {
        try {
                XmlHospitalWriter xmlWriter = new XmlHospitalWriter();
                Hospital hospital = SingletonHospital.getInstance();
                xmlWriter.write(hospital, PATH);
        } catch (XmlDataException e) {
            logger.warn("data not saved .", e);
        }
    }
}
