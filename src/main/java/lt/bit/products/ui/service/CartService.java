package lt.bit.products.ui.service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import lt.bit.products.ui.model.CartItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import static java.util.Arrays.stream;

@Service
@SessionAttributes("cartItems")
public class CartService {

    private static final Logger LOG = LoggerFactory.getLogger(CartService.class);
    private Map<UUID, CartItem> cartItems = new HashMap<>();

    public void addToCart(UUID productId, String productName, BigDecimal productPrice) {
        CartItem item;
        if (cartItems.containsKey(productId)) {
            item = cartItems.get(productId);
            item.setCount(item.getCount() + 1);
        } else {
            item = new CartItem(productId, productName, productPrice, 1);
        }
        cartItems.put(productId, item);
    }

    public void updateItemCount(UUID productId, Integer itemCount) {
        CartItem item = cartItems.get(productId);
        item.setCount(itemCount);
    }

    public List<CartItem> getCartItems() {

//        1-as varjantas
//        ArrayList<CartItem> items = new ArrayList<>(this.cartItems.values());
//        Collections.sort(items, Comparator.comparing(CartItem::getProductName));
//        return items;

//        2-as varjantas
        return this.cartItems.values().stream()
                .sorted(Comparator.comparing(CartItem::getProductName))
                .collect(Collectors.toList());

    }

    public void removeFromCart(UUID productId) {
        cartItems.remove(productId);
    }

    public int getTotalItems() {
        return cartItems.values().stream().mapToInt(CartItem::getCount).sum();
    }
//     vienas is varjantu
//    public BigDecimal getCartAmount1() {
//        BigDecimal amount = BigDecimal.ZERO;
//        for (CartItem item : getCartItems()) {
//            amount = amount.add(item.getTotalPrice());
//        }
//        LOG.info("Cart Amount: " + amount);
//        return amount;
//    }

    public BigDecimal getCartAmount() {
        BigDecimal amount = cartItems.values().stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return amount;
    }
}