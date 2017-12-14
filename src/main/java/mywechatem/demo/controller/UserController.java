package mywechatem.demo.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.client.model.NewPassword;
import io.swagger.client.model.RegisterUsers;
import mywechatem.demo.domain.ResponseMessage;
import mywechatem.demo.domain.User;
import mywechatem.demo.service.UserEbi;
import mywechatem.demo.utils.chat.api.impl.EasemobIMUsers;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Resource
    private UserEbi userEbi;

    private EasemobIMUsers easemobIMUsers = new EasemobIMUsers();

    @RequestMapping(value = "/register", method = {RequestMethod.POST, RequestMethod.GET})
    public String insertUserCon(@RequestBody User user) {
        try {
            user.setSex(1);
            user.setType(1);//设置默认用户
            user.setBackgroundUrl("image/background_default.jpg");//设置默认背景
            RegisterUsers users = new RegisterUsers();
            io.swagger.client.model.User user1 = new io.swagger.client.model.User().username(user.getTelephone()).password(user.getPassword());
            users.add(user1);
            Object result = easemobIMUsers.createNewIMUserSingle(users);
            if (result != null) {
                if (userEbi.searchIdByTel(user.getTelephone()) != null) {
                    return ResponseMessage.responseNot("用户已存在，注册失败！");
                } else {
                    try {
                        userEbi.insertUser(user);
                        return ResponseMessage.responseOk();
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ResponseMessage.responseNot("注册失败");
                    }
                }
            } else {
                return ResponseMessage.responseNot("注册失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseMessage.responseNot("注册失败");
        }
    }

    @RequestMapping("/search")
    public String selectUserByIdCon(@RequestParam("telephone") String telephone) {
        String id = userEbi.searchIdByTel(telephone);
        if (id != null) {
            User user = userEbi.searchUserById(id);
            if (user != null) {
                ResponseMessage<User> message = new ResponseMessage<>(0, "查找成功", userEbi.searchUserById(id));
                return JSON.toJSONString(message);
            } else {
                return ResponseMessage.responseNot("查找失败");
            }
        }
        return ResponseMessage.responseNot("查找失败");
    }

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String LoginCon(String telephone, String password){
        String id=userEbi.searchIdByTel(telephone);
        User user=userEbi.searchUserById(id);
        if (user==null){
            return ResponseMessage.responseNot("不存在此用户");
        }else {
            if (user.getPassword().equals(password)){
                ResponseMessage<User> message=new ResponseMessage<>(0,"登录成功",user);
                return JSON.toJSONString(message);
            }else {
                return ResponseMessage.responseNot("密码错误");
            }
        }
    }

    @RequestMapping(value = "/UpdatePwd", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdatePwdByIdCon( User user) {
        String id = userEbi.searchIdByTel(user.getTelephone());
        if (id != null) {
            User user1 = userEbi.searchUserById(id);
            if (user1 != null) {
                String userName = user1.getTelephone();
                NewPassword psd = new NewPassword().newpassword(user.getPassword());
                Object result = easemobIMUsers.modifyIMUserPasswordWithAdminToken(userName, psd);
                if (result != null) {
                    userEbi.UpdateUserPwd(user);
                    return ResponseMessage.responseOk();
                } else {
                    return ResponseMessage.responseNot("环信服务器出错，更新密码失败");
                }
            } else {
                return ResponseMessage.responseNot("更新失败，不存在此用户");
            }
        } else {
            return ResponseMessage.responseNot("更新失败，不存在此用户");
        }
    }

    @RequestMapping(value = "/UpdateHeadUrl", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdateHeadUrlByIdCon( User user) {
        String id = userEbi.searchIdByTel(user.getTelephone());
        if (id != null) {
            User user1 = userEbi.searchUserById(id);
            if (user1 != null) {
                userEbi.UpdateUserHeadUrl(user);
                return ResponseMessage.responseOk();
            } else {
                return ResponseMessage.responseNot("更新失败，不存在此用户");
            }
        } else {
            return ResponseMessage.responseNot("更新失败，不存在此用户");
        }
    }

    @RequestMapping(value = "/UpdateUserName", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdateUserNameByIdCon( User user) {
        String id = userEbi.searchIdByTel(user.getTelephone());
        if (id != null) {
            User user1 = userEbi.searchUserById(id);
            if (user1 != null) {
                userEbi.UpdateUserName(user);
                return ResponseMessage.responseOk();
            } else {
                return ResponseMessage.responseNot("更新失败，不存在此用户");
            }
        } else {
            return ResponseMessage.responseNot("更新失败，不存在此用户");
        }
    }

    @RequestMapping(value = "/UpdateSignature", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdateSignatureByIdCon( User user) {
        String id = userEbi.searchIdByTel(user.getTelephone());
        if (id != null) {
            User user1 = userEbi.searchUserById(id);
            if (user1 != null) {
                userEbi.UpdateUserSignature(user);
                return ResponseMessage.responseOk();
            } else {
                return ResponseMessage.responseNot("更新失败，不存在此用户");
            }
        } else {
            return ResponseMessage.responseNot("更新失败，不存在此用户");
        }
    }

    @RequestMapping(value = "/UpdateSex", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdateSexByIdCon(User user) {
        String id = userEbi.searchIdByTel(user.getTelephone());
        if (id != null) {
            User user1 = userEbi.searchUserById(id);
            if (user1 != null) {
                userEbi.UpdateUserSex(user);
                return ResponseMessage.responseOk();
            } else {
                return ResponseMessage.responseNot("更新失败，不存在此用户");
            }
        } else {
            return ResponseMessage.responseNot("更新失败，不存在此用户");
        }
    }

    @RequestMapping(value = "/UpdateLocation", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdateLocationByIdCon( User user) {
        String id = userEbi.searchIdByTel(user.getTelephone());
        if (id != null) {
            User user1 = userEbi.searchUserById(id);
            if (user1 != null) {
                userEbi.UpdateUserLocation(user);
                return ResponseMessage.responseOk();
            } else {
                return ResponseMessage.responseNot("更新失败，不存在此用户");
            }
        } else {
            return ResponseMessage.responseNot("更新失败，不存在此用户");
        }
    }

    @RequestMapping(value = "/UpdateBirthday", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdateBirthdayByIdCon( User user) {
        String id = userEbi.searchIdByTel(user.getTelephone());
        if (id != null) {
            User user1 = userEbi.searchUserById(id);
            if (user1 != null) {
                userEbi.UpdateUserBirthday(user);
                return ResponseMessage.responseOk();
            } else {
                return ResponseMessage.responseNot("更新失败，不存在此用户");
            }
        } else {
            return ResponseMessage.responseNot("更新失败，不存在此用户");
        }
    }

    @RequestMapping(value = "/UpdateBackgroundUrl", method = {RequestMethod.POST, RequestMethod.GET})
    public String UpdateBackgroundUrlByIdCon( User user) {
        String id = userEbi.searchIdByTel(user.getTelephone());
        if (id != null) {
            User user1 = userEbi.searchUserById(id);
            if (user1 != null) {
                userEbi.UpdateUserBackgroundUrl(user);
                return ResponseMessage.responseOk();
            } else {
                return ResponseMessage.responseNot("更新失败，不存在此用户");
            }
        } else {
            return ResponseMessage.responseNot("更新失败，不存在此用户");
        }
    }

    @RequestMapping(value = "/searchFriendsList",method = {RequestMethod.GET,RequestMethod.POST})
    public String SearchUserByListString(String[] telephone){

        List<User> users=userEbi.searchUserByListString(telephone);
        if (users!=null){
            ResponseMessage<List<User>> message=new ResponseMessage<>(0,"查找成功",users);
            return JSON.toJSONString(message);
        }else {
            return ResponseMessage.responseNot("查找失败");
        }
    }


}
