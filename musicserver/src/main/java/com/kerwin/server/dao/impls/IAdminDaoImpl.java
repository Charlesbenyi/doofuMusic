package com.kerwin.server.dao.impls;

import com.kerwin.server.dao.interfaces.admin.IAdminDao;
import com.kerwin.server.pojo.User;
import jdbc2.JDBCUtil;
import java.util.ArrayList;
import java.util.List;

public class IAdminDaoImpl implements IAdminDao {
    @Override
    public <T> List<T> query(Class<T> clazz, int indexpage, String sql, List<Object> params) {
        return null;
    }

    @Override
    public boolean add() {
        return false;
    }

    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }

    /* 查询所有用户*/
    @Override
    public <T> List<T> query(Class<T> T, String sql, List<Object> params) {
        List<T> data=new ArrayList();
        JDBCUtil jdbcUtil= new JDBCUtil();
        data=jdbcUtil.executeQuery(sql,params,T);
        return data;
    }

    /*查询用户的总记录条数*/
    @Override
    public Integer count(String sql, List<Object> params) {
        JDBCUtil util = new JDBCUtil();
        Integer data = util.executeQueryOnly(sql,params);
        return data;
    }

    /* 根据id删除该记录*/
    @Override
    public int deleteByid(String sql, List<Object> params) {
        JDBCUtil util = new JDBCUtil();
        int data=util.executeUpdate(sql,params);
        return data;
    }

    /*更新一条记录*/
    @Override
    public int update(String sql, List<Object> params) {
        JDBCUtil util = new JDBCUtil();
        int data=util.executeUpdate(sql,params);
        return data;
    }

    /*增加用户*/
    @Override
    public int addUser(User user) {
        JDBCUtil util = new JDBCUtil();
        int data=util.add(user);
        return data;
    }

    @Override
    public <T> T query(Class<T> T, String sql, Object id) {
        return null;
    }
}
