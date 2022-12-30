package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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

    /**
     * delete the brand info in present row
     * @param id: id of brand to be deleted
     */
    void deleteById(int id);

    /**
     * delete selected brands in checkboxes
     * @param ids: ids of checked brands to be deleted
     */
    void deleteByIds(@Param("ids")int[] ids);

    /**
     * select brand info in pages
     * @param begin: select brands from begin page
     * @param size: set the number of brand info in one page
     * @return return selected info
     */
    List<Brand> selectByPage(@Param("begin") int begin, @Param("size")int size);

    /**
     * get total number of brand info
     * @return total number of brand info
     */
    //@Select("select count(*) from tb_brand")
    int selectTotalCount();

    /**
     * select by condition and pages
     * @param begin: select brands from begin page
     * @param size: set the number of brand info in one page
     * @param brand: the condition of brand
     * @return a list of brand
     */
    List<Brand> selectByConditionAndPage(@Param("begin")int begin, @Param("size")int size, @Param("brand")Brand brand);

    int selectTotalCountByCondition(Brand brand);
}
