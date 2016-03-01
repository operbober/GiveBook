package by.givebook.services.impl;

import by.givebook.entities.User;
import by.givebook.services.UserService;
import by.givebook.services.impl.superServices.SimpleServiceImpl;
import org.springframework.stereotype.Service;

/**
 * Created by operb_000 on 29.02.2016.
 */
@Service
public class UserServiceImpl extends SimpleServiceImpl<User, Long> implements UserService{}
