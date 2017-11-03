package com.uic.webbasederp.service.impl;

import com.uic.webbasederp.domain.po.OrderProduct;
import com.uic.webbasederp.domain.po.Product;
import com.uic.webbasederp.domain.po.Wharehouse;
import com.uic.webbasederp.mapper.OrderProductMapper;
import com.uic.webbasederp.mapper.ProductMapper;
import com.uic.webbasederp.mapper.WharehouseMapper;
import com.uic.webbasederp.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService{
    @Autowired
    private OrderProductMapper orderProductMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private WharehouseMapper wharehouseMapper;
    @Override
    public void saveOrderProduct(OrderProduct orderProduct) {

        List<Product> products = productMapper.getSubProductByProductId(orderProduct.getProductId());

        for(Product product : products){
            Wharehouse wharehouse = new Wharehouse();
            wharehouse.setProductId(product.getProductId());
            wharehouse.setOrderNumber(orderProduct.getNumber());
            wharehouseMapper.updateWharehouse(wharehouse);
        }
        orderProductMapper.saveOrderProduct(orderProduct);
    }
}
