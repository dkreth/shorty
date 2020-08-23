package com.dkreth.shorty.controller;

import com.dkreth.shorty.data.RecordRepository;
import com.dkreth.shorty.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
public class RecordController {

    @Autowired
    private RecordRepository recordRepository;

    @GetMapping("test")
    public Record testPath() {
        return new Record("test", "test");
    }

    @GetMapping("list")
    public List<Record> list() {
        List<Record> list = recordRepository.findAll();
        return list;
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
    public ResponseEntity<URL> redirect(@PathVariable String shortId) {
        Record record = recordRepository.findByShortId(shortId);
        if (record == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        URL url;
        try {
            url = new URL("http://" + record.getLongUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(url, HttpStatus.PERMANENT_REDIRECT);
    }
}
