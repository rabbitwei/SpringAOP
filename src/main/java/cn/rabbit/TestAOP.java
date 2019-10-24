package cn.rabbit;

import cn.rabbit.dao.IProduct;
import cn.rabbit.dao.ProductDAO;
import cn.rabbit.dao.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
    public static  void main(String[] args) {
        //注意：applicationContext.xml 文件需要在 resources 目录下， 并且设置为 Resources Root
        String resources = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //测试的是ProductDao有IProduct接口，内部使用的是动态代理
        IProduct product = (IProduct) ac.getBean("productDAO");
        System.out.println(product.getClass());
        product.add();

        System.out.println("============================================");
        //没有接口使用的是 cglib 代理
        UserDAO userDAO = (UserDAO) ac.getBean("userDAO");
        System.out.println(userDAO.getClass());
        userDAO.add();



    }
}
