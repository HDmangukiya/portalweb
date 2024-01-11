package com.wuhao.wuhaozn_springboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class article_images {
    /*{
  "code": 0 //_0MeansSuccess，otherFailures
  ,"msg": "" //promptMessage //normallyReturnsAfterFailedUpload
  ,"data": {
    "src": "imagePath"
    ,"title": "pictureName" //optional}}*/

    int code;
    String msg;
    data_util data;



}
