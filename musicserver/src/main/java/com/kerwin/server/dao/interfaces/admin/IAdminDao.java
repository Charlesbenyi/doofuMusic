package com.kerwin.server.dao.interfaces.admin;

import com.kerwin.server.dao.IDao;
import com.kerwin.server.pojo.User;

import java.util.List;

public interface IAdminDao extends IDao {

   /* 分页显示列表*/
    public <T> List<T> query(Class<T> clazz,int indexpage,String sql,List<Object> params);
    public Integer count(String sql, List<Object> params);

    /*根据id删除该记录*/
    public int deleteByid(String sql, List<Object> params);

    /*更新一条记录*/
    public int update(String sql, List<Object> params);

    /*增加一个用户*/
    public int addUser(User user);

}
