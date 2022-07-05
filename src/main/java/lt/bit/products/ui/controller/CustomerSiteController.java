package lt.bit.products.ui.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class CustomerSiteController {

    private  final static Logger LOG = LoggerFactory.getLogger(CustomerSiteController.class);

    @PostMapping("/cart/add")
    @ResponseBody
    String addToCart(@RequestParam("productId") String productId) {
        LOG.info("!!!productId: " + productId);
        return "Product has been added!";
    }

}
