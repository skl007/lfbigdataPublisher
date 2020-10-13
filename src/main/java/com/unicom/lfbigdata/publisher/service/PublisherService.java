package com.unicom.lfbigdata.publisher.service;

import java.util.List;
import java.util.Map;

public interface PublisherService {

    public Long getDauTotal(String date);

    public List<Map> getDauHourCount(String date);

    public List<Map> getIntoElectronicFence(String dateStart,String dateEnd);

    public List<Map> getIntoEfPeople(String dateStart,String dateEnd,String deviceNumber);

    public Map getNationalTaskCount(String dateStart,String dateEnd);

    /**
     * 查询某一时间范围，进入国庆任务的电子围栏的人员详单（不去重）
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getElectronicFenceGqrwIn(String dateStart,String dateEnd);

    public List<Map> getElectronicFenceGqrwOut(String dateStart,String dateEnd);

    public List<Map> getNationalTaskShowOnMap(String dateStart,String dateEnd);
}
