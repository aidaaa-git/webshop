package org.webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webshop.models.Watch;
import org.webshop.repositories.WatchRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WatchService {
    private WatchRepository repository;

    public WatchService(WatchRepository repository) {
        this.repository = repository;
    }

    public List<Watch> getWatchesPerCategory(Integer categoryId) {
        List<Watch> watches = repository.getWatchesPerCategory(categoryId);
        return watches;
    }

    public List<Watch> getWatchesPerSubcategory(Integer subcategoryId) {
        List<Watch> watches = repository.getWatchesPerSubcategory(subcategoryId);
        return watches;
    }

    public void addWatch(Watch watch){ repository.addWatch(watch);}
    public void updateWatch(Watch watch){ repository.updateWatch(watch); }
    public void deleteWatch(Integer id){ repository.deleteWatch(id);}
    //public List<Watch> getWatchById(Integer id){
      //  return repository.getWatchById(id);
    //}
    public Watch getWatchById(Integer id){
        return repository.getWatchById(id);
    }




}
