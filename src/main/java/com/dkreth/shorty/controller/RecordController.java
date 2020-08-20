package com.dkreth.shorty.controller;

import com.dkreth.shorty.data.RecordInMemoryRepository;
import com.dkreth.shorty.model.Record;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RecordController {

    private final RecordInMemoryRepository recordRepository = new RecordInMemoryRepository();

    @GetMapping("test")
    public Record testPath() {
        return new Record("test", "test");
    }

    @PostMapping("/generate")
    public Record generate(@RequestBody Record newRecord){
        return recordRepository.saveRecord(newRecord);
    }

    @GetMapping("/{shortId}")
    public RedirectView redirect(@PathVariable String shortId) {
        Record record = recordRepository.getRecordByShortId(shortId);
        return new RedirectView("http://" + record.getLongUrl());
    }
}
