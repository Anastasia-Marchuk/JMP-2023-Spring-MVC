package jmp.amarchuk.service;


import jmp.amarchuk.dao.EventDao;
import jmp.amarchuk.model.Event;

import java.util.Date;
import java.util.List;

/**
 * EventService implementation - which contains event and booking-related functionality accordingly.
 *
 * @author Anastasiya Marchuk
 *
 */
public class EventServiceImpl implements EventService {

    EventDao eventDao;

    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventDao.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDao.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDao.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventDao.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDao.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventDao.deleteEvent(eventId);
    }

    public List<Event> getAllEvents() {
       return eventDao.getAllEvents();
    }
}
