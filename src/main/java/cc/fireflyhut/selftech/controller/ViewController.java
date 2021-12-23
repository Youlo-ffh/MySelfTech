package cc.fireflyhut.selftech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

@Controller
@RequestMapping("/index")
public class ViewController {

    /**
     * 通过返回String返回页面和数据
     * */
    @RequestMapping("/something")
    public String something(Model model) {  // 在参数列表接收Model对象
        // 通过调用Model对象的addAttribute方法向页面传值
        model.addAttribute("msg", "通过返回String来响应页面和数据");
        return "index";
    }

    /**
     * 通过返回ModelAndView返回页面和数据
     * */
    @RequestMapping("/interesting")
    public ModelAndView interesting() {
        ModelAndView mv = new ModelAndView("index");  // 通过有参构造器创建对象，传入页面的名字
        mv.addObject("msg", "通过返回ModelAndView来响应页面和数据");
        return mv;
    }

    /**
     * 请求转发
     * */
    @RequestMapping("/forward")
    public String forwardTest() {
        System.out.println("请求转发测试");
        return "forward:/index/forwardTarget";
    }

    /**
     * 被请求转发的目标路径
     * */
    @RequestMapping("/forwardTarget")
    public String forwardTarget() {
        return "forward";
    }

    /**
     * 重定向
     * */
    @RequestMapping("/redirect")
    public String redirectTest() {
        return "redirect:/index/redirectTarget";
    }

    /**
     * 被重定向的目标路径
     * */
    @RequestMapping("/redirectTarget")
    public String redirectTarget() {
        return "redirect";
    }

}
