package cn.com.sinosafe.xiecommon.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Hashtable;

/**
 * @PACKAGE_NAME: cn.com.sinosafe.agent.common.utils
 * @NAME: QrCodeCreateUtil
 * @description: ${description}
 * @USER: xiehanchun
 * @time: 2020/2/25 16:33
 * @Version 1.0
 **/
public class QRCodeGenerator {
    private static final String QR_CODE_IMAGE_PATH = "D:/huaan/MyQRCode.png";

    /**
     * @Description: 保存信息为二维码图片
     * @Param: [text, width, height, filePath]
     * @Return: void
     * @Author: xiehanchun
     * @Date: 2020/2/25
     */
    private static void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height,hints);

        Path path = FileSystems.getDefault().getPath(filePath);

        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }

    /**
     * @Description: 保存信息为字节数组
     * @Param: [text, width, height]
     * @Return: byte[]
     * @Author: xiehanchun
     * @Date: 2020/2/25
     */
    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }

  /*  public static void main(String[] args) {
        try {
            generateQRCodeImage("www", 350, 350, QR_CODE_IMAGE_PATH);
            System.out.println("二维码已生成 地址--->"+QR_CODE_IMAGE_PATH);
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

    }*/
}
