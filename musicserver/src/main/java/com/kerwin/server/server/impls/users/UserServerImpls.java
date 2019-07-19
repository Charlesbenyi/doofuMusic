package com.kerwin.server.server.impls.users;


import com.kerwin.server.dao.IDao;
import com.kerwin.server.dao.impls.UserDaoImpls;
import com.kerwin.server.dao.interfaces.users.UserDao;
import com.kerwin.server.pojo.*;
import com.kerwin.server.server.interfaces.users.UserServer;
import com.kerwin.server.utils.APIRequest;
import com.kerwin.server.utils.Pager;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.text.normalizer.UnicodeSet;

import java.util.ArrayList;
import java.util.List;

public class UserServerImpls implements UserServer {

    UserDao dao = new UserDaoImpls();
    public APIRequest query(Integer indexpage){

        if(indexpage == null){
            indexpage = 1;
        }
        //1.去数据库里面找你这条 sql语句所产生了多少条记录
        Integer countrows = dao.count("select count(1) from singer",null);

        //2.把总记录书交给工具运算
        Pager p = new Pager(countrows,indexpage);

        //3.运算结果作为参数传递
        String sql ="select * from singer limit ?,?";
        List params = new ArrayList();
        params.add(p.getBeginrows());
        params.add(p.getPagesize());
        //4.提取数据
        List<Object> query = dao.query(Singer.class, sql, params);

        //5。将数据封装到工具当中。因为，前台还需要工具的数据
        p.setData(query);
        return new APIRequest(p);

    }

    public APIRequest login(String username,String password){
        APIRequest request = null;
        if(username == null){
            return new APIRequest(false,"用户名不能为空");
        }else if(password == null){
            return new APIRequest(false,"密码不能为空");
        }
        return request;
    }


    public APIRequest querysingerbyname(Integer indexpage, String singername) {
        if(indexpage == null){
            indexpage = 1;
        }
        String singername1="'"+singername+"%'";
        //1.去数据库里面找你这条 sql语句所产生了多少条记录
        Integer countrows = dao.count("select count(1) from singer where singername like"+singername1,null);
        //2.把总记录书交给工具运算
        Pager p = new Pager(countrows,indexpage);

        //3.运算结果作为参数传递

        String sql ="select * from singer where singername like ? limit ?,? ";
        List params = new ArrayList();
        singername=singername+"%";
        params.add(singername);
        params.add(p.getBeginrows());
        params.add(p.getPagesize());
        //4.提取数据
        List<Object> query = dao.query(Singer.class, sql, params);

        //5。将数据封装到工具当中。因为，前台还需要工具的数据
        p.setData(query);
        return new APIRequest(p);
    }

    public APIRequest querysingerbyid( String singerId) {


        //3.运算结果作为参数传递

        String sql ="select * from singer where singerid = ?  ";
        List params = new ArrayList();

        params.add(singerId);

        //4.提取数据
        List<Object> query = dao.query(Singer.class, sql, params);


        return new APIRequest(query);
    }

    @Override
    public APIRequest querysongsbysingerid(Integer indexpage,String singerId) {
        if(indexpage == null){
            indexpage = 1;
        }
        //1.去数据库里面找你这条 sql语句所产生了多少条记录
        Integer countrows = dao.count("select count(1) from songs where singerid ="+singerId,null);
        //2.把总记录书交给工具运算
        Pager p = new Pager(countrows,indexpage);

        //3.运算结果作为参数传递

        String sql ="select * from songs where singerid = ? limit ?,? ";
        List params = new ArrayList();
        params.add(singerId);
        params.add(p.getBeginrows());
        params.add(p.getPagesize());
        //4.提取数据
        List<Object> query = dao.query(Song.class, sql, params);
        String sql1="select al.albumname from album al LEFT JOIN singer sg on al.singerid=sg.singerid  where al.singerid = ? ";
        List params1=new ArrayList();
        params1.add(singerId);
        List<Object> query1=dao.query(Album.class,sql1,params1);
        //5。将数据封装到工具当中。因为，前台还需要工具的数据

        p.setData(query);
        return new APIRequest(p);
    }

