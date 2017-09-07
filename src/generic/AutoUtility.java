package generic;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;

public class AutoUtility {

	public static void getScreenshot(String path) {
		try {
			Robot r = new Robot();
			Dimension screenshot = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRec = new Rectangle(screenshot);
			BufferedImage image = r.createScreenCapture(screenRec);
			ImageIO.write(image, "png", new File(path));
		} catch (Exception e) {

		}
	}

	public static String timeScreen() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_mm_ss");
		String timestamp = sdf.format(new Date());
		return timestamp;
	}

	public static String getProperty(String path, String key) {
		String value = " ";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			value = p.getProperty(key);
		} catch (Exception e) {

		}
		return value;
	}
}
