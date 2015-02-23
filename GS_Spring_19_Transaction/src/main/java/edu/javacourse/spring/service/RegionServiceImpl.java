package edu.javacourse.spring.service;

import edu.javacourse.spring.dao.RegionDao;
import edu.javacourse.spring.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: Georgy Gobozov
 * Date: 21.07.13
 */
//http://www.tutorialspoint.com/spring/spring_transaction_management.htm
@Transactional
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionDao regionDao;

    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }

    @Override
    @Transactional
    public Region createRegion(Region region) {
        if (regionDao.getRegionByName(region.getName()) != null)
            throw new IllegalArgumentException("Region with given name already exists");
        int id = regionDao.createRegion(region);
        System.out.println("Region " + id + " : " + region.getName() + " created...");
        return region;
    }

    @Override
    public void deleteRegion(Region region) {
        regionDao.deleteRegion(region);
        System.out.println("Region " + region.getName() + " deleted...");
    }

    @Override
    @Transactional
    public Region getRegionByName(String name) {
        return regionDao.getRegionByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public void readOnly(String name) {
        // write operation
        int id = regionDao.createRegion((new Region(name)));
        System.out.println("id = " + id);
        //read operation
        getRegionByName(name);
    }

}