    public APIRequest querysongsbysongname(String songname) {
        String sql ="select * from songs where songname = ?  ";
        List params = new ArrayList();

        params.add(songname);

        //4.提取数据
        List<Object> query = dao.query(Song.class, sql, params);


        return new APIRequest(query);
    }

    public APIRequest querysongsbyaddress() {
        String sql ="select * from album limit 1,6 ";
        List params = new ArrayList();


        //4.提取数据
        List<Object> query = dao.query(Album.class, sql, params);


        return new APIRequest(query);
    }


    public APIRequest querysingersix() {
        String sql ="select * from singer  limit 0,6 ";
        List params = new ArrayList();
        //4.提取数据
        List<Object> query = dao.query(Singer.class, sql, params);
        return new APIRequest(query);

    }


   /*111111111111*/
    @Override
    public APIRequest userlogin(String accounts, String userpwd) {
        List params = new ArrayList();
        params.add(accounts);
        params.add(userpwd);
        String sql="select *from user where accounts=? and userpwd=?";
        List<User> users = dao.query(User.class,sql,params);
        if(users.size()==0){
            return new APIRequest(false,"该用户不存在");
        }else{
            return new APIRequest(users.get(0));
        }
    }

    @Override
    public APIRequest adminlogin(String accounts, String userpwd) {
        List params = new ArrayList();
        params.add(accounts);
        params.add(userpwd);
        String sql="select *from manager where accounts=? and userpwd=?";
        List<Manager> managers = dao.query(Manager.class,sql,params);
        if(managers.size()==0){
            return new APIRequest(false,"该管理员不存在");
        }else{
            return new APIRequest(true,"登录成功");
        }
    }

    @Override
    public APIRequest newsongs() {
       String sql="select * from songs order by songreleaseDate desc limit 0,10";
       List<Song> songs=dao.query(Song.class,sql,null);
       return new APIRequest(songs);
    }

    @Override
    public APIRequest selectsingerbyid(int singerid){
        List params = new ArrayList();
        params.add(singerid);
        String sql="select * from singer where singerid=?";
        List<Singer> singers=dao.query(Singer.class,sql,params);
        return new APIRequest(singers);
    }

    @Override
    public APIRequest selectuserbyuserid(int userid) {
        List params = new ArrayList();
        params.add(userid);
        String sql = "select * from user where userid=?";
        List<User> users = dao.query(User.class, sql, params);
        return new APIRequest(users);
    }

    @Override
    public APIRequest shoucang(Shoucang shoucang) {
        int userid=shoucang.getUserid();
        int songid=shoucang.getSongid();
        List params = new ArrayList();
        params.add(userid);
        params.add(songid);
        String sql="select * from shoucang where userid=? and songid=?";
        List<Shoucang> shoucangs=dao.query(Shoucang.class,sql,params);
        if(shoucangs.size()>0){
            String sql1="delete from shoucang where userid=? and songid=?";
            int a=dao.delete(sql1,params);
            if(a>0){
                return new APIRequest(true,"已取消收藏");
            }else {
                return new APIRequest(false,"取消失败");
            }
        }else{
           int result=dao.shoucang(shoucang);
            if(result>0){
               return new APIRequest(true,"收藏成功");
           }else {
              return new APIRequest(false,"收藏失败");
         }
       }
    }

    public APIRequest queryalbumbyalbumid(String albumid) {
        String sql="select * from album where albumid=? ";
        List params =new ArrayList();
        params.add(albumid);
        List<Object> query =dao.query(Album.class,sql,params);
        return  new APIRequest(query);
    }

