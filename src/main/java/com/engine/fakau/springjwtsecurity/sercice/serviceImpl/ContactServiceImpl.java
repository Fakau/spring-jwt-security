package com.engine.fakau.springjwtsecurity.sercice.serviceImpl;

import com.engine.fakau.springjwtsecurity.domaine.Contact;
import com.engine.fakau.springjwtsecurity.dto.ContactDTO;
import com.engine.fakau.springjwtsecurity.exception.BadRequestException;
import com.engine.fakau.springjwtsecurity.repository.ContactRepository;
import com.engine.fakau.springjwtsecurity.sercice.ContactService;
import com.engine.fakau.springjwtsecurity.sercice.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactMapper contactMapper;

    public ContactDTO create(ContactDTO dto){
        Contact contact = contactMapper.toEntity(dto);
        if(contact.getId() != null){
           throw new BadRequestException("Cannot create contact with id != null");
        }
        return contactMapper.toDTO(contactRepository.save(contact));
    }
    public ContactDTO update(ContactDTO dto){
        Contact contact = contactMapper.toEntity(dto);
        if(contact.getId() == null){
           throw new BadRequestException("Cannot update contact with id null");
        }
        return contactMapper.toDTO(contactRepository.save(contact));
    }
    public void delete(final Long id){
        if(id == null){
           throw new IllegalArgumentException("id must not be null");
        }
        contactRepository.deleteById(id);
    }
    public List<ContactDTO> getAll(){
        return contactRepository.findAll()
                .stream()
                .map(contactMapper::toDTO)
                .collect(Collectors.toList());
    }

}
