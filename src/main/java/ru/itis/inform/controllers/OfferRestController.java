package ru.itis.inform.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.inform.dto.OfferDto;
import ru.itis.inform.models.Offer;
import ru.itis.inform.services.OffersService;

/**
 * Created by Natalia on 09.04.17.
 */

@Controller
public class OfferRestController {

    @Autowired
    OffersService offersServices;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "offers/{offerId}", method = RequestMethod.GET)
    @ResponseBody
    public OfferDto getOffer(@PathVariable("offerId") Integer offerId) {
        Offer offer = offersServices.findOffer(offerId);

        return null;

    }


    private OfferDto convertToDto (Offer offer) {
        OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
        return offerDto;
    }

}
