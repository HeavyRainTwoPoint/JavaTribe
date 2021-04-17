package com.javatribe.apistarter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Prongs
 * 2021/4/16
 */
@Controller
public class RouterController {
    @RequestMapping({"/","/index.html","/index.php","/index"})
    public String toIndex() {
        return "redirect:/home/index.html";
    }
}
