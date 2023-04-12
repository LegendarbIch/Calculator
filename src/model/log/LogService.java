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
        int i = 0;
        StringBuilder result = new StringBuilder();
        for (String str: events) {
            result.append(i).append(". ").append(str).append("\n");
            i++;
        }
        return result.toString();
    }

    public String getEvent(int id) {
        return events.get(id);
    }

    @Override
    public void clear() {
        events.clear();
    }
}
