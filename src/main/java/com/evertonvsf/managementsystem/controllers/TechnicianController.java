package com.evertonvsf.managementsystem.controllers;

import com.evertonvsf.managementsystem.dao.DAO;
import com.evertonvsf.managementsystem.models.users.Technician;

import java.util.List;

public class TechnicianController {

    public static Technician createTechnician(String name, String password){
        boolean nameIsValid = name.toLowerCase().matches("[a,z]{3,}");
        boolean passwordIsValid = password.length() >= 8;
        if (nameIsValid && passwordIsValid){
            return DAO.getTechnicianDAO().create(new Technician(name, password));
        }
        return null;
    }
    public static boolean updateTechnician(String name, String password, int id){
        Technician newTechnician = new Technician(name, password);
        boolean nameIsValid = name.toLowerCase().matches("[a,z]{3,}");
        boolean passwordIsValid = password.length() >= 8;
        if (nameIsValid && passwordIsValid){
            newTechnician.setId(id);
            return DAO.getTechnicianDAO().update(newTechnician);
        }
        return false;
    }
    public Technician getById(int id){
        return DAO.getTechnicianDAO().findById(id);
    }
    public List<Technician> getAll(){
        return DAO.getTechnicianDAO().findMany();
    }
    public boolean deleteById(int id){
        return DAO.getTechnicianDAO().deleteById(id);
    }
    public boolean deleteAll(){
        return DAO.getTechnicianDAO().deleteMany();
    }
    public List<Technician> getByName(String name){
        boolean nameIsValid = name.toLowerCase().matches("[a,z]{3,}");
        if (nameIsValid){
            return DAO.getTechnicianDAO().findByName(name);
        }
        return null;
    }

    public boolean deleteByName(String name){
        boolean nameIsValid = name.toLowerCase().matches("[a,z]{3,}");
        if (nameIsValid){
            return DAO.getTechnicianDAO().deleteByName(name);
        }
        return false;
    }

}