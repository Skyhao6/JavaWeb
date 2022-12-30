package com.itheima.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itheima.pojo.Brand;
import com.itheima.pojo.PageBean;
import com.itheima.service.BrandService;
import com.itheima.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();

        // turn list to json
        String jsonString = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String jsonString = br.readLine();
        Brand brand = JSON.parseObject(jsonString, Brand.class);
        brandService.add(brand);
        response.getWriter().write("success");
    }

    public void selectById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String brandInfo = br.readLine();
        Brand brand = JSON.parseObject(brandInfo, Brand.class);
        System.out.println(brand);
        String brandJSON = JSON.toJSONString(brand);
        response.getWriter().write(brandJSON);
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String jsonString = br.readLine();
        Brand brand = JSON.parseObject(jsonString, Brand.class);
        brandService.update(brand);
        response.getWriter().write("success");
    }

    public void deleteById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String jsonString = br.readLine();
        Brand brand = JSON.parseObject(jsonString, Brand.class);
        brandService.deleteById(brand.getId());
        response.getWriter().write("success");
    }
    public void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String jsonString = br.readLine();
        int[] ids = JSON.parseObject(jsonString, int[].class);
        for (int id :
                ids) {
            System.out.println(id + ",");
        }
        brandService.deleteByIds(ids);
        response.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        // turn list to json
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void selectByConditionAndPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _currentPage = request.getParameter("currentPage");
        String _pageSize = request.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        BufferedReader br = request.getReader();
        String brandJSON = br.readLine();
        Brand brand = JSON.parseObject(brandJSON, Brand.class);
        PageBean<Brand> pageBean = brandService.selectByConditionAndPage(currentPage, pageSize, brand);

        // turn list to json
        String jsonString = JSON.toJSONString(pageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
