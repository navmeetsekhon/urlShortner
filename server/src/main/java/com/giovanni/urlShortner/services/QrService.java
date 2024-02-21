package com.giovanni.urlShortner.services;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

// import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.giovanni.urlShortner.dto.QrRequest;
// import com.giovanni.urlShortner.dto.QrResponse;
import com.giovanni.urlShortner.util.QrCodeGenerator;

@Service
public class QrService {
    @Autowired
    QrCodeGenerator qrCodeGenerator;
    public ResponseEntity<byte[]> generateQr(QrRequest req) {
        String data = req.getUrl();
        String filePath = "server/src/main/resources/static/QrCodes/qrCode.png";
        String fileType = "png";
        int qrCodeSize = 300;
        try {
            qrCodeGenerator.generateQRCode(data, filePath, fileType, qrCodeSize);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // QrResponse response=QrResponse.builder().path(filePath).build();
        try{
            File imageFile = new File(filePath);
            byte[] imageByte = Files.readAllBytes(imageFile.toPath());
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(imageByte);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }
}
