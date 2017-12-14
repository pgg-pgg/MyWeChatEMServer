package mywechatem.demo.controller;


import com.alibaba.fastjson.JSON;
import io.swagger.client.model.RegisterUsers;
import mywechatem.demo.domain.Moments;
import mywechatem.demo.domain.ResponseMessage;
import mywechatem.demo.domain.User;
import mywechatem.demo.service.MomentsEbi;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Moments")
public class MomentsController {

    @Resource
    private MomentsEbi momentsEbi;

    @RequestMapping(value = "/insert", method = {RequestMethod.POST, RequestMethod.GET})
    public String insertUserCon( Moments moments) {
        moments.setTime(new Date().getTime());
        try {
            momentsEbi.insertMoments(moments);
            return ResponseMessage.responseOk();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("发表失败");
        }
    }

    @RequestMapping(value = "/deleteById", method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteMoments(String id){
        try {
            momentsEbi.deleteMoments(id);
            return ResponseMessage.responseOk();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("删除失败");
        }
    }

    @RequestMapping(value = "/deleteFromUserId", method = {RequestMethod.POST, RequestMethod.GET})
    public String deleteFromUserId(String userId){
        try {
            momentsEbi.deleteMomentsFromUser(userId);
            return ResponseMessage.responseOk();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("删除失败");
        }
    }

    @RequestMapping(value = "/searchMoments", method = {RequestMethod.POST, RequestMethod.GET})
    public String SearchMoments(String[] userId){
        try {
            ResponseMessage<List<Moments>> message=new ResponseMessage<>(0,"查找成功",momentsEbi.searchMoments(userId));
            return JSON.toJSONString(message);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseMessage.responseNot("查找失败");
        }
    }
}
