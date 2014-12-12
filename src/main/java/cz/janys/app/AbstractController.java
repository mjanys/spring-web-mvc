package cz.janys.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import static cz.janys.app.Constants.*;

/**
 * @author Martin Janys
 */
@Controller
public class AbstractController {

    @Autowired
    MessageSource messageSource;

    private static final String SUCCESS = "success";
    private static final String ERROR = "danger";
    private static final String INFO = "info";
    private static final String WARNING = "warning";

    public static enum MessageType {

        SUCCESS(AbstractController.SUCCESS),
        ERROR(AbstractController.ERROR),
        INFO(AbstractController.INFO),
        WARNING(AbstractController.WARNING);

        private final String value;

        MessageType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static final String MESSAGES = "flashMessages";

    protected String redirect(String location) {
        return REDIRECT_PREFIX + location;
    }

    @SuppressWarnings("unchecked")
    private Map<String, List<String>> getMessages(Model model) {
        Map<String, Object> modelMap = model.asMap();
        Object messages = modelMap.get(MESSAGES);
        if (messages != null)
            return (Map<String, List<String>>) messages;
        model.addAttribute(MESSAGES, createEmptyMessages());
        return (Map<String, List<String>>) modelMap.get(MESSAGES);
    }

    private Map<String, List<String>> createEmptyMessages() {
        Map<String, List<String>> messages = new HashMap<String, List<String>>(3);
        for (MessageType messageType : MessageType.values()) {
            messages.put(messageType.getValue(), new ArrayList<String>());
        }
        return messages;
    }

    protected void addFlashMessage(MessageType messageType, Model model, String message, String ... args) {
        Map<String, List<String>> messages = getMessages(model);
        if (messages == null) {
            messages = createEmptyMessages();
            model.addAttribute(MESSAGES, message);
        }
        List<String> messageList = messages.get(messageType.getValue());
        messageList.add(messageBundle(message, args));
    }

    private String messageBundle(String message, String ... args) {
        return messageSource.getMessage(message, args, Locale.getDefault());
    }

    protected void addSuccessMessage(Model model, String message, String ... args) {
        addFlashMessage(MessageType.SUCCESS, model, message, args);
    }

    protected void addInfoMessage(Model model, String message, String ... args) {
        addFlashMessage(MessageType.INFO, model, message, args);
    }

    protected void addErrorMessage(Model model, String message, String ... args) {
        addFlashMessage(MessageType.ERROR, model, message, args);
    }

    protected void addWarningMessage(Model model, String message, String ... args) {
        addFlashMessage(MessageType.WARNING, model, message, args);
    }
}
