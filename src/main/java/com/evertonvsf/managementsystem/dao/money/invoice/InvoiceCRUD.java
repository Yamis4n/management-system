package com.evertonvsf.managementsystem.dao.money.invoice;

import com.evertonvsf.managementsystem.dao.CRUD;
import com.evertonvsf.managementsystem.models.money.Invoice;

import java.util.List;

public interface InvoiceCRUD extends CRUD<Invoice> {

    public Invoice findByOrder(int orderId);
    public List<Invoice> findByValue(double value);
    public boolean deleteByOrder(int orderId);

}
