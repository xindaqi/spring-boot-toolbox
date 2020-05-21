package com.company.web.controller;

import com.company.web.po.UserInfos;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity; 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.company.web.service.UserInfosService;

@CrossOrigin(origins="*", maxAge=3600)
@Controller 
@RequestMapping("/api/page")
public class PageController {
    static Logger logger = LoggerFactory.getLogger(PageController.class);
    @Autowired
    private UserInfosService userInfosService;
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String indexPage(Model model){
        Map<String, String> userInfos = new HashMap<>();
        userInfos.put("username", "xioaxioa");
        userInfos.put("password", "123456");
        model.addAttribute("loginInfos", userInfos);
        return "sys/index";

    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(ModelMap map, Model model, @ModelAttribute UserInfos params, HttpSession session){
        UserInfos userInfos = new UserInfos();
        // map.put("userInfo", userInfos);
        model.addAttribute("userInfo", params);
        // System.out.println("email:"+params.getEmail());
        return "sign-in/index";
    }
    @RequestMapping(value="/user/add", method=RequestMethod.POST)
    @ResponseBody
    public Map addUser(@RequestBody UserInfos params){
        Map returnMap = new HashMap();
        Integer resFlag = userInfosService.addUser(params);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功添加");
        returnMap.put("flag", resFlag);
        return returnMap;

    }
    @RequestMapping(value="/user/delete", params="id", method=RequestMethod.DELETE)
    @ResponseBody
    public Map deleteUser(@RequestParam("id") Integer id){
        Map returnMap = new HashMap();
        Integer resFlag = userInfosService.deleteUser(id);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功添加");
        returnMap.put("flag", resFlag);
        return returnMap;

    }
    @RequestMapping(value="/user/edit", method=RequestMethod.PUT)
    @ResponseBody
    public Map editUser(@RequestBody UserInfos params){
        Map returnMap = new HashMap();
        Integer resFlag = userInfosService.editUser(params);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功添加");
        returnMap.put("flag", resFlag);
        return returnMap;
    }
    @RequestMapping(value="/user/query", method=RequestMethod.POST)
    @ResponseBody
    public Map queryUser(@RequestBody Map params){
        Map returnMap = new HashMap();
        List resFlag = userInfosService.queryUser(params);
        returnMap.put("code", 200);
        returnMap.put("msg", "成功添加");
        returnMap.put("datas", resFlag);
        return returnMap;

    }

    @RequestMapping(value="/ui/user/add", method=RequestMethod.GET)
    public String addUserWithPage(ModelMap map, Model model){
        model.addAttribute("userInfo", new UserInfos());
        return "user-info/add";
    }

    @RequestMapping(value="/ui/user/save", method=RequestMethod.POST)
    public String saveAddUserInfo(@ModelAttribute UserInfos params){
        Integer resFlag = userInfosService.addUser(params);
        return "redirect:/api/page/datasshow";
    }

    @RequestMapping(value="/ui/user/delete", params="id", method=RequestMethod.GET)
    public String deleteUserWithId(@RequestParam("id") Integer id, ModelMap map, Model model){
        System.out.println("id:"+id);
        Integer resFlagDel = userInfosService.deleteUser(id);
        return "redirect:/api/page/datasshow";
    }

    @RequestMapping(value="/ui/user/edit", params="id", method=RequestMethod.GET)
    public String editUserInfo(@RequestParam("id") Integer id, ModelMap map, Model model){
        UserInfos userDatas = userInfosService.queryUserWithId(id);
        System.out.println("id:"+userDatas.getId());
        // params.setUsername("xiaohua");
        model.addAttribute("userInfo", userDatas);
        // model.addAttribute("userInfo", params);
        // System.out.println("username:"+params.getUsername());
        // map.addAttribute("userInfo", new UserInfos());
        return "user-info/edit";
    }

    @RequestMapping(value="/ui/user/update", method=RequestMethod.POST)
    public String editSaveUserInfo(@ModelAttribute UserInfos params, Model model){
        model.addAttribute("userInfo", params);
        Integer resFlag = userInfosService.editUser(params);
        return "redirect:/api/page/datasshow";
    }

    @RequestMapping(value="/ui/user/add/eject", method=RequestMethod.POST)
    public String addSaveEjectUserInfo(@RequestBody UserInfos params, ModelMap map, Model model){
        System.out.println("username from modal:"+params.getPosition());
        // Integer resFlag = userInfosService.editUser(params);
        System.out.println("success update");
        Integer resFlag = userInfosService.addUser(params);
        map.put("username", "");
        List resLi = userInfosService.queryUser(map);
        model.addAttribute("resultLi", resLi);
        return "redirect:/api/page/datasshow";
    }

    @RequestMapping(value="/ui/user/update/eject", method=RequestMethod.POST)
    @ResponseBody
    public String editSaveEjectUserInfo(@RequestBody UserInfos params){
        Integer resFlag = userInfosService.editUser(params);
        System.out.println("uid:"+params.getId());
        System.out.println("username:"+params.getUsername());
        System.out.println("success update");
        return "success";
    }

    @RequestMapping(value="/ui/user/query", method=RequestMethod.GET)
    public ModelAndView dataQuery(@RequestParam("username") String username, ModelMap map){
        // System.out.println("email from sign:"+params.getEmail());
        Integer pageNum=0,pageSize=5;
        PageHelper.startPage(pageNum, pageSize);
        map.put("username", username);
        List resFlag = userInfosService.queryUser(map);
        PageInfo pageInfo = new PageInfo(resFlag, pageSize);
        ModelAndView mav = new ModelAndView("datasshow/index");
        // mav.addObject("resultLi", resFlag);
        mav.addObject("resultLi", pageInfo);
        mav.addObject("total", pageInfo.getTotal());
        mav.addObject("pageNum", pageInfo.getPageNum());
        mav.addObject("pageSize", pageInfo.getPageSize());
        mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        mav.addObject("totalPages", pageInfo.getPages());
        mav.addObject("isLastPage", pageInfo.isIsLastPage());
        return mav;
    }

    @RequestMapping(value="/datasshow",method=RequestMethod.GET)
    public String datasShow(@ModelAttribute UserInfos params, ModelMap map, Model model, 
    @RequestParam(value="pageNum", defaultValue="0")Integer pageNum,
    @RequestParam(value="pageSize", defaultValue="5") Integer pageSize){
        // System.out.println("email from sign:"+params.getEmail());
        System.out.println("username from sign:"+params.getUsername());
        map.put("username", "");
        System.out.println("pageSize:"+pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List resFlag = userInfosService.queryUser(map);
        PageInfo pageInfo = new PageInfo(resFlag, pageSize);
        // ModelAndView mav = new ModelAndView("datasshow/index");
        // ModelAndView mav1 = new ModelAndView("user-info/edit");
        // mav.addObject("resultLi", pageInfo);
        // mav.addObject("total", pageInfo.getTotal());
        // mav.addObject("pageNum", pageInfo.getPageNum());
        // mav.addObject("pageSize", pageInfo.getPageSize());
        // System.out.println("pagesize from pagehelper:"+pageInfo.getPageSize());
        // mav.addObject("isFirstPage", pageInfo.isIsFirstPage());
        // mav.addObject("totalPages", pageInfo.getPages());
        // mav.addObject("isLastPage", pageInfo.isIsLastPage());
        // string url
        model.addAttribute("resultLi", pageInfo);
        model.addAttribute("total", pageInfo.getTotal());
        model.addAttribute("pageNum", pageInfo.getPageNum());
        model.addAttribute("pageSize", pageInfo.getPageSize());
        model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
        model.addAttribute("totalPages", pageInfo.getPages());
        model.addAttribute("isLastPage", pageInfo.isIsLastPage());
        return "datasshow/index";
        

        // return "datasshow/index";
    }



    @RequestMapping(value="/form-data", method=RequestMethod.POST)
    @ResponseBody
    public String signIn(@ModelAttribute UserInfos params){
        String email = params.getEmail();
        return email;
    }

    @RequestMapping(value="/infos", method=RequestMethod.GET)
    @ResponseBody
    public String infosShow(){
        return "success";
    }
    @RequestMapping(value="/infos/show", method=RequestMethod.GET)
    public ResponseEntity infosShowEntity(){
        return ResponseEntity.ok("请求成功");
    }


}