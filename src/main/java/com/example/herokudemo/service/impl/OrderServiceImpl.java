package com.example.herokudemo.service.impl;


import com.example.herokudemo.mapping.simple.CatalogueMapping;
import com.example.herokudemo.mapping.simple.OrderMapping;
import com.example.herokudemo.models.Catalogue;
import com.example.herokudemo.models.Order;
import com.example.herokudemo.pojo.CatalogueDto;
import com.example.herokudemo.pojo.OrderDto;
import com.example.herokudemo.repositories.CatalogueRepository;
import com.example.herokudemo.repositories.OrderRepository;
import com.example.herokudemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order saveOrder(OrderDto orderDto) {
        Order order = OrderMapping.dtoToEntity(orderDto);
        return orderRepository.save(order);
    }

    @Autowired
    CatalogueRepository catalogueRepository;

    public Catalogue save(CatalogueDto object) {
        Catalogue catalogue = CatalogueMapping.dtoToEntity(object);

        // set parent
        Catalogue parent = catalogueRepository.getOne(object.getParentId());
        catalogue.setCatalogue(parent);

        catalogueRepository.save(catalogue);
        return catalogue;
    }


}
