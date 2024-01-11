package com.wuhao.wuhaozn_springboot.util;

import org.springframework.util.ClassUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class AuthCode {

  // Declare the width and height of the verification code image
  private static final int Wind = 100;
  private static final int Hight = 40;

  // verificationCodeGenerationLibrary
  private static final String Code =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

  // theNumberOfCharactersInTheVerificationCode
  private static final int Code_Count = 4;

  // numberOfInterferenceLines
  private static final int Line_Count = 7;

  // numberOfInterferencePoints
  private static final int Dot_Count = (int) (Wind * Hight * 0.02);

  public String random_math;

  // CreateARandomNumberObject
  Random random = new Random();

  // How to draw a verification code picture (five elements)
  public void getAuthCode() throws FileNotFoundException, IOException {
    // generateVerificationCodeImage
    BufferedImage img = new BufferedImage(Wind, Hight, BufferedImage.TYPE_INT_RGB);
    // getBrush
    Graphics graphics = img.getGraphics();
    // setBackgroundColor
    graphics.setColor(getColor());
    // fillTheDrawableArea
    graphics.fillRect(0, 0, Wind, Hight);
    // createFontObject
    Font font = new Font("boldFace", Font.BOLD, 25);
    // setFont
    graphics.setFont(font);

    // drawFourTimesInALoop
    for (int i = 0; i < Code_Count; i++) {
      // setBrushColor
      graphics.setColor(getColor());
      // getRandomCharactersFromWarehouse
      char a = getRandomCode();
      random_math += a;
      // drawCharactersIntoAnImage
      graphics.drawString(a + "", i * 25 + 5, 30);
    }

    // drawInterferenceLinesInALoop
    for (int i = 0; i < Line_Count; i++) {
      // setBrushColor
      graphics.setColor(getColor());

      // Determine a straight line (to determine a straight line from two points, you need a
      // starting point and an ending point)
      int xStart = random.nextInt(Wind + 1); // getPointsInSizeRandomGetStartingPoint
      int yStart = random.nextInt(Hight + 1);
      int xEnd = random.nextInt(Wind + 1);
      int yEnd = random.nextInt(Hight + 1);
      // drawLinesIntoTheImage
      graphics.drawLine(xStart, yStart, xEnd, yEnd);
    }

    // drawInterferencePoints
    for (int i = 0; i < Dot_Count; i++) {
      // setTheBrushColor
      graphics.setColor(getColor());
      int Dot_x = random.nextInt(Wind - 1);
      int Dot_y = random.nextInt(Hight - 1);
      img.setRGB(Dot_x, Dot_y, getColor().getRGB());
    }
    String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();

    String filePath = path + "static/layuimini/images/wql.jpg";
    System.out.println(filePath);
    // Output the image to the specified location through IO stream
    ImageIO.write(img, "jpg", new FileOutputStream(filePath));
  }

  // howToGetRandomCharacters
  public char getRandomCode() {

    char code = Code.charAt(random.nextInt(61));

    return code;
  }

  // howToGetRandomColors
  public Color getColor() {

    return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
  }
}
