package jmp.amarchuk.dao;

import jmp.amarchuk.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Event DAO object for the domain model (Event).
 *
 * @author Anastasiya Marchuk
 *
 */
@Repository
public class EventDaoList implements EventDao {

    @Autowired
    private List<Event> events;

    public EventDaoList(List<Event> list) {
        this.events=list;
    }

    public EventDaoList() {

    }

    @Override
    public Event getEventById(long eventId) {
        return events.stream().filter(o -> o.getId() == eventId).findAny().get();
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return events.stream().filter(o -> o.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return events.stream().filter(o -> o.getDate().equals(day)).collect(Collectors.toList());
    }

    @Override
    public Event createEvent(Event event) {
        long id =events.size()+1;
        for (int i = 0; i < events.size(); i++) {
            if (id==events.get(i).getId()){
                id++;
            }
        }
        event.setId(id);
        event.setDate(new Date());
        events.add(event);
        return event;
    }

    @Override
    public Event updateEvent(Event event) {
        events.remove(events.stream().filter(o -> o.getId()==event.getId()).collect(Collectors.toList()).get(0));
        events.add(event);
        return events.get((int) event.getId());
    }

    @Override
    public boolean deleteEvent(long eventId) {
        Event event = events.get((int) eventId);
        return events.remove(event);
    }

    @Override
    public int size() {
        return events.size();
    }

    @Override
    public List<Event> getAllEvents() {
        return events;
    }

    public int sizeEvent() {
        return events.size();
    }

    public boolean deleteAllEvents() {
        for (int i = events.size(); i>=0 ; i--) {
            if(events.isEmpty()){
                return true;
            }
            events.remove(events.get(i-1));
        }
        return events.size() == 0;
    }
}
