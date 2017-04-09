package ru.itis.inform.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.dto.OfferDto;
import ru.itis.inform.models.Offer;
import ru.itis.inform.services.OffersService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Natalia on 09.04.17.
 */

@Controller
public class OfferRestController {

    @Autowired
    OffersService offersServices;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "offers/", method = RequestMethod.GET)
    @ResponseBody
    public List<OfferDto> getOffers() {
        List<Offer> offers = offersServices.getAll();
        return  offers.stream()
                .map(offer -> convertToDto(offer))
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public OfferDto createPost(@RequestBody OfferDto offerDto) {
        Offer offer = convertToEntity(offerDto);
        Offer createdOffer = offersServices.save(offer);
        return convertToDto(createdOffer);
    }

    @RequestMapping(value = "offers/{offerId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public OfferDto getOffer(@PathVariable("offerId") Integer offerId) {
        Offer offer = offersServices.findOffer(offerId);
        return convertToDto(offer);
    }

    @RequestMapping(value = "offers/{offerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateOffer(@RequestBody OfferDto offerDto) {
        Offer offer = convertToEntity(offerDto);
        offersServices.update(offer);
    }

    @RequestMapping(value = "offers/{offerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteOffer(@PathVariable("offerId") Integer offerId) {
        offersServices.delete(offerId);
    }




    private OfferDto convertToDto (Offer offer) {
        OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
        return offerDto;
    }

    private Offer convertToEntity (OfferDto offerDto) {
        Offer offer = modelMapper.map(offerDto, Offer.class);
        return offer;
    }


}
