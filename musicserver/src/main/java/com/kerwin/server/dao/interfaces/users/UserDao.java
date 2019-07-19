package com.kerwin.server.dao.interfaces.users;

import com.kerwin.server.dao.IDao;
import com.kerwin.server.pojo.Shoucang;

import java.util.List;

public interface UserDao extends IDao {

    public <T> List<T> query(Class<T> clazz,int indexpage,String sql,List<Object> params);
    public Integer count(String sql, List<Object> params);

    /*收藏*/
    public int shoucang(Shoucang shoucang );

    /*删除该记录*/
    public int delete(String sql, List<Object> params);

    /*更新一条记录*/
    public int update(String sql, List<Object> params);





}
