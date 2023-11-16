package com.souzatech.backend.api.webservice;

import com.souzatech.backend.api.model.client.ClientRequest;
import com.souzatech.backend.api.model.client.ClientResponse;
import com.souzatech.backend.api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientResource {

    @Autowired
    private ClientService service;

    @PostMapping
    public void post(@RequestBody ClientRequest request){
        service.save(request);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") Integer id, @RequestBody ClientRequest request){
        service.update(id, request);
    }

    @GetMapping()
    public List<ClientResponse> listAll(){
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ClientResponse getOne(@PathVariable("id") Integer id){
        return service.getOne(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }

}
