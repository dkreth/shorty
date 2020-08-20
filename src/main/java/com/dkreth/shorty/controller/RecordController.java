package com.dkreth.shorty.controller;

import com.dkreth.shorty.model.Record;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

    @GetMapping("test")
    public Record testPath() {
        return new Record("test", "test");
    }
}
