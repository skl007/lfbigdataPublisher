package com.unicom.lfbigdata.publisher.service.impl;

import com.unicom.lfbigdata.publisher.mapper.DauMapper;
import com.unicom.lfbigdata.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    DauMapper dauMapper;

    @Override
    public Long getDauTotal(String date) {
        return dauMapper.getDauTotal(date);
    }

    @Override
    public List<Map> getDauHourCount(String date) {
        List<Map> dauHourCountList = dauMapper.getDauHourCount(date);
        return dauHourCountList;
    }

    @Override
    public List<Map> getIntoElectronicFence(String dateStart, String dateEnd) {
        List<Map> dauHourCountList = dauMapper.getIntoElectronicFence(dateStart,dateEnd);
        return dauHourCountList;
    }

    @Override
    public List<Map> getIntoEfPeople(String dateStart, String dateEnd, String deviceNumber) {
        List<Map> dauHourCountList = dauMapper.getIntoEfPeople(dateStart,dateEnd,deviceNumber);
        return dauHourCountList;
    }

    @Override
    public Map getNationalTaskCount(String dateStart, String dateEnd) {
        Map nationalTaskCount = dauMapper.getNationalTaskCount(dateStart, dateEnd);

        return nationalTaskCount;
    }

    @Override
    public List<Map> getElectronicFenceGqrwIn(String dateStart, String dateEnd) {
        List<Map> nationalTaskCountList = dauMapper.getElectronicFenceGqrwIn(dateStart,dateEnd);
        return nationalTaskCountList;
    }
    @Override
    public List<Map> getElectronicFenceGqrwOut(String dateStart, String dateEnd) {
        List<Map> nationalTaskCountOutList = dauMapper.getElectronicFenceGqrwOut(dateStart,dateEnd);
        return nationalTaskCountOutList;
    }

    @Override
    public List<Map> getNationalTaskShowOnMap(String dateStart, String dateEnd) {
        List<Map> nationalTaskShowOnMap = dauMapper.getNationalTaskShowOnMap(dateStart,dateEnd);
        return nationalTaskShowOnMap;
    }
}
