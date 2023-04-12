package model.log;

public interface Log {
    void appendEvent(String event);
    String getEvents();
    String getEvent(int id);

    void clear();
}
