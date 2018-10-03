package io.pivotal.pal.tracker;

import java.util.*;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository{

    private HashMap<Long, TimeEntry> timeEntries = new HashMap<Long, TimeEntry> ();

    public TimeEntry create(TimeEntry timeEntry) {

        Long id = timeEntries.size() + 1L;

        timeEntry.setId(id);

        timeEntries.put(id,timeEntry);

        return  timeEntry;
    }

    public TimeEntry find(Long id) {

        TimeEntry foundTimeEntry = timeEntries.get(id);

        return foundTimeEntry;
    }

    public List<TimeEntry> list() {

        Collection<TimeEntry> values = timeEntries.values();

        return new ArrayList<TimeEntry>(values);
    }

    public TimeEntry update(Long id, TimeEntry timeEntry) {

        TimeEntry selected = find(id);

        if (selected != null)
        {
            timeEntries.remove(id);
            return create(timeEntry);
        }
        return null;
    }

    public void delete(Long id) {

        TimeEntry selected = find(id);

        if (selected != null)
        {
            timeEntries.remove(id);
        }
    }
}
