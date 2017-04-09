package ru.itis.inform.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.services.OfferseGeneratorService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Natalia on 14.03.17.
 */
public class UpdateController implements Controller {

    @Autowired
    OfferseGeneratorService offerseGeneratorService;

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Offer> offers = offerseGeneratorService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("update");
        modelAndView.addObject("offers", offers);
        return modelAndView;
    }
}
