package com.dkreth.shorty.controller;

import com.dkreth.shorty.data.RecordRepository;
import com.dkreth.shorty.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RecordController {

    //TODO - change this to a MongoDB implementation
//    private final RecordInMemoryRepository recordRepository = new RecordInMemoryRepository();

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("test")
    public Record testPath() {
        return new Record("test", "test");
    }

    @PostMapping("/generate")
    public ResponseEntity generate(@RequestBody Record newRecord){
        Record foundRecord = recordRepository.findByShortId(newRecord.getShortId());
        if(foundRecord != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity(recordRepository.insert(newRecord), HttpStatus.CREATED);
    }

    @GetMapping("/{shortId}")
    public RedirectView redirect(@PathVariable String shortId) {
        Record record = recordRepository.findByShortId(shortId);
        //TODO - 404 if record is null
        return new RedirectView("http://" + record.getLongUrl());
    }
}
