package com.giovanni.urlShortner.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseInitialization {
    @PostConstruct
    public void initialization(){
        FileInputStream serviceAccount = null;
        try {
            InputStream serviceAccountStream = getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");

            if (serviceAccountStream == null) {
                throw new IOException("serviceAccountKey.json not found in the classpath");
            }

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccountStream))
                    .build();

            FirebaseApp.initializeApp(options);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
