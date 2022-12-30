package com.itheima.service;

import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface BrandService {
    List<Brand> selectAll();
    void add(Brand brand);
    Brand selectById(int id);
    void update(Brand brand);
    void deleteById(int id);
    void deleteByIds(int[] ids);
    PageBean<Brand> selectByPage(int currentPage, int pageSize);
    PageBean<Brand> selectByConditionAndPage(int currentPage, int pageSize, Brand brand);

}
