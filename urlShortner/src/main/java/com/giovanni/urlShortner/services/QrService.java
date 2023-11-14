package com.giovanni.urlShortner.services;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovanni.urlShortner.QrGenerator.QrCodeGenerator;
import com.giovanni.urlShortner.dto.QrRequest;
import com.giovanni.urlShortner.dto.QrResponse;

@Service
public class QrService {
    @Autowired
    QrCodeGenerator qrCodeGenerator;
    public QrResponse generateQr(QrRequest req){
        String data = req.getUrl();
        System.out.println(data);
        String filePath = "src/main/resources/static/QrCodes/qrCode.png";
        // file:///home/navmeet/Desktop/computer%20programs/projects/url-shortner/urlShortner/src/main/resources/static/QrCodes/qrCode.png
        String fileType = "png";
        int qrCodeSize = 300;

        try {
            qrCodeGenerator.generateQRCode(data, filePath, fileType, qrCodeSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        QrResponse response=QrResponse.builder().path(filePath).build();
        return response;
    }
}
