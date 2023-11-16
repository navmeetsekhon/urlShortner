package com.giovanni.urlShortner.services;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giovanni.urlShortner.dto.QrRequest;
import com.giovanni.urlShortner.dto.QrResponse;
import com.giovanni.urlShortner.util.QrCodeGenerator;

@Service
public class QrService {
    @Autowired
    QrCodeGenerator qrCodeGenerator;
    public QrResponse generateQr(QrRequest req){
        String data = req.getUrl();
        String filePath = "src/main/resources/static/QrCodes/qrCode.png";
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
