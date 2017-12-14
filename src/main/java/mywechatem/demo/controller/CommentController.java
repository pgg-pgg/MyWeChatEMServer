package mywechatem.demo.controller;


import com.alibaba.fastjson.JSON;
import mywechatem.demo.domain.Comment;
import mywechatem.demo.domain.ResponseMessage;
import mywechatem.demo.domain.User;
import mywechatem.demo.service.CommentEbi;
import mywechatem.demo.service.UserEbi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    @Resource
    private CommentEbi commentEbi;

    @Resource
    private UserEbi userEbi;

    @RequestMapping(value = "/insert", method = {RequestMethod.POST, RequestMethod.GET})
    public String insertComment(Comment comment){
        try {
            String id=userEbi.searchIdByTel(comment.getUserId());
            User user=userEbi.searchUserById(id);
            if (user!=null){
                comment.setUserName(user.getUsername());
                comment.setTime(new Date().getTime());
                commentEbi.insertComment(comment);
                return ResponseMessage.responseOk();
            }else {
                return ResponseMessage.responseNot("不存在此用户");
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("插入错误");
        }
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.POST, RequestMethod.GET})
    public String delete(String moments_id){
        try {
            commentEbi.deleteComment(moments_id);
            return ResponseMessage.responseOk();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("删除失败");
        }
    }

    @RequestMapping(value = "/selectByMomentsId", method = {RequestMethod.POST, RequestMethod.GET})
    public String search(String moments_id){
        try {
            ResponseMessage<List<Comment>> message=new ResponseMessage<>(0,"查找成功",commentEbi.SearchComment(moments_id));
            return JSON.toJSONString(message);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("查找失败");
        }
    }

    @RequestMapping(value = "/selectAllMomentsId", method = {RequestMethod.POST, RequestMethod.GET})
    public String searchAllComment(String[] moments_id){
        try {
            ResponseMessage<List<Comment>> message=new ResponseMessage<>(0,"查找成功",commentEbi.searchAllComment(moments_id));
            return JSON.toJSONString(message);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("查找失败");
        }
    }
}
