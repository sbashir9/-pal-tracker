package io.pivotal.pal.tracker;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry any);

    public TimeEntry find(Long l);

    public List<TimeEntry> list();

    public TimeEntry update(Long eq, TimeEntry any);

    public void delete(Long l) ;
}
