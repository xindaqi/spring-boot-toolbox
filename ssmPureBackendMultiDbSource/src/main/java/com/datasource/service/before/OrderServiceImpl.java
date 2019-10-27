package com.datasource.service.before;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.datasource.dao.OrderDao;
import com.datasource.po.Order;
import com.util.MyUtil;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired 
    private OrderDao orderDao;

    /**
     * 当单提交,连续的事务处理
     */
    @Override 
    public String orderSubmit(Model model, HttpSession session, Double amount){
        Order order = new Order();
        order.setAmount(amount);
        order.setBusertable_id(MyUtil.getUserId(session));
        // 生成订单,并将主键返回order
        orderDao.addOrder(order);
        // 生成订单详情
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ordersn", order.getId());
        map.put("uid", MyUtil.getUserId(session));
        orderDao.addOrderDetail(map);
        // 更新商品库存
        //更新商品库存1,查询商品购买数量,以便更新库存使用
        List<Map<String, Object>> list = orderDao.selectGoodsShop(MyUtil.getUserId(session));
        // 更新商品库存2,根据商品购买量更新库存
        for(Map<String, Object> map2 : list){
            orderDao.updateStore(map2);
        }
        // 清空购物车
        orderDao.clear(MyUtil.getUserId(session));
        model.addAttribute("ordersn", order.getId());
        return "before/orderdone";
    }

    @Override 
    public String pay(Integer ordersn){
        orderDao.pay(ordersn);
        return "before/paydone";
    }
}