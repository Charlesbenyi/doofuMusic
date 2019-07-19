package com.kerwin.server.server.impls.admin;

import com.kerwin.server.dao.impls.IAdminDaoImpl;
import com.kerwin.server.dao.interfaces.admin.IAdminDao;
import com.kerwin.server.pojo.Album;
import com.kerwin.server.pojo.Singer;
import com.kerwin.server.pojo.Song;
import com.kerwin.server.pojo.User;
import com.kerwin.server.server.interfaces.admin.AdminServer;
import com.kerwin.server.utils.APIRequest;
import com.kerwin.server.utils.Pager;
import java.util.ArrayList;
import java.util.List;

public class AdminServerImpls implements AdminServer {

    IAdminDao dao = new IAdminDaoImpl();

    /*查询用户分页*/
    public APIRequest query(Integer indexpage,String uname){

        if(indexpage == null){
            indexpage = 1;
        }
        //3.运算结果作为参数传递
        if(uname!=""){
            String name= uname+"%";
            List params0 = new ArrayList();
            params0.add(name);
            //1.去数据库里面找你这条 sql语句所产生了多少条记录
            Integer countrows = dao.count(" select count(1) from user where username like ? ",params0);
            //2.把总记录书交给工具运算
            Pager p = new Pager(countrows,indexpage);
            String sql ="select userid,accounts,username,userpwd,sex,age,telephone,email from user where username like ? limit ?,? ";
            List params = new ArrayList();
            params.add(name);
            params.add(p.getBeginrows());
            params.add(p.getPagesize());
            //4.提取数据
            List<Object> query = dao.query(User.class, sql, params);
            //5。将数据封装到工具当中。因为，前台还需要工具的数据
            p.setData(query);
            return new APIRequest(p);
        }else{
            //1.去数据库里面找你这条 sql语句所产生了多少条记录
            Integer countrows = dao.count("select count(1) from user",null);

            //2.把总记录数交给工具运算
            Pager p = new Pager(countrows,indexpage);

            String sql ="select userid,accounts,username,userpwd,sex,age,telephone,email from user limit ?,?";
            List params = new ArrayList();
            params.add(p.getBeginrows());
            params.add(p.getPagesize());
            //4.提取数据
            List<Object> query = dao.query(User.class, sql, params);
            //5。将数据封装到工具当中。因为，前台还需要工具的数据
            p.setData(query);
            return new APIRequest(p);
        }
    }

    /*删除用户根据id*/
    @Override
    public APIRequest deleteByUserid(int userid) {
        List params = new ArrayList();
        params.add(userid);
        String sql="delete from user where userid=?";
        int a=dao.deleteByid(sql,params);
        if(a>0){
            return new APIRequest(true,"删除成功");
        }else {
            return new APIRequest(false,"删除失败");
        }
    }

    /*添加用户*/
    @Override
    public APIRequest addUser(User user) {
        List params = new ArrayList();
        params.add(user.getAccounts());
        String sql="select *from user where accounts=?";
        List<User> user1=dao.query(User.class,sql,params);

        List params1 = new ArrayList();
        params1.add(user.getTelephone());
        String sql1="select *from user where telephone=?";
        List<User> user2=dao.query(User.class,sql1,params1);


        List params2 = new ArrayList();
        params2.add(user.getEmail());
        String sql2="select *from user where email=?";
        List<User> user3=dao.query(User.class,sql2,params2);

        if(user1.size()==0){
            if(user2.size()==0){
                if(user3.size()==0){
                    int result=dao.addUser(user);
                    if(result>0){
                        return new APIRequest(true,"添加成功");
                    }else {
                        return new APIRequest(false,"添加失败");
                    }
                }else{
                    return new APIRequest(false,"邮箱已存在，添加失败");
                }
            }else{
                return new APIRequest(false,"电话号码已存在，添加失败");
            }
        }else{
            return new APIRequest(false,"用户名已存在，添加失败");
        }
    }

