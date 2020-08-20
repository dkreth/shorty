package com.dkreth.shorty.controller;

import com.dkreth.shorty.data.RecordInMemoryRepository;
import com.dkreth.shorty.model.Record;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RecordController {

    //TODO - change this to a MongoDB implementation
    private final RecordInMemoryRepository recordRepository = new RecordInMemoryRepository();

    @GetMapping("test")
    public Record testPath() {
        return new Record("test", "test");
    }

    @PostMapping("/generate")
    public Record generate(@RequestBody Record newRecord){
        //TODO - 422 if the provided shortId already exists
        return recordRepository.saveRecord(newRecord);
    }

    @GetMapping("/{shortId}")
    public RedirectView redirect(@PathVariable String shortId) {
        Record record = recordRepository.getRecordByShortId(shortId);
        //TODO - 404 if record is null
        return new RedirectView("http://" + record.getLongUrl());
    }
}
