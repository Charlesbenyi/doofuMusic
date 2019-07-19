package com.kerwin.server.api;

import com.kerwin.server.pojo.Shoucang;
import com.kerwin.server.pojo.User;
import com.kerwin.server.server.impls.users.UserServerImpls;
import com.kerwin.server.utils.APIRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserAPI {
    UserServerImpls server=new UserServerImpls();

    /*用户登陆*/
    @RequestMapping("userlogin.do")
    public APIRequest userlogin(String accounts, String userpwd){
        return server.userlogin(accounts,userpwd);
    }

    /* 管理员登陆*/
    @RequestMapping("adminlogin.do")
    public  APIRequest adminlogin(String accounts,String userpwd){
        return server.adminlogin(accounts,userpwd);
    }

    /*收藏*/
    @RequestMapping("shoucang.do")
    public APIRequest shoucang(Shoucang shoucang){
        return server.shoucang(shoucang);
    }

    /*新歌榜单*/
    @RequestMapping("newsongs.do")
     public APIRequest newsongs(){
       return server.newsongs();
   }

   /*根据singerid查询歌手*/
    @RequestMapping("selectsingerbyid.do")
    public APIRequest selectsingerbyid(int singerid){
        return server.selectsingerbyid(singerid);
    }

    /*  根据用户id查询用户信息*/
    @RequestMapping("selectuserbyuserid.do")
    public APIRequest selectuserbyuserid(int userid) {
        return server.selectuserbyuserid(userid);
    }

   /* 111111111111*/
    /*分页显示所有歌手  歌手页面*/
   @RequestMapping("loadsinger.do")
   public APIRequest query(Integer indexpage){
       return server.query(indexpage);
   }
    /*
    @RequestMapping("loadsingerbysexandadd.do")
    public APIRequest querybysexandadd(Integer indexpage,String sex,String address){
        return server.querybysexandadd(indexpage,sex,address);
    }*/
    /*通过名字模糊查询歌手  歌手页面*/
    @RequestMapping("userloadsingerbyname.do")
    public APIRequest querysingerbyname(Integer indexpage,String singername){return server.querysingerbyname(indexpage,singername);}

    /*通过id查询这个歌手所有信息 歌手详情页面*/
    @RequestMapping("userloadsingerbyid.do")
    public APIRequest querysingerbyid(String singerId){return  server.querysingerbyid(singerId);}

    /*通过歌手id查询其歌曲 歌手详情页面*/
    @RequestMapping("userloadsongsbysingerid.do")
    public APIRequest querysongsbysingerid(Integer indexpage,String singerId){return server.querysongsbysingerid(indexpage,singerId);}

    /*通过歌曲名精确查找歌曲 导航栏的查询*/
    @RequestMapping("userloadsongsbysongname.do")
    public APIRequest querysongsbysongname(String songname){ return  server.querysongsbysongname(songname);}

    /*每日推荐的6首歌曲  首页*/
    @RequestMapping("userloadsongsbyaddress.do")
    public APIRequest querysongsbyaddress(){return  server.querysongsbyaddress();}

    /*每日推荐的6哥歌手  首页*/
    @RequestMapping("userloadsingersix.do")
    public APIRequest querysingersix(){return server.querysingersix();}



    /*宇儿子 2019/7/11 16:42:52*/
    /*根据专辑id查询 专辑信息  首页*/
    @RequestMapping("userloadalbumbyalbumid.do")
    public APIRequest queryalbumbyalbumid(String albumid){return server.queryalbumbyalbumid(albumid);}
    /*根据专辑id 查询其下所有歌曲*/
    @RequestMapping("userloadsongsbyalbumid.do")
    public APIRequest querysongsbyalbumid(Integer indexpage,String albumid){return  server.querysongsbyalbumid(indexpage,albumid);}
    /*显示所有专辑*/
    @RequestMapping("userloadalbum.do")
    public APIRequest queryalbum(Integer indexpage){return  server.queryalbum(indexpage);}
    /*根据名字查询专辑*/
    @RequestMapping("userloadalbumbyname.do")
    public APIRequest queryalbumbyname(Integer indexpage,String albumname){return server.queryalbumbyname(indexpage,albumname);}
    /*显示自己的歌单*/
    @RequestMapping("userloadmysongslist.do")
    public APIRequest querymysongslist(Integer indexpage,Integer userid){return  server.querymysongslist(indexpage,userid);}


    /*显示自己的收藏*/
    @RequestMapping("querymysongslist.do")
    public APIRequest querymysongslist(Integer indexpage,int userid){
        return  server.querymysongslist(indexpage,userid);
    }
    @RequestMapping("userinfoupdate.do")
    public APIRequest userinfoupdata(User user){return  server.userinfoupdate(user);}
}
