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
