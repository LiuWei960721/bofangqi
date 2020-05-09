package com.lw.pink.controller;

import com.lw.pink.Util.CheckUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @创建人: Liu
 * @创建时间: 2020-04-30 15:26
 * @描述:
 */
@RestController
public class PinkController {
    @GetMapping (value = "/pink")
   public  int pink(){
        System.out.println("laile");
        return 1;
            }
    @RequestMapping(value="hello", method = RequestMethod.GET)
    public void hello(HttpServletRequest request,
                      HttpServletResponse response){
        System.out.println("success");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            if(CheckUtil.checkSignature(signature,timestamp, nonce)){
                out.write(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }

}
