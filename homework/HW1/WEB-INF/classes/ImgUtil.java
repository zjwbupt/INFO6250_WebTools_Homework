
import java.awt.image.BufferedImage;

import java.io.FileInputStream;

import java.io.IOException;

 

import javax.imageio.ImageIO;

import javax.servlet.ServletOutputStream;

import javax.servlet.http.HttpServletResponse;

 

public class ImgUtil {

 

	public static final String JPG = "jpg";

	public static final String PNG = "png";

	public static final String BMP = "bmp";

	public static final String GIF = "gif";

 

	/**

	 * 在servlet中调用该方法, jsp页面中img标签的src指向该servlet, 则会显示图片

	 * 

	 * @param response

	 * @param path

	 * @param isResponseClose

	 */

	public static void showImage(HttpServletResponse response, String path, boolean isResponseClose) {

		try {

			ServletOutputStream outStream = response.getOutputStream();// 得到向客户端输出二进制数据的对象

			FileInputStream fis = new FileInputStream(path); // 以byte流的方式打开文件

			byte data[] = new byte[1000];

			while (fis.read(data) > 0) {

				outStream.write(data);

			}

			fis.close();

			response.setContentType("image/*"); //set the return type
			outStream.write(data); // 输出数据

			if (isResponseClose) {

				outStream.close();

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

 

	/**

	 * 在servlet中调用该方法, jsp页面中img标签的src指向该servlet, 则会显示图片

	 * 

	 * @param response

	 * @param data

	 * @param isResponseClose

	 */

	public static void showImage(HttpServletResponse response, byte[] data, boolean isResponseClose) {

		try {

			ServletOutputStream outStream = response.getOutputStream();// 得到向客户端输出二进制数据的对象
			//read data
			outStream.write(data);

			response.setContentType("image/*"); // set the return type
			outStream.write(data); // 输出数据

			if (isResponseClose) {

				outStream.close();

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

 

	/**

	 * 在servlet中调用该方法, jsp页面中img标签的src指向该servlet, 则会显示图片

	 * 

	 * @param response

	 * @param image

	 * @param imgType

	 * @param isResponseClose

	 */

	public static void showImage(HttpServletResponse response, BufferedImage image, String imgType, boolean isResponseClose) {

		try {

			ImageIO.write(image, imgType, response.getOutputStream());

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

 

}
