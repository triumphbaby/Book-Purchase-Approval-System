package com.ddu.goushushenpixitong.auth.Service.impl;

import com.ddu.goushushenpixitong.auth.Service.PowerService;
import com.ddu.goushushenpixitong.auth.entity.Power;
import com.ddu.goushushenpixitong.auth.mapper.PowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther ChunKitAu
 * @create 2020-02-04 04
 */
@Service
public class PowerServiceImpl implements PowerService {

    private final static int SUCCESS = 1;

    @Autowired
    private PowerMapper powerMapper;

    @Override
    public Boolean add(Power power) {
        return powerMapper.insert(power) == SUCCESS;
    }

    @Override
    public Boolean remove(int powerId) {
        return powerMapper.deleteByPrimaryKey(powerId) == SUCCESS;
    }

    @Override
    public Boolean update(Power power) {
        return powerMapper.updateByPrimaryKey(power) == SUCCESS;
    }

    @Override
    public List<Power> findAllPower(int currentPage, int pageSize) {
        return powerMapper.selectAll();
    }

    @Override
    public Power getOne(int powerId) {
        return powerMapper.selectByPrimaryKey(powerId);
    }
}
