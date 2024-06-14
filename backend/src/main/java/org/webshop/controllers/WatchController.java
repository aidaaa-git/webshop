package org.webshop.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webshop.models.Watch;
import org.webshop.services.WatchService;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/watch")
 public class WatchController {
    private WatchService watchService;
    public WatchController(WatchService watchService){
        this.watchService = watchService;
    }
    @GetMapping("/getWatchesPerCategory")
    public List<Watch> getWatchesPerCategory(@RequestParam Integer categoryId){
        List<Watch> watches = watchService.getWatchesPerCategory(categoryId);
        return  watches;
    }
    @GetMapping("/getWatchesPerSubcategory")
    public List<Watch> getWatchesPerSubcategory(@RequestParam Integer subcategoryId){
        List<Watch> watches = watchService.getWatchesPerSubcategory(subcategoryId);
        return watches;
    }

    @PostMapping("/addWatch")
    public ResponseEntity<String>  addWatch(@RequestBody Watch watch){
        watchService.addWatch(watch);
        return ResponseEntity.ok("Watch added.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWatch(@PathVariable Integer id, @RequestBody Watch watch){
        watch.setId(id);
        watchService.updateWatch(watch);
        return ResponseEntity.ok("Watch updated.");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteWatch(@PathVariable Integer id){
        watchService.deleteWatch(id);
        return  ResponseEntity.ok("Watch deleted.");
    }

   /* @GetMapping("/{id}")
    public ResponseEntity<Watch> getWatchById(@PathVariable Integer id) {
        Watch watch = watchService.getWatchById(id);
        return ResponseEntity.ok(watch);
    }*/
    //@GetMapping("/getWatchById")
    //public List<Watch> getWatchById(@RequestParam Integer id){
        //List<Watch> watch = watchService.getWatchById(id);
        //return watch;
    //}
    @GetMapping("/getWatchById")
    public Watch getWatchById(@RequestParam Integer id){
        Watch watch = watchService.getWatchById(id);
        return watch;
    }








}
