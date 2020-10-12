package com.liuyanzhao.ssm.blog.controller.home;

import com.liuyanzhao.ssm.blog.BaseTest;
import com.liuyanzhao.ssm.blog.dto.JsonResult;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;



public class IndexControllerTest extends BaseTest {
    @Autowired
    ConvertNumberController convertNumberController;

    @Test
    public void testNumberToLetter() {
        String number = "123";
        JsonResult res = convertNumberController.convert(number);
        String value = "ONE TWO THREE";
        Assert.assertEquals(value,res.getData());
    }
}