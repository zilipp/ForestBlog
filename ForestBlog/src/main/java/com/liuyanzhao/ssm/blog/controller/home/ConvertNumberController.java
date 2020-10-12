package com.liuyanzhao.ssm.blog.controller.home;

import com.liuyanzhao.ssm.blog.dto.JsonResult;
import com.liuyanzhao.ssm.blog.entity.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
@RestController


public class ConvertNumberController {
    @RequestMapping(value = "/numberToLetter", method = {RequestMethod.POST})
    public JsonResult convert(String number) {
        JsonResult jsonResult = new JsonResult();
        try{
            String[] table = new String[]{"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX" , "SEVEN", "EIGHT", "NINE"};
            StringBuilder sb = new StringBuilder();
            for(char c : number.toCharArray()) {
                int index = (int)(c - '0');
                sb.append(table[index]);
                sb.append(" ");
            }
            String result = sb.deleteCharAt(sb.length() - 1).toString();
            jsonResult.setCode(0);
            jsonResult.setData(result);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setCode(1);
            jsonResult.setMsg("Invalide input");
        }
        return jsonResult;
    }
}
