package model.log;

import java.util.ArrayList;
import java.util.List;

public class LogService implements Log{

    private final List<String> events = new ArrayList<>();
    @Override
    public void appendEvent(String event) {
        events.add(event);
    }

    @Override
    public String getEvents() {
        return events.toString();
    }

    @Override
    public void clear() {
        events.clear();
    }
}
