package it.frogject.business;

import it.frogject.domain.Resource;
import it.frogject.dto.ResourceDTO;
import it.frogject.repositories.ResourceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultResourceService implements ResourceService{
    @Autowired
    ResourceRepository resourceRepository;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<ResourceDTO> getAllResources() {
        List<Resource> resourcesModel = (List<Resource>) resourceRepository.findAll();
        return resourcesModel.stream().map(resource -> modelMapper.map(resource, ResourceDTO.class)).collect(Collectors.toList());
    }
}
