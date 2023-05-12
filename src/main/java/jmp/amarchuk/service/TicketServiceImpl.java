package jmp.amarchuk.service;


import jmp.amarchuk.dao.TicketDao;
import jmp.amarchuk.dao.TicketDaoList;
import jmp.amarchuk.model.Category;
import jmp.amarchuk.model.Event;
import jmp.amarchuk.model.Ticket;
import jmp.amarchuk.model.User;
import jmp.amarchuk.service.parser.Jackson;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * TicketService implementation - which contains ticket and booking-related functionality accordingly.
 *
 * @author Anastasiya Marchuk
 *
 */
public class TicketServiceImpl implements TicketService {

    TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return ticketDao.bookTicket(userId, eventId, place, category);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return ticketDao.getBookedTickets(user, pageSize, pageNum);
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return ticketDao.getBookedTickets(event, pageSize, pageNum);
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketDao.cancelTicket(ticketId);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketDao.createTicket(ticket);
    }

    public void preloadTickets(MultipartFile file) {

        TicketDaoList ticketDto = null;
        try {
            ticketDto = new Jackson(file).loaderXmlFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Ticket> tickets=ticketDto.getTickets();
        //Map<String, Ticket> tickets = ticketDto.getTickets();
        ticketDao.preloadTickets(tickets);
    }


}
