package kea.sparrow.dtos.converter;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public class DTOConverter {
    ModelMapper modelMapper;

    @Autowired
    public DTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }



}
