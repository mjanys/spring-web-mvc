package cz.janys.app.person;

import cz.janys.app.Constants;

/**
 * @author Martin Janys
 */
public class PersonConstants extends Constants {

    public static final String PERSON_CONTEXT_PATH = "/person";
    public static final String PERSON_DETAIL_PAGE = "/{"+PARAM_ID+"}";
    public static final String PERSON_FORM_EDIT_PAGE = "/edit/{"+PARAM_ID+"}";
    public static final String PERSON_CREATE_PAGE = "/create";

    public static final String ACTION_CREATE = "create";
    public static final String ACTION_UPDATE = "update";
    public static final String ACTION_DELETE = "delete";

    public static final String VIEW_MAIN = "person/view";
    public static final String VIEW_CREATE_FORM = "person/view_create";
    public static final String VIEW_EDIT_FORM = "person/view_edit";
    public static final String VIEW_DETAIL = "person/view_detail";

    public static final String ATTR_ITEMS = "items";
    public static final String ATTR_PERSON_PTO = "personPto";
    public static final String ATTR_PERSON_DTO = "person";
}
