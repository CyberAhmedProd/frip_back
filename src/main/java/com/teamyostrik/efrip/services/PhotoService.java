package com.teamyostrik.efrip.services;

import java.io.IOException;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.teamyostrik.efrip.models.Photo;
import com.teamyostrik.efrip.repositories.PhotoRepository;

@Service
public class PhotoService {


    private final PhotoRepository photoRepo;
    @Autowired
    public PhotoService(PhotoRepository photoRepo) {
        this.photoRepo = photoRepo;
    }

    public String addPhoto(String title, MultipartFile file) throws IOException { 
        Photo photo = new Photo();
        photo.setTitle(title);
        photo.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo = photoRepo.save(photo);
        return photo.getId();
    }
    public String updatePhoto(String id ,String title, MultipartFile file) throws IOException { 
        Optional<Photo> photo = photoRepo.findById(id);
        if(photo.isPresent()) {
        	Photo imgData = photo.get();
        	imgData.setTitle(title);
        	imgData.setImage(
            new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
            return photoRepo.save(imgData).getId();
             
        }
        return null;
    }

    public Photo getPhoto(String id) { 
        return photoRepo.findById(id).get(); 
    }
    public void deletePhoto(String id) {
        photoRepo.deleteById(id);
    }
}
