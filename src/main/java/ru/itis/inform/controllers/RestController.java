package ru.itis.inform.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.inform.models.Offer;
import ru.itis.inform.services.OffersService;

import java.io.IOException;

/**
 * Created by Natalia on 26.03.17.
 */
@Controller
public class RestController {
    @Autowired
    private OffersService offersService;

    @RequestMapping(value = "post/{post-id}", method = RequestMethod.GET)
    @ResponseBody
    public String getPost(@PathVariable("post-id") int postId){
        Offer offer = offersService.findOffer(postId);
        ObjectMapper mapper = new ObjectMapper();
        String postAsJson = null;
        try {
            postAsJson = mapper.writeValueAsString(offer);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
        return postAsJson;

    }

    @RequestMapping(value = "post/", method = RequestMethod.POST)
    public void addPost(@RequestBody String postValue){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Offer offer = objectMapper.readValue(postValue, Offer.class);
            offersService.save(offer);

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }



}
