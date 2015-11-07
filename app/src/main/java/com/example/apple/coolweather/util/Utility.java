package com.example.apple.coolweather.util;

import android.text.TextUtils;

import com.example.apple.coolweather.model.City;
import com.example.apple.coolweather.model.CoolWeatherDB;
import com.example.apple.coolweather.model.County;
import com.example.apple.coolweather.model.Province;

/**
 * Created by apple on 15/11/6.
 */
public class Utility {
    /*
    * 该类用于解析格式为“代号|城市,代号|城市”格式的数据
    * */
    public synchronized static Boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB,String response){
        //该方法用于解析Province数据
        if (!TextUtils.isEmpty(response)){
            String[] allProvince = response.split(",");
            if(allProvince != null&& allProvince.length>0){
                for (String p : allProvince){
                    String[] array =p.split("\\|");
                    Province province = new Province();
                    province.setPrivinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }
    public synchronized static Boolean handleCityResponse(CoolWeatherDB coolWeatherDB,String response,int provinceId){
        //该方法用于解析City数据
        if (!TextUtils.isEmpty(response)){
            String[] allCity = response.split(",");
            if(allCity != null&& allCity.length>0){
                for (String c : allCity){
                    String[] array =c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    coolWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }
    public synchronized static Boolean handleCountyResponse(CoolWeatherDB coolWeatherDB,String response,int cityId){
        //该方法用于解析County数据
        if(!TextUtils.isEmpty(response)){
            String[] allCounty = response.split(",");
            if (allCounty != null&&allCounty.length>0){
                for (String c : allCounty){
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

}
