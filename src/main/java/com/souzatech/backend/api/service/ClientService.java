package com.souzatech.backend.api.service;

import com.souzatech.backend.api.model.client.ClientEntity;
import com.souzatech.backend.api.model.client.ClientRequest;
import com.souzatech.backend.api.model.client.ClientResponse;
import com.souzatech.backend.api.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public void save(ClientRequest request){
        this.persist(null, request);
    }

    public void update(Integer id, ClientRequest request){
        this.persist(id, request);
    }

    public void delete(Integer id){
        ClientEntity entity = findById(id);
        repository.delete(entity);
    }

    public ClientResponse getOne(Integer id){
        ClientEntity entity = findById(id);
        ClientResponse response = new ClientResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    public List<ClientResponse> listAll(){
        List<ClientEntity> entities = repository.findAll();
        List<ClientResponse> list = new ArrayList<>();

        for(ClientEntity entity : entities){
            ClientResponse response = new ClientResponse();
            BeanUtils.copyProperties(entity, response);
            list.add(response);
        }

        return list;

    }

    private Integer persist(Integer id, ClientRequest request) {
        ClientEntity entity = null;
        if(id != null){
            entity = this.findById(id);
        }else 
            entity = new ClientEntity();

        BeanUtils.copyProperties(request, entity);
        
        return  repository.save(entity).getId();
    }

    private ClientEntity findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possível localizar o cliente com o ID " + id));
    }
}
