package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {
    //@ResponseBody
    @GetMapping("/hmm")
    public String funcTest(){
        System.out.println("Returning hmm.jsp");
        return "hmm";
//        WEB-INF/view/hmm.jsp
    }
    @PostMapping("/hmm")
    @ResponseBody
    public String funcTest2(){
        return "I wanna kms";
    }
}
