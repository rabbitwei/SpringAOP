package cn.rabbit.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
    public void add() {
        System.out.println("添加用户成功");
    }
}
