package cn.rabbit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO implements  IProduct {

    @Override
    public void add() {
        System.out.println("添加产品成功");
    }
}
