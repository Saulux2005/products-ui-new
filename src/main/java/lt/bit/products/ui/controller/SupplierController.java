package lt.bit.products.ui.controller;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import lt.bit.products.ui.model.Supplier;
import lt.bit.products.ui.service.SupplierService;
import lt.bit.products.ui.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static lt.bit.products.ui.controller.ControllerBase.ADMIN_PATH;
import static lt.bit.products.ui.controller.SupplierController.SUPPLIERS_PATH;

@Controller
@RequestMapping(ADMIN_PATH + SUPPLIERS_PATH)
class SupplierController extends ControllerBase {

  protected static final String SUPPLIERS_PATH = "/suppliers";
  private final SupplierService service;
  private final UserService userService;

  public SupplierController(SupplierService service, UserService userService) {
    this.service = service;
    this.userService = userService;
  }

  @GetMapping( )
  String showSuppliers(Model model, HttpServletRequest request) {
    if (!userService.isAuthenticated()) {
      return "login";
    }

    List<Supplier> suppliers = service.getSuppliers();

    model.addAttribute("supplierItems", suppliers);
    return "admin/supplierList";
  }

  @GetMapping("/{id}")
  String editSupplier(@PathVariable UUID id, Model model) {
    if (!userService.isAuthenticated()) {
      return "login";
    }
    model.addAttribute("supplierItem", service.getSupplier(id));
    return "admin/supplierForm";
  }

//  @PostMapping("/save")
//  String saveProduct(@ModelAttribute Supplier supplier, Model model) throws ValidationException {
///*    try {
//      validator.validate(product);
//    } catch (ValidationException e) {
//      model.addAttribute("errorMsg",
//          messages.getMessage("validation.error." + e.getCode(), e.getParams(),
//              Locale.getDefault()));
//      model.addAttribute("productItem", product);
//      return "productForm";
//    }*/
//    service.saveSupplier(supplier);
//    return "redirect:" + ADMIN_PATH + SUPPLIERS_PATH;
//  }
}