    public APIRequest querysongsbyalbumid(Integer indexpage,String albumid) {
        if(indexpage == null){
            indexpage = 1;
        }
        //1.去数据库里面找你这条 sql语句所产生了多少条记录
        Integer countrows = dao.count("select count(1) from songs where albumid ="+albumid,null);
        //2.把总记录书交给工具运算
        Pager p = new Pager(countrows,indexpage);

        //3.运算结果作为参数传递

        String sql ="select * from songs where albumid = ? limit ?,? ";
        List params = new ArrayList();
        params.add(albumid);
        params.add(p.getBeginrows());
        params.add(p.getPagesize());
        //4.提取数据
        List<Object> query = dao.query(Song.class, sql, params);
        //5。将数据封装到工具当中。因为，前台还需要工具的数据

        p.setData(query);
        return new APIRequest(p);
    }
    public APIRequest queryalbum(Integer indexpage) {
        if(indexpage == null){
            indexpage = 1;
        }
        //1.去数据库里面找你这条 sql语句所产生了多少条记录
        Integer countrows = dao.count("select count(1) from album",null);

        //2.把总记录书交给工具运算
        Pager p = new Pager(countrows,indexpage);

        //3.运算结果作为参数传递
        String sql ="select * from album limit ?,?";
        List params = new ArrayList();
        params.add(p.getBeginrows());
        params.add(p.getPagesize());
        //4.提取数据
        List<Object> query = dao.query(Album.class, sql, params);

        //5。将数据封装到工具当中。因为，前台还需要工具的数据
        p.setData(query);
        return new APIRequest(p);
    }

    public APIRequest queryalbumbyname(Integer indexpage, String albumname) {
        if(indexpage == null){
            indexpage = 1;
        }
        String albumname1="'"+albumname+"%'";
        //1.去数据库里面找你这条 sql语句所产生了多少条记录
        Integer countrows = dao.count("select count(1) from album where albumname like"+albumname1,null);
        //2.把总记录书交给工具运算
        Pager p = new Pager(countrows,indexpage);

        //3.运算结果作为参数传递

        String sql ="select * from album where albumname like ? limit ?,? ";
        List params = new ArrayList();
        albumname=albumname+"%";
        params.add(albumname);
        params.add(p.getBeginrows());
        params.add(p.getPagesize());
        //4.提取数据
        List<Object> query = dao.query(Album.class, sql, params);

        //5。将数据封装到工具当中。因为，前台还需要工具的数据
        p.setData(query);
        return new APIRequest(p);
    }

    public APIRequest querymysongslist(Integer indexpage, int userid) {
        if(indexpage == null){
            indexpage = 1;
        }
        //1.去数据库里面找你这条 sql语句所产生了多少条记录
        Integer countrows = dao.count("select count(1) from shoucang where userid ="+userid,null);
        //2.把总记录书交给工具运算
        Pager p = new Pager(countrows,indexpage);

        //3.运算结果作为参数传递

        String sql ="select *from songs where songid in (select songid from shoucang where userid=?) limit ?,? ";
        List params = new ArrayList();
        params.add(userid);
        params.add(p.getBeginrows());
        params.add(p.getPagesize());
        //4.提取数据
        List<Object> query = dao.query(Song.class, sql, params);
        //5。将数据封装到工具当中。因为，前台还需要工具的数据
        p.setData(query);
        return new APIRequest(p);
    }

    public APIRequest userinfoupdate(User user) {
       String username =user.getUsername();
       String sex= user.getSex();
       Integer age =user.getAge();
       String telephone=user.getTelephone();
       String email=user.getEmail();
       Integer userid=user.getUserid();
        String userpwd=user.getUserpwd();
        String sql="update user set username=?,sex=?,age=?,telephone=?,email=?,userpwd=? where userid=?";
        List params=new ArrayList();
        params.add(username);
        params.add(sex);
        params.add(age);
        params.add(telephone);
        params.add(email);
        params.add(userpwd);
        params.add(userid);
        int a=dao.update(sql,params);
        if(a>0){
            return new APIRequest(true,"修改成功");
        }else {
            return new APIRequest(false,"修改失败");
        }
    }
}
