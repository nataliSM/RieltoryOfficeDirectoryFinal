package ru.itis.inform.anno.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.services.OfferseGeneratorService;

import java.util.List;

/**
 * Created by Natalia on 20.03.17.
 */
@Controller
public class SimpleController  {
 @Autowired
  private OfferseGeneratorService offerseGeneratorService;

    @RequestMapping(value = "/showAll" , method = RequestMethod.GET)
        public ModelAndView getOffers() {
            List<Offer> offers = offerseGeneratorService.getAll();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("update");
            modelAndView.addObject("offers", offers);
            return modelAndView;
        }


}
