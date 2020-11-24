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
}
