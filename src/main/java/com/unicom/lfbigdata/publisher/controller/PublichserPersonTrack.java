package com.unicom.lfbigdata.publisher.controller;

import com.alibaba.fastjson.JSON;
import com.unicom.lfbigdata.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class PublichserPersonTrack {

    @Autowired
    PublisherService publisherService;

    /**
     * 联通总部数据支撑的人员轨迹接口：查询某一时间范围，某一手机号，对应的人员轨迹信息(不去重)
     * @param dateStart
     * @param dateEnd
     * @param deviceNumber
     * @return
     */
    @GetMapping("bigdata/unicom-header/person-track/total")
    public String getUnicomHeaderPersonTrack(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd, @RequestParam("deviceNumber") String deviceNumber){
        List<Map> personTrack = publisherService.getUnicomHeaderPersonTrack(dateStart, dateEnd, deviceNumber);
        ArrayList<Map> totalPersonTrack = new ArrayList<>();
        Iterator<Map> iterator = personTrack.iterator();

        while (iterator.hasNext()) {
            Map obj = iterator.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重新解析字符串，将时间类型改为字符串类型
            String device_number = (String) obj.get("deviceNumber");
            String lac = (String) obj.get("lac");
            String ci = (String) obj.get("ci");
            Date activeTime = (Date) obj.get("activeTime");
            String prov_desc = (String) obj.get("provDesc");
            String area_desc = (String) obj.get("areaDesc");
            String district_desc = (String) obj.get("districtDesc");
            String base_station = (String) obj.get("baseStation");
            String lat = (String) obj.get("lat");
            String lon = (String) obj.get("lon");
            String lac_ci = (String) obj.get("lacCi");

            Map model = new HashMap();
            model.put("device_number", device_number);
            model.put("lac", lac);
            model.put("ci", ci);
            model.put("active_time",dateFormat.format(activeTime));
            model.put("prov_desc", prov_desc);
            model.put("area_desc", area_desc);
            model.put("district_desc", district_desc);
            model.put("base_station", base_station);
            model.put("lat", lat);
            model.put("lon", lon);
            model.put("lac_ci", lac_ci);

            totalPersonTrack.add(model);
        }

        return JSON.toJSONString(totalPersonTrack);
    }

    /**
     * 联通总部数据支撑的,利用人员轨迹模拟电子围栏接口：查询某一时间范围，围栏内部和围栏外部白名单所有人员的数据，且只要最新的一次报警(即去重)
     * @param dateStart
     * @param dateEnd
     * @return
     */
    @GetMapping("bigdata/unicom-header/fence-on-map/distinct")
    public String getUnicomHeaderFenceMapDistinct(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd){
        List<Map> fenceOnMapDistinct = publisherService.getUnicomHeaderFenceMapDistinct(dateStart,dateEnd);
        ArrayList<Map> totalList = new ArrayList<>();
        Iterator<Map> iterator = fenceOnMapDistinct.iterator();

        while (iterator.hasNext()) {
            Map obj = iterator.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重新解析字符串，将时间类型改为字符串类型
            String device_number = (String) obj.get("deviceNumber");
            String lac = (String) obj.get("lac");
            String ci = (String) obj.get("ci");
            Date activeTime = (Date) obj.get("activeTime");
            String insertTimeCH = (String) obj.get("insertTimeCH");
            String provDesc = (String) obj.get("provDesc");
            String areaDesc = (String) obj.get("areaDesc");
            String districtDesc = (String) obj.get("districtDesc");
            String baseStation = (String) obj.get("baseStation");
            String lat = (String) obj.get("lat");
            String lon = (String) obj.get("lon");
            String lac_ci = (String) obj.get("lacCi");

            Map model = new HashMap();
            model.put("device_number", device_number);
            model.put("lac", lac);
            model.put("ci", ci);
            model.put("insert_time_ch", insertTimeCH);
            model.put("active_time",dateFormat.format(activeTime));
            model.put("prov_desc", provDesc);
            model.put("area_desc", areaDesc);
            model.put("district_desc", districtDesc);
            model.put("base_station", baseStation);
            model.put("lat", lat);
            model.put("lon", lon);
            model.put("lac_ci", lac_ci);

            totalList.add(model);
        }

        return JSON.toJSONString(totalList);
    }



    /**
     * 利用人员轨迹模拟电子围栏接口：查询某一时间范围，围栏内部和围栏外部白名单所有人员的数据(不去重)
     * @param dateStart
     * @param dateEnd
     * @return
     */
    @GetMapping("bigdata/unicom-header/fence-on-map/all")
    public String getUnicomHeaderFenceMapAll(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd){
        List<Map> fenceOnMapAll = publisherService.getUnicomHeaderFenceOnMapAll(dateStart,dateEnd);
        ArrayList<Map> totalList = new ArrayList<>();
        Iterator<Map> iterator = fenceOnMapAll.iterator();

        while (iterator.hasNext()) {
            Map obj = iterator.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重新解析字符串，将时间类型改为字符串类型
            String device_number = (String) obj.get("deviceNumber");
            String lac = (String) obj.get("lac");
            String ci = (String) obj.get("ci");
            Date activeTime = (Date) obj.get("activeTime");
            String insertTimeCH = (String) obj.get("insertTimeCH");
            String provDesc = (String) obj.get("provDesc");
            String areaDesc = (String) obj.get("areaDesc");
            String districtDesc = (String) obj.get("districtDesc");
            String baseStation = (String) obj.get("baseStation");
            String lat = (String) obj.get("lat");
            String lon = (String) obj.get("lon");
            String lac_ci = (String) obj.get("lacCi");

            Map model = new HashMap();
            model.put("device_number", device_number);
            model.put("lac", lac);
            model.put("ci", ci);
            model.put("insert_time_ch", insertTimeCH);
            model.put("active_time",dateFormat.format(activeTime));
            model.put("prov_desc", provDesc);
            model.put("area_desc", areaDesc);
            model.put("district_desc", districtDesc);
            model.put("base_station", baseStation);
            model.put("lat", lat);
            model.put("lon", lon);
            model.put("lac_ci", lac_ci);


            totalList.add(model);
        }

        return JSON.toJSONString(totalList);
    }

}