    /*根据用户id查询*/
    @Override
    public APIRequest selectUserByid(int userid) {
        List params = new ArrayList();
        params.add(userid);
        String sql="select *from user where userid=?";
        List<User> users=dao.query(User.class,sql,params);
        return new APIRequest(users);
    }

    /*根据userid修改用户*/
    @Override
    public APIRequest editoruser(User user) {
        List params = new ArrayList();
        params.add(user.getUsername());
        params.add(user.getSex());
        params.add(user.getAge());
        params.add(user.getTelephone());
        params.add(user.getEmail());
        params.add(user.getUserid());
        String sql="update user set username=?,sex=?,age=?,telephone=?,email=? where userid=?";
        int result=dao.update(sql,params);
        if(result>0){
            return new APIRequest(true,"修改成功");
        }else {
            return new APIRequest(false,"修改失败");
        }
    }

    /*查询所有歌曲分页*/
    @Override
    public APIRequest querysong(Integer indexpage,String usongname) {
        if(indexpage == null){
            indexpage = 1;
        }

        if (usongname != "") {
            String name= usongname+"%";
            List params0 = new ArrayList();
            params0.add(name);

            //1.去数据库里面找你这条 sql语句所产生了多少条记录
            Integer countrows = dao.count("select count(1) from songs where songname like ?",params0);

            //2.把总记录书交给工具运算
            Pager p = new Pager(countrows,indexpage);

            //3.运算结果作为参数传递
            String sql ="select songid,singerid,albumid,songname,songpic,songreleaseDate,songTimeMinutes,singername from songs "
                             + "where songname like ? limit ?,?";
            List params = new ArrayList();
            params.add(name);
            params.add(p.getBeginrows());
            params.add(p.getPagesize());
            //4.提取数据
            List<Object> query = dao.query(Song.class, sql, params);

            //5。将数据封装到工具当中。因为，前台还需要工具的数据
            p.setData(query);
            return new APIRequest(p);
        }else{
            //1.去数据库里面找你这条 sql语句所产生了多少条记录
            Integer countrows = dao.count("select count(1) from songs",null);

            //2.把总记录书交给工具运算
            Pager p = new Pager(countrows,indexpage);

            //3.运算结果作为参数传递
            String sql ="select songid,singerid,albumid,songname,songpic,songreleaseDate,songTimeMinutes,singername from songs limit ?,?";
            List params = new ArrayList();
            params.add(p.getBeginrows());
            params.add(p.getPagesize());
            //4.提取数据
            List<Object> query = dao.query(Song.class, sql, params);

            //5。将数据封装到工具当中。因为，前台还需要工具的数据
            p.setData(query);
            return new APIRequest(p);
        }
    }

    /*根据歌曲id删除该歌曲*/
    @Override
    public APIRequest deletesong(int songid) {
        List params = new ArrayList();
        params.add(songid);
        String sql="delete from songs where songid=?";
        int a=dao.deleteByid(sql,params);
        if(a>0){
            return new APIRequest(true,"删除成功");
        }else {
            return new APIRequest(false,"删除失败");
        }
    }

