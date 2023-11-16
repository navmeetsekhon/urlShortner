package com.giovanni.urlShortner.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Component
public class QrCodeGenerator {

    public void generateQRCode(String data, String filePath, String fileType, int qrCodeSize)
            throws IOException {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize);

            BufferedImage bufferedImage = new BufferedImage(qrCodeSize, qrCodeSize, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < qrCodeSize; x++) {
                for (int y = 0; y < qrCodeSize; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            File qrCodeFile = new File(filePath);
            ImageIO.write(bufferedImage, fileType, qrCodeFile);

            System.out.println("QR Code generated successfully at: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
