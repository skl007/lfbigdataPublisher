package com.unicom.lfbigdata.publisher.mapper;

import java.util.List;
import java.util.Map;

public interface DauMapper {

    /**
     * 查询某一时间范围，进入国庆任务的电子围栏的总报警人数（手机号去重）和总报警次数（手机号不去重）
     * @param dateStart  开始时间
     * @param dateEnd 结束时间
     * @return
     */
    public Map getNationalTaskCount(String dateStart,String dateEnd);

    /**
     * 查询某一时间范围，国庆围栏任务，内部围栏(小围栏)人员设备信息
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getElectronicFenceGqrwIn(String dateStart,String dateEnd);

    /**
     * 查询某一时间范围，国庆围栏任务，外部围栏(大围栏)人员设备信息
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getElectronicFenceGqrwOut(String dateStart,String dateEnd);

    /**
     * 国庆任务地图展示：国庆任务地图展示：围栏内部和围栏外部数据，且只要最新的一次报警：从未进过小围栏的和进大围栏时间较新的 + 即在大围栏里，也在小围栏里，小围栏里的时间是新的
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getNationalTaskShowOnMap(String dateStart,String dateEnd);

    /**
     * 人员轨迹：查询某一时间范围，某一手机号，对应的人员轨迹信息(不去重)
     * @param dateStart
     * @param dateEnd
     * @param deviceNumber
     * @return
     */
    public List<Map> getPersonTrack(String dateStart,String dateEnd,String deviceNumber);

    /**
     * 联通总部数据支撑的人员轨迹：查询某一时间范围，某一手机号，对应的人员轨迹信息(不去重)
     * @param dateStart
     * @param dateEnd
     * @param deviceNumber
     * @return
     */
    public List<Map> getUnicomHeaderPersonTrack(String dateStart,String dateEnd,String deviceNumber);
    /**
     * 2G 3G 4G基站数据全量导出
     * @return
     */
    public List<Map> getBaseStation();

    /**
     * 利用人员轨迹模拟电子围栏：查询某一时间范围，围栏内部和围栏外部白名单所有人员的数据，且只要最新的一次报警(即去重)
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getFenceOnMapDistinct(String dateStart,String dateEnd);

    /**
     * 联通总部数据支撑的利用人员轨迹模拟电子围栏：查询某一时间范围，围栏内部和围栏外部白名单所有人员的数据，且只要最新的一次报警(即去重)
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getUnicomHeaderFenceMapDistinct(String dateStart,String dateEnd,Integer pageIndex,Integer pageSize);

    /**
     * 利用人员轨迹模拟电子围栏：查询某一时间范围，围栏内部和围栏外部白名单所有人员的数据(不去重)
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getFenceOnMapAll(String dateStart,String dateEnd);

    /**
     * 联通总部数据支撑的利用人员轨迹模拟电子围栏：查询某一时间范围，围栏内部和围栏外部白名单所有人员的数据(不去重)
     * @param dateStart
     * @param dateEnd
     * @return
     */
    public List<Map> getUnicomHeaderFenceOnMapAll(String dateStart,String dateEnd,Integer pageIndex,Integer pageSize);
}
