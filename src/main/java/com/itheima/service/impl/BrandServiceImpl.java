package com.itheima.service.impl;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    @Override
    public List<Brand> selectAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        sqlSession.close();
        return brands;
    }

    @Override
    public void add(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.add(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public Brand selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        sqlSession.commit();
        sqlSession.close();
        return brand;
    }

    @Override
    public void update(Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int curPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (curPage - 1) * pageSize;
        int size = pageSize;

        //selectTotalCount返回值是Integer，不能用brandResultMap接收
        List<Brand> rows = brandMapper.selectByPage(begin, size);
        int selectTotalCount = brandMapper.selectTotalCount();

        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(selectTotalCount);

        sqlSession.close();
        return brandPageBean;
    }

    @Override
    public PageBean<Brand> selectByConditionAndPage(int currentPage, int pageSize, Brand brand) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        //selectTotalCount返回值是Integer，不能用brandResultMap接收
        List<Brand> rows = brandMapper.selectByConditionAndPage(begin, size, brand);
        int selectTotalCount = brandMapper.selectTotalCountByCondition(brand);

        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(selectTotalCount);

        sqlSession.close();
        return brandPageBean;
    }
}
