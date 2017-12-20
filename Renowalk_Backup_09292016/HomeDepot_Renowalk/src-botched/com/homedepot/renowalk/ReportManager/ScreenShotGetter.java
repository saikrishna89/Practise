package com.homedepot.renowalk.ReportManager;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.homedepot.renowalk.TestDriver;

public class ScreenShotGetter {
	public static String screenShotCapture(String path) throws Exception {
		Robot robot = new Robot();
		String filePath = path;
		File file = new File(filePath);
		file.mkdir();
		String imgfileName = TestDriver.sTest_Case_ID+"_" + Reporter.getCurrentTimeStamp("yyyy_MM_dd_hh_mm_ss_a") + ".png"; //"yyyy_MM_dd:hh:mm:ss a"
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(
				Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "PNG", new File(filePath + "\\" + imgfileName));
		return imgfileName;
	}
}
