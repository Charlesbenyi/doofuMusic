package com.kerwin.server.server.interfaces.users;

import com.kerwin.server.pojo.Shoucang;
import com.kerwin.server.pojo.User;
import com.kerwin.server.utils.APIRequest;


public interface UserServer {
    /*public APIRequest querybysexandadd(Integer indexpage,String sex,String address);*/
    public APIRequest querysingerbyname(Integer indexpage,String singername);
    public APIRequest querysingerbyid(String singerid);

    public APIRequest querysongsbysingerid(Integer indexpage,String singerId);
    public APIRequest querysongsbysongname(String songname);
    public APIRequest querysongsbyaddress();
    public APIRequest querysingersix();

    /*11111111111*/
    /*用户根据账号密码查询登录*/
    public APIRequest userlogin(String accounts, String userpwd);

    /*管理员根据账号密码查询登录*/
    public APIRequest adminlogin(String accounts,String userpwd);

    /*根据发布时间顺序查询*/
    public APIRequest newsongs();

    /*根据id查询歌手*/
    public APIRequest selectsingerbyid(int singerid);

    /*根据用户id查询用户信息*/
    public APIRequest selectuserbyuserid(int  userid);

    /*收藏*/
    public APIRequest shoucang(Shoucang shoucang);


    public APIRequest queryalbumbyalbumid(String albumid);
    public APIRequest querysongsbyalbumid(Integer indexpage,String albumid );

    public APIRequest queryalbum(Integer indexpage);

    public APIRequest queryalbumbyname(Integer indexpage,String albumname);

    public APIRequest querymysongslist(Integer indexpage, int userid);

    public APIRequest userinfoupdate(User user);

}
