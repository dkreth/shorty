package com.dkreth.shorty.data;

import com.dkreth.shorty.model.Record;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RecordInMemoryRepository {
    Map<String, Record> repo = new HashMap<>();
    public Record insert(Record record){
        return repo.put(record.getShortId(), record);
    }
    public Record findByShortId(String shortId) {
        return repo.get(shortId);
    }
}
