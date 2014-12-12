package cz.janys.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static cz.janys.app.Constants.*;

/**
 * @author Martin Janys
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping
    public String index() {
        return INDEX_VIEW;
    }

}