    /*查询歌手分页*/
    @Override
    public APIRequest querysinger(Integer indexpage,String usingername) {
        if(indexpage == null){
            indexpage = 1;
        }
        if(usingername!=""){
            String name= usingername+"%";
            List params0 = new ArrayList();
            params0.add(name);

            //1.去数据库里面找你这条 sql语句所产生了多少条记录
            Integer countrows = dao.count("select count(1) from singer where singername like ? ",params0);

            //2.把总记录书交给工具运算
            Pager p = new Pager(countrows,indexpage);

            //3.运算结果作为参数传递
            String sql ="select singerid,funsnum,singerimg,singername,englishname,sex,"
                    + "address,city,slanguage,birthday,xingzuo,height,kg from singer"
                    + " where singername like ? limit ?,?";
            List params = new ArrayList();
            params.add(name);
            params.add(p.getBeginrows());
            params.add(p.getPagesize());
            //4.提取数据
            List<Object> query = dao.query(Singer.class, sql, params);

            //5。将数据封装到工具当中。因为，前台还需要工具的数据
            p.setData(query);
            return new APIRequest(p);


        }else{
            //1.去数据库里面找你这条 sql语句所产生了多少条记录
            Integer countrows = dao.count("select count(1) from singer",null);

            //2.把总记录书交给工具运算
            Pager p = new Pager(countrows,indexpage);

            //3.运算结果作为参数传递
            String sql ="select singerid,funsnum,singerimg,singername,englishname,sex,"
                    + "address,city,slanguage,birthday,xingzuo,height,kg from singer limit ?,?";
            List params = new ArrayList();
            params.add(p.getBeginrows());
            params.add(p.getPagesize());
            //4.提取数据
            List<Object> query = dao.query(Singer.class, sql, params);

            //5。将数据封装到工具当中。因为，前台还需要工具的数据
            p.setData(query);
            return new APIRequest(p);
        }

    }

    /*删除歌手及歌手下所有的歌曲和专辑*/
    @Override
    public APIRequest deletesinger(int singerid) {
        List params = new ArrayList();
        params.add(singerid);
        params.add(singerid);
        params.add(singerid);
        String sql="delete singer,album,songs from singer,album,songs where singer.singerid=? and album.singerid=? and songs.singerid=?";
        int result=dao.deleteByid(sql,params);
        if(result>0){
            return new APIRequest(true,"该歌手及其所有专辑歌曲已删除");
        }else {
            return new APIRequest(false,"删除失败");
        }
    }

    /*查询专辑分页*/
    @Override
    public APIRequest queryalbum(Integer indexpage,String ualbumname) {
        if(indexpage == null){
            indexpage = 1;
        }
        if(ualbumname!=""){
            String name= ualbumname+"%";
            List params0 = new ArrayList();
            params0.add(name);

            //1.去数据库里面找你这条 sql语句所产生了多少条记录
            Integer countrows = dao.count("select count(1) from album where albumname like ? ",params0);

            //2.把总记录书交给工具运算
            Pager p = new Pager(countrows,indexpage);

            //3.运算结果作为参数传递
            String sql ="select albumid,singerid,albuminfo,albumartist"
                    + ",albumreleaseDate,albumname,albumpic,lang from album "
                    + "where albumname like ? limit ?,?";
            List params = new ArrayList();
            params.add(name);
            params.add(p.getBeginrows());
            params.add(p.getPagesize());
            //4.提取数据
            List<Object> query = dao.query(Album.class, sql, params);

            //5。将数据封装到工具当中。因为，前台还需要工具的数据
            p.setData(query);
            return new APIRequest(p);

        }else {
            //1.去数据库里面找你这条 sql语句所产生了多少条记录
            Integer countrows = dao.count("select count(1) from album",null);

            //2.把总记录书交给工具运算
            Pager p = new Pager(countrows,indexpage);

            //3.运算结果作为参数传递
            String sql ="select albumid,singerid,albuminfo,albumartist"
                    + ",albumreleaseDate,albumname,albumpic,lang from album limit ?,?";
            List params = new ArrayList();
            params.add(p.getBeginrows());
            params.add(p.getPagesize());
            //4.提取数据
            List<Object> query = dao.query(Album.class, sql, params);

            //5。将数据封装到工具当中。因为，前台还需要工具的数据
            p.setData(query);
            return new APIRequest(p);
        }

    }

    /*删除专辑及专辑下的所有歌曲*/
    @Override
    public APIRequest deletealbum(int albumid) {
        List params = new ArrayList();
        params.add(albumid);
        params.add(albumid);
        String sql="delete album,songs from album,songs where album.albumid=? and songs.albumid=?";
        int result=dao.deleteByid(sql,params);
        if(result>0){
            return new APIRequest(true,"该专辑及专辑下歌曲已删除");
        }else {
            return new APIRequest(false,"删除失败");
        }
    }
}
