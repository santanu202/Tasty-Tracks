package com.santanu.service;

import com.santanu.Exception.RestaurantException;
import com.santanu.model.Events;

import java.util.List;

public interface EventsService {

    public Events createEvent(Events event, Long restaurantId) throws RestaurantException;

    public List<Events> findAllEvent();

    public List<Events> findRestaurantsEvent(Long id);

    public void deleteEvent(Long id) throws Exception;

    public Events findById(Long id) throws Exception;

}

