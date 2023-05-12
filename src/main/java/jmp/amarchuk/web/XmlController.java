package jmp.amarchuk.web;

import jmp.amarchuk.facade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * XMLController implementation - controller helps to load xml file on UI page.
 *
 * @author Anastasiya Marchuk
 *
 */
@Controller
public class XmlController {

    @Autowired
    BookingFacade bookingFacade;

    @PostMapping(value = "/xml", produces = MediaType.TEXT_HTML_VALUE)
    public String getPageXml(@RequestParam("file") MultipartFile file) {
        bookingFacade.preloadTickets(file);
        return "redirect:/allTickets";
    }
}
