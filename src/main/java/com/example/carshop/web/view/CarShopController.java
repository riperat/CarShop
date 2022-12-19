package com.example.carshop.web.view;

import com.example.carshop.data.entity.CarShop;
import com.example.carshop.data.entity.Repairdone;
import com.example.carshop.data.entity.Repairman;
import com.example.carshop.services.interfaces.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.example.carshop.util.HibernateUtil.getAllQualifications;

@Controller
@AllArgsConstructor
@RequestMapping("/shops")
public class CarShopController {
    private CarService carService;
    private CarShopService carShopService;
    private RepairmanQService repairmanQService;
    private RepairmanService repairmanService;
    private RepairdoneService repairdoneService;
    private QualificationsService qualificationsService;

    @GetMapping
    public String getCarShops(Model model) {
        final List<CarShop> shops = carShopService.getShops();
        model.addAttribute("shops", shops);
        return "/shops/shops.html";
    }

    @GetMapping("/shop-view/{id}")
    public String shopView(Repairdone repairdone, Model model, @PathVariable Long id) {
        final List<Repairman> repairmen = repairmanService.findAllByCarShop(carShopService.getShop(id));

        final Set<String> qualificationNamesList = getAllQualifications(repairmen, repairmanQService);

        model.addAttribute("qualifications", qualificationNamesList);
        model.addAttribute("repairdone", repairdone);
        model.addAttribute("shopID", id);

        return "/shops/shop-view";
    }

    @GetMapping("/create-repair/{id}")
    public String showCreateRepairForm(Model model, @PathVariable Long id) {
        final List<Repairman> repairmen = repairmanService.findAllByCarShop(carShopService.getShop(id));
        final List<Repairdone> repairs = new ArrayList<>();
        final List<Date> dates = new ArrayList<>();

        //Repairs List
        repairs.addAll(repairdoneService.findAllByCarShop(carShopService.getShop(id)));
        for (Repairdone rep : repairs) {
            dates.add(rep.getReservationDate());
        }

        //TODO add logic for user's current car
        //User Cars list
        final List<String> myCars = new ArrayList<>();
        carService.getCars().forEach((car -> myCars.add(car.getRegistrationNumber())));

        //Qualifications List
        final Set<String> qualificationNamesList = getAllQualifications(repairmen, repairmanQService);

        model.addAttribute("dates", dates);
        model.addAttribute("repair", new Repairdone());
        model.addAttribute("myCars", myCars);
        model.addAttribute("qualifications", qualificationNamesList);
        return "/shops/create-repair";
    }

    @PostMapping("/create/{id}")
    public String createCars(@RequestParam("date") String date,
                             @RequestParam("car") String car, @RequestParam("qualification") String qualification, @PathVariable Long id) {

        Repairdone repairdone = new Repairdone();

        repairdone.setReservationDate(java.sql.Date.valueOf(date));
        repairdone.setCar(carService.getCarByPlate(car));
        repairdone.setCarShop(carShopService.getShop(id));
        repairdone.setQualifications(qualificationsService.getQualificationByName(qualification));
        repairdoneService.create(repairdone);
        return "redirect:/shops";
    }

    @GetMapping("/create-carShop")
    public String showCreateCarShopsForm(Model model) {
        model.addAttribute("carShop", new CarShop());
        return "/shops/create-carShop";
    }

    @GetMapping("/edit-carShop/{id}")
    public String showEditCarsForm(Model model, @PathVariable Long id) {
        model.addAttribute("carShop", carShopService.getShop(id));
        return "/shops/edit-carShop";
    }

    @PostMapping("/update/{id}")
    public String updateCars(Model model, @PathVariable long id, CarShop carShop) {
        carShopService.updateShop(id, carShop);
        return "redirect:/shops";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        carShopService.deleteShop(id);
        return "redirect:/cars";
    }


}
