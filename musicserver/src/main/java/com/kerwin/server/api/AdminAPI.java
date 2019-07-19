package com.kerwin.server.api;

import com.kerwin.server.pojo.User;
import com.kerwin.server.server.impls.admin.AdminServerImpls;
import com.kerwin.server.utils.APIRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminAPI {
     AdminServerImpls adminServerImpls=new AdminServerImpls();

     /*查询用户*/
     @RequestMapping("adminuser.do")
     public APIRequest query(Integer indexpage,String uname){
         return adminServerImpls.query(indexpage,uname);
     }

     /*删除用户*/
     @RequestMapping("deleteuser.do")
     public APIRequest deleteByid(int userid){
         return adminServerImpls.deleteByUserid(userid);
     }

     /*添加用户*/
     @RequestMapping("adduser.do")
     public APIRequest addUser(User user){
         return adminServerImpls.addUser(user);
     }

     /*根据userid查询*/
     @RequestMapping("selectUserByid.do")
     public APIRequest selectUserByid(int userid){
          return adminServerImpls.selectUserByid(userid);
     }

     /*修改user*/
     @RequestMapping("editoruser.do")
     public APIRequest editoruser(User user){
          return adminServerImpls.editoruser(user);
     }

     /*分页查询歌曲*/
     @RequestMapping("adminsong.do")
     public APIRequest querysong(Integer indexpage,String usongname){
          return adminServerImpls.querysong(indexpage,usongname);
     }

     /*删除歌曲*/
     @RequestMapping("deletesong.do")
     public APIRequest deletesong(int songid){
         return adminServerImpls.deletesong(songid);
     }

     /*分页查询歌手*/
     @RequestMapping("adminsinger.do")
     public APIRequest querysinger(Integer indexpage,String usingername){
         return adminServerImpls.querysinger(indexpage,usingername);
     }

     /*删除歌手及歌手下所有的歌曲和专辑*/
     @RequestMapping("deletesinger.do")
     public APIRequest deletesinger(int singerid){
          return adminServerImpls.deletesinger(singerid);
     }

     /*分页查询专辑*/
     @RequestMapping("adminalbum.do")
     public APIRequest queryalbum(Integer indexpage,String ualbumname){
         return adminServerImpls.queryalbum(indexpage,ualbumname);
     }

     /*删除专辑及专辑下的所有歌曲*/
     @RequestMapping("deletealbum.do")
     public APIRequest deletealbum(int albumid){
          return adminServerImpls.deletealbum(albumid);
     }

}
