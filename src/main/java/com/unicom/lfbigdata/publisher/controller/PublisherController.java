package com.unicom.lfbigdata.publisher.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unicom.lfbigdata.publisher.service.PublisherService;
import com.unicom.lfbigdata.publisher.util.DateUtil;
import com.unicom.lfbigdata.publisher.util.ParseJsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;


@RestController
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    /*@GetMapping("realtime-total")
    public String getTotal(@RequestParam("date") String date) {
        Long dauTotal = publisherService.getDauTotal(date);
        List<Map> totalList = new ArrayList<>();
        Map dauMap = new HashMap();
        dauMap.put("id", "tt");
        dauMap.put("name", "测试");
        dauMap.put("value", dauTotal);
        totalList.add(dauMap);

        Map newMidMap = new HashMap();
        newMidMap.put("id", "new_mid");
        newMidMap.put("name", "测试2");
        newMidMap.put("value", 33333);
        totalList.add(newMidMap);

        return JSON.toJSONString(totalList);
    }

    @GetMapping("electronicFence-total")
    public String getRealtimeHour(@RequestParam("date") String date) {
        return null;
    }*/

    /*
     * 查询某一时间范围，进入国庆任务的电子围栏的总报警人数（手机号去重）和总报警次数（手机号不去重）
     **/
    @GetMapping("nationaltask-alarm-total")
    public String getAlarmTotalCount(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd) {
        Map intoElectronicFenceMap = publisherService.getNationalTaskCount(dateStart, dateEnd);

        Map model = new HashMap();
        if (!intoElectronicFenceMap.isEmpty()) {
            String alarmTotalcountDis = intoElectronicFenceMap.get("alarmTotalcountDis") + "";
            String alarmTotalcount = intoElectronicFenceMap.get("alarmTotalcount") + "";
            model.put("taskName", "国庆任务");
            model.put("monitoringTotalCount", "30");
            model.put("alarmTotalcountDis", alarmTotalcountDis);
            model.put("alarmTotalcount", alarmTotalcount);
        }
        return JSON.toJSONString(model);
    }


    /*
     * 国庆任务围栏内部详单数据
     * */
    @GetMapping("nationaltask-alarm-list-in")
    public String getNationaltaskListIn(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd) {
        List<Map> intoElectronicFenceMap = publisherService.getElectronicFenceGqrwIn(dateStart, dateEnd);
        List<Map> totalList = new ArrayList<>();
        Iterator<Map> iterator = intoElectronicFenceMap.iterator();
        while (iterator.hasNext()) {
            Map obj = iterator.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重新解析字符串，将时间类型改为字符串类型
            String device_number = (String) obj.get("deviceNumber");
            Date time = (Date) obj.get("time");
            String imei = (String) obj.get("imei");
            String imsi = (String) obj.get("imsi");
            String lac = (String) obj.get("lac");
            String ci = (String) obj.get("ci");
            String longitude = (String) obj.get("longitude");
            String latitude = (String) obj.get("latitude");
            String prov_id = (String) obj.get("provId");
            Date inTime = (Date) obj.get("inTime");
            String data_source = (String) obj.get("data_source");
            String city_id = (String) obj.get("cityId");
            String area_id = (String) obj.get("areaId");
            String topic_name = (String) obj.get("topicName");
            String task_name = "国庆任务";

            Map model = new HashMap();
            model.put("device_number", device_number);
            model.put("time", dateFormat.format(time));
            model.put("imei", imei);
            model.put("imsi", imsi);
            model.put("lac", lac);
            model.put("ci", ci);
            model.put("longitude", longitude);
            model.put("latitude", latitude);
            model.put("prov_id", prov_id);
            model.put("in_time", dateFormat.format(inTime));
            model.put("data_source", data_source);
            model.put("city_id", city_id);
            model.put("area_id", area_id);
            model.put("topic_name", topic_name);
            model.put("task_name", task_name);

            totalList.add(model);
        }

        return JSON.toJSONString(totalList);
    }

    /*
     * 国庆任务围栏外部详单数据（大围栏）
     * */
    @GetMapping("nationaltask-alarm-list-out")
    public String getNationaltaskListOut(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd) {
        List<Map> intoElectronicFenceMap = publisherService.getElectronicFenceGqrwOut(dateStart, dateEnd);
        List<Map> totalList = new ArrayList<>();
        Iterator<Map> iterator = intoElectronicFenceMap.iterator();

        while (iterator.hasNext()) {
            Map obj = iterator.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重新解析字符串，将时间类型改为字符串类型
            String device_number = (String) obj.get("deviceNumber");
            Date time = (Date) obj.get("time");
            String imei = (String) obj.get("imei");
            String imsi = (String) obj.get("imsi");
            String lac = (String) obj.get("lac");
            String ci = (String) obj.get("ci");
            String longitude = (String) obj.get("longitude");
            String latitude = (String) obj.get("latitude");
            String prov_id = (String) obj.get("provId");
            Date inTime = (Date) obj.get("inTime");
            String data_source = (String) obj.get("data_source");
            String city_id = (String) obj.get("cityId");
            String area_id = (String) obj.get("areaId");
            String topic_name = (String) obj.get("topicName");
            String task_name = "国庆任务";

            Map model = new HashMap();
            model.put("device_number", device_number);
            model.put("time", dateFormat.format(time));
            model.put("imei", imei);
            model.put("imsi", imsi);
            model.put("lac", lac);
            model.put("ci", ci);
            model.put("longitude", longitude);
            model.put("latitude", latitude);
            model.put("prov_id", prov_id);
            model.put("in_time", dateFormat.format(inTime));
            model.put("data_source", data_source);
            model.put("city_id", city_id);
            model.put("area_id", area_id);
            model.put("topic_name", topic_name);
            model.put("task_name", task_name);

            totalList.add(model);
        }

        return JSON.toJSONString(totalList);
    }

    /*
     * 国庆任务地图展示：查询某一时间范围（同一手机号码只取最新一次的），进入国庆围栏内部和国庆围栏外围的list
     * */
    @GetMapping("nationaltask-alarm-list-map")
    public String getNationaltaskListMap(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd) {
        List<Map> intoElectronicFenceMap = publisherService.getNationalTaskShowOnMap(dateStart, dateEnd);
        List<Map> totalList = new ArrayList<>();
        Iterator<Map> iterator = intoElectronicFenceMap.iterator();

        while (iterator.hasNext()) {
            Map obj = iterator.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重新解析字符串，将时间类型改为字符串类型
            String device_number = (String) obj.get("deviceNumber");
            Date time = (Date) obj.get("time");
            String longitude = (String) obj.get("longitude");
            String latitude = (String) obj.get("latitude");
            Date inTime = (Date) obj.get("inTime");
            String topic_name = (String) obj.get("topicName");
            String task_name = "国庆任务";
            String fence_in_out = (String) obj.get("fenceInOut");

            Map model = new HashMap();
            model.put("device_number", device_number);
            model.put("time", dateFormat.format(time));
            model.put("longitude", longitude);
            model.put("latitude", latitude);
            model.put("in_time", dateFormat.format(inTime));
            model.put("topic_name", topic_name);
            model.put("task_name", task_name);
            model.put("fence_in_out", fence_in_out);

            totalList.add(model);
        }

        return JSON.toJSONString(totalList);
    }

   /* @GetMapping("into-electronicFence")
    public String getRealTimElectronicFence(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd) {
        List<Map> intoElectronicFenceMap = publisherService.getIntoElectronicFence(dateStart, dateEnd);
        List<Map> totalList = new ArrayList<>();
        Iterator<Map> iterator = intoElectronicFenceMap.iterator();

        while (iterator.hasNext()) {
            Map obj = iterator.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重新解析字符串，将时间类型改为字符串类型
            String device_number = (String) obj.get("deviceNumber");
            Date time = (Date) obj.get("time");
            String imei = (String) obj.get("imei");
            String imsi = (String) obj.get("imsi");
            String lac = (String) obj.get("lac");
            String ci = (String) obj.get("ci");
            String longitude = (String) obj.get("longitude");
            String latitude = (String) obj.get("latitude");
            String prov_id = (String) obj.get("provId");
            Date inTime = (Date) obj.get("inTime");
            String data_source = (String) obj.get("data_source");
            String city_id = (String) obj.get("cityId");
            String area_id = (String) obj.get("areaId");

            Map model = new HashMap();
            model.put("device_number", device_number);
            model.put("time", dateFormat.format(time));
            model.put("imei", imei);
            model.put("imsi", imsi);
            model.put("lac", lac);
            model.put("ci", ci);
            model.put("longitude", longitude);
            model.put("latitude", latitude);
            model.put("prov_id", prov_id);
            model.put("inTime", dateFormat.format(inTime));
            model.put("data_source", data_source);
            model.put("city_id", city_id);
            model.put("area_id", area_id);

            totalList.add(model);
        }

        return JSON.toJSONString(totalList);
    }


    @GetMapping("into-ef-people")
    public String getRealTimEfPeople(@RequestParam("dateStart") String dateStart, @RequestParam("dateEnd") String dateEnd, @RequestParam("deviceNumber") String deviceNumber) {
        List<Map> intoElectronicFenceMap = publisherService.getIntoEfPeople(dateStart, dateEnd, deviceNumber);
        List<Map> totalList = new ArrayList<>();
        Iterator<Map> iterator = intoElectronicFenceMap.iterator();

        while (iterator.hasNext()) {
            Map obj = iterator.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //重新解析字符串，将时间类型改为字符串类型
            String device_number = (String) obj.get("deviceNumber");
            Date time = (Date) obj.get("time");
            String imei = (String) obj.get("imei");
            String imsi = (String) obj.get("imsi");
            String lac = (String) obj.get("lac");
            String ci = (String) obj.get("ci");
            String longitude = (String) obj.get("longitude");
            String latitude = (String) obj.get("latitude");
            String prov_id = (String) obj.get("provId");
            Date inTime = (Date) obj.get("inTime");
            String data_source = (String) obj.get("data_source");
            String city_id = (String) obj.get("cityId");
            String area_id = (String) obj.get("areaId");

            Map model = new HashMap();
            model.put("device_number", device_number);
            model.put("time", dateFormat.format(time));
            model.put("imei", imei);
            model.put("imsi", imsi);
            model.put("lac", lac);
            model.put("ci", ci);
            model.put("longitude", longitude);
            model.put("latitude", latitude);
            model.put("prov_id", prov_id);
            model.put("inTime", dateFormat.format(inTime));
            model.put("data_source", data_source);
            model.put("city_id", city_id);
            model.put("area_id", area_id);

            totalList.add(model);
        }

        return JSON.toJSONString(totalList);
    }*/

}
