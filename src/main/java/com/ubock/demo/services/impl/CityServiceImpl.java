package com.ubock.demo.services.impl;

import com.ubock.demo.dao.CityDao;
import com.ubock.demo.model.entity.City;
import com.ubock.demo.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    public List<City> findAllCity(){
        return cityDao.findAllCity();
    }

    public City findCityById(Long id) {
        return cityDao.findById(id);
    }

    @Override
    public String saveCity(City city) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        long ret = cityDao.saveCity(city);
        if (ret > 0){
            json.append(String.format("\"code\":%d,", 0));
            json.append("\"message\":\"添加成功\"");
        } else {
            json.append(String.format("\"code\":%d,", 1));
            json.append("\"message\":\"添加失败\"");
        }
        json.append("}");
        return json.toString();
    }

    @Override
    public Long updateCity(City city) {
        return cityDao.updateCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        return cityDao.deleteCity(id);
    }
}
