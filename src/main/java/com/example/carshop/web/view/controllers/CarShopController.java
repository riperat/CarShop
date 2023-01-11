package com.example.carshop.web.view.controllers;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Repairdone;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.data.entity.User;
import com.example.carshop.services.interfaces.*;
import com.example.carshop.web.dto.CreateCarShopDTO;
import com.example.carshop.web.dto.UpdateCarShopDTO;
import com.example.carshop.web.view.model.CreateCarShopViewModel;
import com.example.carshop.web.view.model.UpdateCarShopViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.example.carshop.util.HibernateUtil.getAllCarsByPreference;
import static com.example.carshop.util.HibernateUtil.getAllQualifications;

@Controller
@AllArgsConstructor
@RequestMapping("/shops")
public class CarShopController {
    private final ModelMapper modelMapper;

    private CarService carService;
    private CarShopService carShopService;
    private RepairmanService repairmanService;
    private RepairdoneService repairdoneService;
    private QualificationsService qualificationsService;

    @GetMapping
    public String getCarShops(Model model) {
        final List<CarShop> shops = carShopService.getShops();
        model.addAttribute("shops", shops);
        return "/shops/shops.html";
    }

    @GetMapping("/success")
    public ModelAndView success() {
        ModelAndView modelAndView = new ModelAndView("/shops/success");

        return modelAndView;
    }

    @GetMapping("/shop-view/{id}")
    public String shopView(Repairdone repairdone, Model model, @PathVariable Long id) {
        final List<Repairman> repairmen = repairmanService.findAllByCarShop(carShopService.getShop(id));

        final Set<String> qualificationNamesList = getAllQualifications(repairmen, qualificationsService);

        model.addAttribute("qualifications", qualificationNamesList);
        model.addAttribute("repairdone", repairdone);
        model.addAttribute("shopID", id);

        return "/shops/shop-view";
    }

    //ADMIN
    @GetMapping("/adminShop-view")
    public String shopView(Model model, @AuthenticationPrincipal User user) {
        Repairman repairman = repairmanService.getRepairman(user.getRepairman().getId());
        final List<Repairdone> repairs = repairdoneService.findAllByCarShop(repairman.getCarShop());
        model.addAttribute("repairs", repairs);

        return "/shops/adminShop-view";
    }

    @GetMapping("/create-repair/{id}")
    public String showCreateRepairForm(Model model, @PathVariable Long id, @AuthenticationPrincipal User user) {
        final List<Repairman> repairmen = repairmanService.findAllByCarShop(carShopService.getShop(id));
        final List<Repairdone> repairs = new ArrayList<>();
        final List<Date> dates = new ArrayList<>();

        //Repairs List
        repairs.addAll(repairdoneService.findAllByCarShop(carShopService.getShop(id)));
        for (Repairdone rep : repairs) {
            dates.add(rep.getReservationDate());
        }

        model.addAttribute("username", user.getUsername());

        final List<String> myCars = getAllCarsByPreference(user, carService, carShopService , id);

        //Qualifications List
        final Set<String> qualificationNamesList = getAllQualifications(repairmen, qualificationsService);

        model.addAttribute("dates", dates);
        model.addAttribute("repair", new Repairdone());
        model.addAttribute("myCars", myCars);
        model.addAttribute("qualifications", qualificationNamesList);
        return "/shops/create-repair";
    }

    @PostMapping("/create/{id}")
    public ModelAndView createRepair(@RequestParam("date") String date,
                                     @RequestParam("car") String car, @RequestParam("qualification") String qualification, @PathVariable Long id) {

        Repairdone repairdone = new Repairdone();

        repairdone.setReservationDate(java.sql.Date.valueOf(date));
        repairdone.setCar(carService.getCarByPlate(car));
        repairdone.setCarShop(carShopService.getShop(id));
        repairdone.setQualifications(qualificationsService.getQualificationByName(qualification));
        Long price = qualificationsService.getQualificationByName(qualification).getPrice();
        repairdone.setPrice(price);
        repairdoneService.create(repairdone);
        return checkout(price, car, date, qualification, id);
    }

    @GetMapping("/checkout")
    public ModelAndView checkout(Long price, String car, String date, String qualification, Long id) {
        ModelAndView modelAndView = new ModelAndView("/shops/checkout");
        modelAndView.addObject("price", price);
        modelAndView.addObject("car", carService.getCarByPlate(car).getBrand());
        modelAndView.addObject("date", date);
        modelAndView.addObject("qualification", qualification);
        modelAndView.addObject("id", id);

        return modelAndView;
    }

    @GetMapping("/create-carShop")
    public String showCreateCarShopsForm(Model model) {
        model.addAttribute("carShop", new CarShop());
        return "/shops/create-shop";
    }

    @PostMapping("/create")
    public String createCarShop(@ModelAttribute CreateCarShopViewModel createCarShopViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/shops/create-shop";
        }

        carShopService.create(modelMapper.map(createCarShopViewModel, CreateCarShopDTO.class));
        return "redirect:/shops";
    }

    @GetMapping("/edit-carShop/{id}")
    public String showEditCarShopForm(Model model, @PathVariable Long id) {
        model.addAttribute("carShop", carShopService.getShop(id));
        return "/shops/edit-shop";
    }

    @PostMapping("/update/{id}")
    public String updateCars(@PathVariable long id, UpdateCarShopViewModel carShop) {
        carShopService.updateShop(id, modelMapper.map(carShop, UpdateCarShopDTO.class));
        return "redirect:/shops";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        carShopService.deleteShop(id);
        return "redirect:/cars";
    }


}
