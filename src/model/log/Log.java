package model.log;

public interface Log {
    void appendEvent(String event);
    String getEvents();

    void clear();
}
