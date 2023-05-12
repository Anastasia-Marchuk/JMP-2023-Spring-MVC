package jmp.amarchuk.facade;


import jmp.amarchuk.model.Category;
import jmp.amarchuk.model.Event;
import jmp.amarchuk.model.Ticket;
import jmp.amarchuk.model.User;
import jmp.amarchuk.service.EventServiceImpl;
import jmp.amarchuk.service.TicketServiceImpl;
import jmp.amarchuk.service.UserServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * BookingFacade implementation - which delegates method calls to services.
 *
 * @author Anastasiya Marchuk
 *
 */
public class BookingFacadeImpl implements BookingFacade {

    private final EventServiceImpl eventServiceImpl;
    private final TicketServiceImpl ticketServiceImpl;
    private final UserServiceImpl userServiceImpl;

    public BookingFacadeImpl(EventServiceImpl eventServiceImpl, TicketServiceImpl ticketServiceImpl, UserServiceImpl userServiceImpl) {
        this.eventServiceImpl = eventServiceImpl;
        this.ticketServiceImpl = ticketServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventServiceImpl.getEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventServiceImpl.getEventsByTitle(title, pageSize, pageNum);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventServiceImpl.getEventsForDay(day, pageSize, pageNum);
    }

    @Override
    public Event createEvent(Event event) {
        return eventServiceImpl.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventServiceImpl.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventServiceImpl.deleteEvent(eventId);
    }

    @Override
    public User getUserById(long userId) {
        return userServiceImpl.getUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userServiceImpl.getUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userServiceImpl.getUsersByName(name, pageSize, pageNum);
    }

    @Override
    public User createUser(User user) {
        return userServiceImpl.createUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @Override
    public User updateUser(User user) {
        return userServiceImpl.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userServiceImpl.deleteUser(userId);
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return ticketServiceImpl.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketServiceImpl.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketServiceImpl.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketServiceImpl.cancelTicket(ticketId);
    }

    @Override
    public void preloadTickets(MultipartFile file) {
        ticketServiceImpl.preloadTickets(file);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketServiceImpl.getAllTickets();
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketServiceImpl.createTicket(ticket);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventServiceImpl.getAllEvents();
    }
}
