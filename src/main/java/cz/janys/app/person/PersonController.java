package cz.janys.app.person;

import cz.janys.app.AbstractController;
import cz.janys.app.person.converter.PersonPtoToDtoConverter;
import cz.janys.app.person.converter.PersonDtoToPtoConverter;
import cz.janys.app.person.pto.PersonPto;
import cz.janys.iface.dto.PersonDto;
import cz.janys.iface.service.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.validation.Valid;

import static cz.janys.app.person.PersonConstants.*;

/**
 * @author Martin Janys
 */
@Controller
@RequestMapping("/person")
public class PersonController extends AbstractController {

    private static final Logger LOG = Logger.getLogger(PersonController.class);

    @Autowired
    private PersonService service;

    @Autowired
    private PersonPtoToDtoConverter ptoToDto;
    @Autowired
    private PersonDtoToPtoConverter dtoToPto;

    @RequestMapping
    public String defaultView(
            Model model,
            ServletRequest request,
            ServletResponse response) {

        model.addAttribute(ATTR_ITEMS, service.findAllPersons());

        return VIEW_MAIN;
    }

    @RequestMapping(PERSON_DETAIL_PAGE)
    public String detail(
            @PathVariable(PARAM_ID) long id,
            Model model,
            ServletRequest request,
            ServletResponse response) {

        model.addAttribute(ATTR_PERSON_DTO, service.findPersonById(id));

        return VIEW_DETAIL;
    }

    @RequestMapping(PERSON_CREATE_PAGE)
    public String create(
            Model model,
            ServletRequest request,
            ServletResponse response) {

        if (!model.containsAttribute(ATTR_PERSON_PTO)) {
            model.addAttribute(ATTR_PERSON_PTO, new PersonPto());
        }

        return VIEW_CREATE_FORM;
    }

    @RequestMapping(PERSON_FORM_EDIT_PAGE)
    public String editForm(
            @PathVariable(PARAM_ID) Long id,
            Model model,
            ServletRequest request,
            ServletResponse response) {

        if (!model.containsAttribute(ATTR_PERSON_PTO)) {
            PersonDto s = service.findPersonById(id);
            PersonPto pto = dtoToPto.convert(s);
            model.addAttribute(ATTR_PERSON_PTO, pto);
        }

        return VIEW_EDIT_FORM;
    }

    @RequestMapping(value = ACTION_CREATE, method = RequestMethod.POST)
    public String createPerson(
            @Valid @ModelAttribute(ATTR_PERSON_PTO) PersonPto pto,
            BindingResult result,
            ServletRequest request,
            ServletResponse response,
            Model model,
            RedirectAttributes redirectAttrs) {

        if (!result.hasErrors()) {
            PersonDto dto = ptoToDto.convert(pto);

            if (dto.getId() == null) {
                dto = service.createPerson(dto);
                addSuccessMessage(model, "msg-person-saved");
            }
            else {
                dto = service.updatePerson(dto);
                addSuccessMessage(model, "msg-person-created");
            }

            redirectAttrs.addAttribute(PARAM_ID, dto.getId().toString());
            return redirect(PERSON_CONTEXT_PATH + PERSON_DETAIL_PAGE);
        }
        else {
            addErrorMessage(model, "msg-common-err-form-contains-errors");
            return VIEW_CREATE_FORM;
        }
    }

    @RequestMapping(value = ACTION_UPDATE, method = RequestMethod.POST)
    public String savePerson(
            @Valid @ModelAttribute(ATTR_PERSON_PTO) PersonPto pto,
            BindingResult result,
            ServletRequest request,
            ServletResponse response,
            Model model,
            RedirectAttributes redirectAttrs) {

        if (!result.hasErrors()) {
            PersonDto dto = service.findPersonById(pto.getId());
            PersonDto updatedDto = ptoToDto.convert(pto);
            updatedDto.setId(dto.getId());

            service.updatePerson(dto);



            redirectAttrs.addAttribute(PARAM_ID, String.valueOf(dto.getId()));
            return redirect(PERSON_DETAIL_PAGE);
        }
        else {
            addErrorMessage(redirectAttrs, "msg-common-err-form-contains-errors");

            redirectAttrs.addAttribute(PARAM_ID, pto.getId().toString());
            return redirect(PERSON_FORM_EDIT_PAGE);
        }
    }

    @RequestMapping(value = ACTION_DELETE, method = RequestMethod.POST)
    public String deletePerson(
            @RequestParam(PARAM_ID) Long id,
            ServletRequest request,
            ServletResponse response,
            Model model) {

        PersonDto dto = service.findPersonById(id);
        service.deletePersonById(id);

        addSuccessMessage(model, "msg-hello-person-deleted", dto.getName());

        return redirect(PERSON_CONTEXT_PATH);
    }
}
