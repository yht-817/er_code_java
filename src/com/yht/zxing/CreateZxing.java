package com.yht.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 *生成二维码
 * @author Administrator
 *
 */
public class CreateZxing {

	public static void main(String[] args) {

		int height = 300;
		int width  = 300;
		String format="png";
		String url = "www.baidu.com";
		//定义二维码的参数
		HashMap h = new HashMap();
		h.put(EncodeHintType.CHARACTER_SET,"utf-8");//字符集
		h.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//纠错等级
		h.put(EncodeHintType.MARGIN, 2);//图片的边距
		
		//生成二维码
		try {
			/*
			 * BarcodeFormat.QR_CODE 二维码的的格式
			 */
			BitMatrix bitMatrix = new MultiFormatWriter().encode(url,BarcodeFormat.QR_CODE, width, height,h);
	        
			Path file = new File("E:/img.png").toPath();//生成图片路径
			
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
