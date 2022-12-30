package com.itheima.mapper;

import com.itheima.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /**
     *
     * @return return all the info of brand from tb_brand
     */
    List<Brand> selectAll();

    /**
     * Add a new line brand data into tb_brand
     * @param brand: info of brand to be added
     */
    void add(Brand brand);

    /**
     * update a line brand data
     * @param brand: info of brand to be modified
     */
    void update(Brand brand);
    Brand selectById(int id);

}
