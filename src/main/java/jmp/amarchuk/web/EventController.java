package jmp.amarchuk.web;

import jmp.amarchuk.facade.BookingFacade;
import jmp.amarchuk.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * EventController implementation - annotation-based controller that will delegate to BookingFacade methods.
 *
 * @author Anastasiya Marchuk
 *
 */
@Controller
public class EventController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);

    BookingFacade bookingFacade;

    public EventController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }



    @GetMapping("/allEvents")
    public String getAllTickets(Model model) {
        LOGGER.debug("Get all tickets");
        List<Event> allEvents = bookingFacade.getAllEvents();
        model.addAttribute("allEvents", allEvents);
        model.addAttribute("heading", "List of all events in DB");
        return "list_events";
    }

    @GetMapping("/newEvent")
    public String create() {
        LOGGER.debug("Create new event ");
        return "new_event";
    }

    @GetMapping("/createEvent")
    public String name(@RequestParam("title") String title) {
        LOGGER.debug("Create user with name ({})", title);
        Event event=new Event();
        event.setTitle(title);
        bookingFacade.createEvent(event);
        LOGGER.info("Method start. UserController.");
        return "redirect:/";
    }

}
