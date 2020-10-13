package com.unicom.lfbigdata.publisher.mapper;

import java.util.List;
import java.util.Map;

public interface DauMapper {

    public Long getDauTotal(String date);

    public List<Map> getDauHourCount(String date);

    /**
     * 查询某一时间范围，进入国庆任务的电子围栏的总报警人数（手机号去重）和总报警次数（手机号不去重）
     * @param dateStart  开始时间
     * @param dateEnd 结束时间
     * @return
     */
    public Map getNationalTaskCount(String dateStart,String dateEnd);

    /**
     * 查询某一时间范围，进入国庆任务的电子围栏内部的人员详单（不去重）
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getElectronicFenceGqrwIn(String dateStart,String dateEnd);

    /**
     * 查询某一时间范围，进入国庆任务的电子围栏外围的人员详单（不去重）
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getElectronicFenceGqrwOut(String dateStart,String dateEnd);


    /**
     * 国庆任务地图展示：围栏内部和围栏外部数据
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getNationalTaskShowOnMap(String dateStart,String dateEnd);


    /**
     * 查询某一时间范围、最新一次，进入电子围栏的设备信息
     * @param dateStart 开始时间
     * @param dateEnd   结束时间
     * @return
     */
    public List<Map> getIntoElectronicFence(String dateStart,String dateEnd);

    /**
     * 查询某一时间范围、某一手机号、最新一次，进入电子围栏的设备信息
     * @param dateStart
     * @param dateEnd
     * @param deviceNumber
     * @return
     */
    public List<Map> getIntoEfPeople(String dateStart,String dateEnd,String deviceNumber);


}
