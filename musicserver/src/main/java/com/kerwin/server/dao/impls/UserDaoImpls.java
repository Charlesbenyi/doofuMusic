package com.kerwin.server.dao.impls;

import com.kerwin.server.dao.interfaces.users.UserDao;
import com.kerwin.server.pojo.Shoucang;
import jdbc2.JDBCUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImpls implements UserDao {

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

    @Override
    public <T> List<T> query(Class<T> T, String sql, List<Object> params) {
        List<T> data = new ArrayList<T>();
        JDBCUtil util = new JDBCUtil();
        data = util.executeQuery(sql,params,T);
        return data;
    }


    public Integer count(String sql, List<Object> params) {
        JDBCUtil util = new JDBCUtil();
        Integer data = util.executeQueryOnly(sql,params);
        return data;
    }

    @Override
    public int shoucang(Shoucang shoucang) {
        JDBCUtil util = new JDBCUtil();
        int data=util.add(shoucang);
        return data;
    }

    @Override
    public int delete(String sql, List<Object> params) {
        JDBCUtil util = new JDBCUtil();
        int data=util.executeUpdate(sql,params);
        return data;
    }

    @Override
    public int update(String sql, List<Object> params) {
        JDBCUtil util = new JDBCUtil();
        int data=util.executeUpdate(sql,params);
        return data;
    }


    @Override
    public <T> T query(Class<T> T, String sql, Object id) {
        return null;
    }

}
