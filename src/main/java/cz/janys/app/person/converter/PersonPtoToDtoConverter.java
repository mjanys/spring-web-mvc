package cz.janys.app.person.converter;

import cz.janys.app.person.pto.PersonPto;
import cz.janys.iface.convert.converter.AbstractExtendedConverter;
import cz.janys.iface.dto.PersonDto;
import org.springframework.stereotype.Component;

/**
 * @author Martin Janys
 */
@Component
public class PersonPtoToDtoConverter extends AbstractExtendedConverter<PersonPto, PersonDto> {

    @Override
    public PersonDto convert(PersonPto source, PersonDto target) {
        target.setId(source.getId());
        target.setName(source.getName());
        target.setEmail(source.getEmail());
        return target;
    }

    @Override
    public PersonDto convert(PersonPto source) {
        return convert(source, new PersonDto());
    }
}
