package com.kerwin.server.server.interfaces.admin;

import com.kerwin.server.pojo.User;
import com.kerwin.server.utils.APIRequest;

import java.util.List;

public interface AdminServer {
    /*分页显示所有用户*/
    public APIRequest query(Integer indexpage,String uname);

    /*根据userid删除该用户*/
    public APIRequest deleteByUserid(int userid);

    /*增加一个用户*/
    public APIRequest addUser(User user);

    /*根据id查询用户*/
    public APIRequest selectUserByid(int userid);

    /*根据id修改用户*/
    public APIRequest editoruser(User user);

    /*分页显示所有歌曲*/
    public APIRequest querysong(Integer indexpage,String usongname);

    /*根据songid删除该歌曲*/
    public APIRequest deletesong(int songid);

    /*分页显示所有歌手*/
    public APIRequest querysinger(Integer indexpage,String usingername);

    /*删除歌手及歌手下所有的歌曲和专辑*/
    public APIRequest deletesinger(int singerid);

    /*分页显示所以专辑*/
    public APIRequest queryalbum(Integer indexpage,String ualbumname);

    /*删除专辑及专辑下的所有歌曲*/
    public APIRequest deletealbum(int albumid);


}
