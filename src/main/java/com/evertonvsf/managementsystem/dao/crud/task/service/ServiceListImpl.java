package com.evertonvsf.managementsystem.dao.crud.task.service;

import com.evertonvsf.managementsystem.dao.persistence.task.service.ServicePersistence;
import com.evertonvsf.managementsystem.models.task.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServiceListImpl implements ServiceCRUD{
    public static final ServicePersistence persistence = new ServicePersistence();
    private List<Service> services;
    private int newId;

    public ServiceListImpl() {
        this.loadPersistence();
    }
    @Override
    public void writePersistence(){
        persistence.writeFiles(this.services, persistence.fileName);
    }
    @Override
    public void loadPersistence(){
        this.services = persistence.loadFiles(persistence.fileName);
        newId = -1;
        for (Service service : services){
            if (service.getId() > newId){
                newId = service.getId();
            }
        }
        this.newId = newId+1;
    }
    @Override
    public Service create(Service service) {
        service.setId(this.newId);
        this.newId++;
        this.services.add(service);
        return service;
    }

    @Override
    public List<Service> findMany() {
        return new ArrayList<Service>(this.services);
    }

    @Override
    public boolean update(Service service) {
        for (int index = 0; index<this.services.size(); index++){
            if (this.services.get(index).getId() == service.getId()){
                this.services.remove(index);
                this.services.add(service);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteMany() {
        this.newId = 0;
        if (this.services.size() > 0){
            this.services = new ArrayList<Service>();
            return true;
        }
        return false;
    }

    @Override
    public Service findById(int id) {
        for (Service service : this.services){
            if (service.getId() == id){
                return service;
            }
        }
        return null;
    }

    @Override
    public List<Service> findByRating(int rating) {
        List<Service> sameRatingServices = new ArrayList<Service>();
        for (Service service : this.services){
            if (service.getRating() == rating){
                sameRatingServices.add(service);
            }
        }
        return sameRatingServices;
    }

    @Override
    public List<Service> findByCategory(String category) {
        List<Service> sameCategoryServices = new ArrayList<Service>();
        for (Service service : this.services){
            if (Objects.equals(service.getCategory(), category)){
                sameCategoryServices.add(service);
            }
        }
        return sameCategoryServices;
    }

    @Override
    public List<Service> findByStatus(String status) {
        List<Service> sameStatusServices = new ArrayList<Service>();
        for (Service service : this.services){
            if (Objects.equals(service.getStatus(), status)){
                sameStatusServices.add(service);
            }
        }
        return sameStatusServices;
    }

    @Override
    public boolean deleteById(int id) {
        for (int index = 0; index<this.services.size(); index++){
            if (this.services.get(index).getId() == id){
                this.services.remove(index);
                return true;
            }
        }
        return false;
    }

}
