package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Client;

import java.util.List;
import org.apache.commons.validator.routines.EmailValidator;
public class ClientController {


    public static boolean createClient(String name, String address, String emailAddress, String phoneNumber){

        boolean emailIsValid = EmailValidator.getInstance().isValid(emailAddress);
        boolean nameIsValid = name.toLowerCase().matches("[a-z]{3,}");
        boolean phoneNumberIsValid = phoneNumber.matches("[0-9]{11}");

        if (emailIsValid && nameIsValid && phoneNumberIsValid){
            DAO.getClientDAO().create(new Client(name, address, emailAddress, phoneNumber));
            return true;
        }
        return false;
    }
    public static Client getClientById(int id){
        return DAO.getClientDAO().findById(id);
    }
    public static List<Client> getAllClients(){
        return DAO.getClientDAO().findMany();
    }
    public static boolean updateOne(String name, String address, String emailAddress, String phoneNumber){
        boolean emailIsValid = EmailValidator.getInstance().isValid(emailAddress);
        boolean nameIsValid = name.toLowerCase().matches("[a-z]{3,}");
        boolean phoneNumberIsValid = phoneNumber.matches("[0-9]{11}");

        if (emailIsValid && nameIsValid && phoneNumberIsValid){
            return DAO.getClientDAO().update(new Client(name, address, emailAddress, phoneNumber));
        }
        return false;
    }
    public static boolean deleteAll(){
        return DAO.getClientDAO().deleteMany();
    }
    public static List<Client> getClientByName(String name){
        return DAO.getClientDAO().findByName(name);
    }
    public static boolean deleteById(int id){
        return DAO.getClientDAO().deleteById(id);
    }

    public boolean deleteByName(String name){
        return DAO.getClientDAO().deleteByName(name);
    }
}