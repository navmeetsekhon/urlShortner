package com.giovanni.urlShortner.services;

import com.giovanni.urlShortner.dto.ShortUrlRequest;
import com.giovanni.urlShortner.dto.ShortUrlResponse;
import com.giovanni.urlShortner.models.UrlEntity;
import com.giovanni.urlShortner.util.ShortUrlUtil;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UrlService {
    @Autowired
    private ShortUrlUtil shortUrlUtil;

    private static final String COLLECTION_NAME = "url_table";

    public ShortUrlResponse shortenUrl(ShortUrlRequest shortUrlRequest) {
        String fullUrl = shortUrlRequest.getUrl();
        try {
            Firestore dbFirestore = FirestoreClient.getFirestore();
            Query query = dbFirestore.collection(COLLECTION_NAME).whereEqualTo("originalUrl", fullUrl);
            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();

            if (!documents.isEmpty()) {
                // If the original URL already exists, return the existing short URL key
                String existingKey = documents.get(0).getId();
                return ShortUrlResponse.builder().key(existingKey).build();
            }

            String newKey = shortUrlUtil.generateUniqueKey();
            UrlEntity newEntity = UrlEntity.builder().originalUrl(fullUrl).clickCount(0L).build();

            dbFirestore.collection(COLLECTION_NAME).document(newKey).set(newEntity);
            return ShortUrlResponse.builder().key(newKey).build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public RedirectView getFullUrl(String key) {
        try {
            Firestore dbFirestore = FirestoreClient.getFirestore();
            DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(key);
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot document = future.get();
            UrlEntity object = null;
            if (document.exists()) {
                object = document.toObject(UrlEntity.class);
                long updatedClickCount = object.getClickCount() + 1;

                // Update the document with the new click_count
                ApiFuture<WriteResult> updateFuture = documentReference.update("clickCount", updatedClickCount);

                // Wait for the update to complete
                updateFuture.get();
                return new RedirectView(object.getOriginalUrl());
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/not-found");
        }
    }
}
