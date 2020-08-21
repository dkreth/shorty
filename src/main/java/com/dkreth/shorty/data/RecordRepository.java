package com.dkreth.shorty.data;

import com.dkreth.shorty.model.Record;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RecordRepository extends MongoRepository<Record, String> {

    public Record findByShortId(String shortId);
}
