package com.epam.hospital.utils;

import com.epam.hospital.entity.Entity;

import java.util.Comparator;

public class IdEntityComparator implements Comparator<Entity> {

    @Override
    public int compare(Entity o1, Entity o2) {
        return o1.getId()-o2.getId();
    }
}
