package com.example.herokudemo.controller;


import com.example.herokudemo.models.MyOrder;
import com.example.herokudemo.models.MyProduct;
import com.example.herokudemo.models.MyUser;
import com.example.herokudemo.pojo.MyOrderDto;
import com.example.herokudemo.pojo.MyProductDto;
import com.example.herokudemo.pojo.MyUserDto;
import com.example.herokudemo.pojo.ResponseDto;
import com.example.herokudemo.repositories.MyOrderRepository;
import com.example.herokudemo.repositories.MyProductRepository;
import com.example.herokudemo.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/my-test")
public class MyTestController {

    @Autowired
    MyUserRepository myUserRepository;

    @Autowired
    MyOrderRepository myOrderRepository;

    @Autowired
    MyProductRepository myProductRepository;

    @GetMapping("/products")
    ResponseDto<List<MyProductDto>> getProduct(
            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size) {
        Pageable p = PageRequest.of(page, size);
        Page<MyProduct> all = myProductRepository.findAll(p);

        List<MyProduct> content = all.getContent();
        List<MyProductDto> myProductDtoList = new ArrayList<>();
        for (MyProduct mp : content) {
            MyProductDto mpd = new MyProductDto();
            mpd.setPrice(mp.getPrice());
            mpd.setName(mp.getName());
            mpd.setId(mp.getId());
            myProductDtoList.add(mpd);
        }

        ResponseDto<List<MyProductDto>> result = new ResponseDto<>(myProductDtoList);
        result.setPage(all.getNumber());
        result.setSize(all.getSize());
        return result;
    }

    @GetMapping("/product")
    ResponseDto<List<MyProductDto>> getProduct(@RequestParam(name = "id", required = false) Long id) {
        if (id == null) {
            List<MyProduct> allFree = myProductRepository.findAll();
            List<MyProductDto> allFreeDto = new ArrayList<>();
            for (MyProduct mp : allFree) {
                MyProductDto mpd = new MyProductDto();
                mpd.setPrice(mp.getPrice());
                mpd.setName(mp.getName());
                allFreeDto.add(mpd);
            }
            return new ResponseDto<>(allFreeDto);
        }
        MyProduct mp = myProductRepository.getOne(id);
        MyProductDto mpd = new MyProductDto();
        mpd.setPrice(mp.getPrice());
        mpd.setName(mp.getName());
        return new ResponseDto<>(Collections.singletonList(mpd));
    }

    @GetMapping("/product/free")
    ResponseDto<List<MyProductDto>> getFreeProduct() {
        List<MyProduct> allFree = myProductRepository.findAllFree();
        List<MyProductDto> allFreeDto = new ArrayList<>();
        for (MyProduct mp : allFree) {
            MyProductDto mpd = new MyProductDto();
            mpd.setPrice(mp.getPrice());
            mpd.setName(mp.getName());
            allFreeDto.add(mpd);
        }
        return new ResponseDto<>(allFreeDto);
    }

    @PostMapping("/product/save")
    String saveProduct(@RequestBody MyProductDto myProductDto) {
        MyProduct myProduct = new MyProduct();
        myProduct.setName(myProductDto.getName());
        myProductRepository.save(myProduct);
        return "success";
    }

    @PostMapping("/order/save")
    String saveOrder(@RequestBody MyOrderDto myOrderDto) {
        MyOrder myOrder = new MyOrder();

        // save get set
        myOrder.setAmount(myOrderDto.getAmount());
        // FIXME add later

        // save user of order
        if (myOrderDto.getUserId() != null) {
            MyUser user = myUserRepository.getOne(myOrderDto.getUserId());
            myOrder.setUser(user);
        }

        // save products
        if (myOrderDto.getProductIds() != null) {
            List<MyProduct> allById = myProductRepository.findAllById(myOrderDto.getProductIds());
            myOrder.setProducts(new HashSet<>(allById));
        }

        myOrderRepository.save(myOrder);
        return "success";
    }

    @PostMapping("/user/save2")
    String saveUser(@RequestBody List<MyUser> myUsers) {
        myUserRepository.saveAll(myUsers);
        return "";
    }

    @PostMapping("/user/save")
    MyUserDto saveUser(@RequestBody MyUserDto myUserDto) {
        MyUser myUser = privateSaveOrder(myUserDto);
        assignManagement(myUserDto, myUser);

        myUser = myUserRepository.save(myUser);

        return loadManager(myUser, false);
    }

    private MyUserDto loadManager(MyUser myUser, boolean stopRecursive) {
        MyUserDto result = new MyUserDto();
        result.setId(myUser.getId());
        result.setName(myUser.getName());
        if (myUser.getManager() != null) {
            result.setManagerId(myUser.getManager().getId());
        }

        // load manager
        if (!stopRecursive) {
            MyUser manager = myUserRepository.getOne(myUser.getManager().getId());
            MyUserDto managerDto = loadManager(manager, true);
            result.setManager(managerDto);
        }
        return result;
    }

    private void assignManagement(MyUserDto myUserDto, MyUser myUser) {
        // save manager
        Long managerId = myUserDto.getManagerId();
        if (managerId != null) {
            MyUser manager = myUserRepository.getOne(managerId);
            myUser.setManager(manager);
        }
        // save staffs
        if (myUserDto.getStaffIds() != null) {
            List<MyUser> allById = myUserRepository.findAllById(myUserDto.getStaffIds());
            for (MyUser mu : allById) {
                mu.setManager(myUser);
            }
            myUser.setStaffs(new HashSet<>(allById));
        }
    }

    private MyUser privateSaveOrder(MyUserDto myUserDto) {
        MyUser myUser = new MyUser();
        if (myUserDto.getId() != null) {
            myUser = myUserRepository.getOne(myUserDto.getId());
            if (myUser == null) {
                myUser = new MyUser();
            }
        }
        myUser.setAddress(myUserDto.getAddress());
        myUser.setName(myUserDto.getName());
        // FIXME add later
        List<Long> orderIds = myUserDto.getOrderIds();
        List<MyOrder> allById = myOrderRepository.findAllById(orderIds);
        for (MyOrder mo : allById) {
            mo.setUser(myUser);
        }
        myUser.setOrders(new HashSet<>(allById));
        return myUser;
    }
}
