package com.techelevator.custom.controller;

import com.techelevator.custom.dao.CardDao;
import com.techelevator.custom.dao.CardItemDao;
import com.techelevator.custom.dao.StoreItemDao;
import com.techelevator.custom.dao.UserDao;
import com.techelevator.custom.exception.DaoException;
import com.techelevator.custom.model.Card;
import com.techelevator.custom.model.CardItem;
import com.techelevator.custom.model.CardItemDto;
import com.techelevator.custom.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    private final UserDao userDao;
    private final CardDao cardDao;
    private final CardItemDao cardItemDao;

    public UserController(UserDao userDao, CardDao cardDao, CardItemDao cardItemDao) {
        this.userDao = userDao;
        this.cardDao = cardDao;
        this.cardItemDao = cardItemDao;
    }

    @GetMapping
    public List<User> list() {
        try {
            return userDao.getUsers();
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "could not get cards: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        try {
            return userDao.getUserById(id);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "could not get card: " + e.getMessage());
        }
    }

    @GetMapping("/{userId}/cards")
    public List<CardItemDto> getUserCards(@PathVariable int userId) {
        try {
            // get all card instances where the user is the id
            return cardItemDao.getCardItemsByUser(userId);
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
