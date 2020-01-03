package com.hbgc.onlinetestdemo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.hbgc.onlinetestdemo.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("commons")
public class CommonsController extends BaseController{

    @Autowired
    private DefaultKaptcha captchaProducer;


    //生成一个数学公式的验证码的接口
    @GetMapping("mathRandomCode")
    public void createMathExpressRandomCode(String token, HttpServletRequest request, HttpSession session, HttpServletResponse response){

        try{
            //想办法画出一个数学公式的图片，返回给浏览器。

            //生成图片的尺寸，宽度和高度
            int width = 80;
            int height = 40;

            //create the image
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.getGraphics();
            // set the background color
            g.setColor(new Color(0xDCDCDC));
            g.fillRect(0, 0, width, height);
            // draw the border
            g.setColor(Color.black);
            g.drawRect(0, 0, width - 1, height - 1);
            // create a random instance to generate the codes
            Random rdm = new Random();
            // make some confusion
            for (int i = 0; i < 50; i++) {
                int x = rdm.nextInt(width);
                int y = rdm.nextInt(height);
                g.drawOval(x, y, 0, 0);
            }
            // generate a random code
            String verifyCode = MyUtils.generateVerifyCode(rdm);
            // "3*5"
            //把验证码存，计算结果保存到redis缓存;
            int rnd = MyUtils.calc(verifyCode); //15

            System.out.println("存入缓存成功");
            g.setColor(new Color(0, 100, 0));
            g.setFont(new Font("Candara", Font.BOLD, 24));
            g.drawString(verifyCode + "=", 8, 24);
            g.dispose();

            //使用servlet的out对象浏览器绘制一张图片。
            OutputStream out = response.getOutputStream();
            ImageIO.write(image, "JPEG", out);

            //把结果存到redis缓存中
            redisTemplate.opsForValue().set(token, rnd, 30, TimeUnit.MINUTES);

            out.flush();
            out.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


    //使用hutool工具类生成验证码，用于发博文时输入的验证码
    @GetMapping("hutoolRandomCodeImage")
    public Map<String, Object> createRandomCodeImage(String token, HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        //response.setContentType("image/jpeg");
        System.out.println("token值是：" + token);
        try {
            //定义图形验证码的长和宽
            LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100, 40, 4, 2);
            BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
            //图形验证码写出，可以写出到文件，也可以写出到流
            OutputStream out = response.getOutputStream();
            //lineCaptcha.write(out);

            //image = (BufferedImage) lineCaptcha.createImage(MyUtils.createRandomCode());
            image = (BufferedImage) lineCaptcha.createImage(lineCaptcha.getCode());
            ImageIO.write(image, "JPEG", out);

            //输出code
            Console.log("hutool生成的验证码是：" + lineCaptcha.getCode());
            //验证图形验证码的有效性，返回boolean值
            //把验证码保存到redis中,默认半个小时内有效。
            redisTemplate.opsForValue().set(token, lineCaptcha.getCode(), 10, TimeUnit.MINUTES);
            //System.out.println("验证结果：" + lineCaptcha.verify("1234"));
            System.out.println("验证码保存到redis成功！");

            out.flush();
            out.close();
            //重新生成验证码
            /*
            lineCaptcha.createCode();
            lineCaptcha.write("d:/line.png");
            //新的验证码
            Console.log(lineCaptcha.getCode());
            //验证图形验证码的有效性，返回boolean值
            lineCaptcha.verify("1234");
            */

            //return Json.success(null);
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    //Google的kaptacha组件生成验证码的动作。
    @GetMapping("kaptchaRandomCodeImage")
    public void defaultKaptcha(String token, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("输出kaptcha验证码");
        byte[] captchaChallengeAsJpeg = null;
        //ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        OutputStream jpegOutputStream = httpServletResponse.getOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            System.out.println("输出kaptcha验证码字符串是：" + createText);

            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "JPEG", jpegOutputStream);

            redisTemplate.opsForValue().set(token, createText, 10, TimeUnit.MINUTES);
            System.out.println("验证码保存到redis成功！");

            jpegOutputStream.flush();
            jpegOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


    }



}
