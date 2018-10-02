package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    @Autowired
    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }


    @PostMapping("/time-entries")
    public ResponseEntity create(TimeEntry timeEntryToCreate) {

        TimeEntry timeEntry = timeEntryRepository.create(timeEntryToCreate);

        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.CREATED);
    }

    public ResponseEntity<TimeEntry> read(long l) {

            TimeEntry timeEntry = timeEntryRepository.find(l);

        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);

    }

    public ResponseEntity<List<TimeEntry>> list() {

        List<TimeEntry> timeEntries = timeEntryRepository.list();

        return new ResponseEntity<List<TimeEntry> >(timeEntries, HttpStatus.OK);

    }

    public ResponseEntity update(long l, TimeEntry expected) {
        TimeEntry timeEntry = timeEntryRepository.update(l,expected);

        if(timeEntry == null){
            return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);
    }

    public ResponseEntity<TimeEntry> delete(long l) {
        return null;
    }
}
