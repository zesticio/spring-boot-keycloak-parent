package in.zestic.authy.app.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @ResponseBody
    @RequestMapping("/error")
    String error(HttpServletRequest request) {
        return "<h1>Error occurred</h1>";
    }

    public String getErrorPath() {
        return "/error";
    }
}