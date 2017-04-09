package ru.itis.inform.dto;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import ru.itis.inform.models.Address;
import ru.itis.inform.models.Offer;

import static org.junit.Assert.*;

/**
 * Created by Natalia on 09.04.17.
 */
public class OfferDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void whenConvertOfferEntityToOfferDto_thenCorrect() {
        Offer offer = new Offer();
        offer.setId(1);
        offer.setCost(1000);
        Address address = new Address();
        address.setFlat(100);
        offer.setAddress(address);
        OfferDto offerDto = modelMapper.map(offer, OfferDto.class);
        System.out.print(offerDto);
    }

}