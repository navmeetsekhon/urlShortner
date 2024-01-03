package com.giovanni.urlShortner.services;
import java.io.IOException;
import java.nio.file.Files;

// import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
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
    public ResponseEntity<byte[]> generateQr(QrRequest req) throws IOException{
        System.out.println(req);
        String data = req.getUrl();
        String filePath = "src/main/resources/static/QrCodes/qrCode.png";
        String fileType = "png";
        int qrCodeSize = 300;
        try {
            qrCodeGenerator.generateQRCode(data, filePath, fileType, qrCodeSize);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        // QrResponse response=QrResponse.builder().path(filePath).build();
        
        Resource resource = new ClassPathResource("static/QrCodes/qrCode.png");
        byte[] imageByte = Files.readAllBytes(resource.getFile().toPath());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(imageByte);
    }
}
