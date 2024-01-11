package com.wuhao.wuhaozn_springboot.config;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class kaptcha_config {

        @Bean
        public DefaultKaptcha getkaptcha(){
            Properties properties =new Properties();
            properties.put("kaptcha.image.width","180");//Image width
            properties.put("kaptcha.image.height","80");//PictureHight
            properties.put("kaptcha.textproducer.char.length", "4");//VerificationCodeLength
            properties.put("kaptcha.border","no");//setBorders
            properties.put("kaptcha.textproducer.font.size", "50");//FontSize
            properties.put("kaptcha.textproducer.font.color","green");//setFontColor
            properties.put("kaptcha.textproducer.char.space","4");//setTextSpacing
            properties.put("kaptcha.textproducer.font.names", "microsoftYahei");//setFontStyle
            properties.put("kaptcha.noise.color","blue");//interferenceLineColor
            properties.put("kaptcha.obscurificator.impl","com.google.code.kaptcha.impl.ShadowGimpy");//backgroundStyle
            Config config =new Config(properties);
            DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
            defaultKaptcha.setConfig(config);
            return defaultKaptcha;
        }


}
