package com.thoughtworks.medinfo.dao.impl;

import com.thoughtworks.medinfo.dao.HCPDao;
import com.thoughtworks.medinfo.model.HCProvider;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HCPDaoImpl implements HCPDao {

    @Autowired
    private SessionFactory sessionFactory;

    public HCProvider get(Long id) {
        return (HCProvider) sessionFactory.getCurrentSession()
                .createQuery(
                        "FROM HCProvider u " +
                                "WHERE u.id = :id " +
                                "ORDER BY u.id")
                .setLong("id", id).uniqueResult();
    }

    public void delete(HCProvider HCProvider) {
        sessionFactory.getCurrentSession().delete(HCProvider);
    }

    @SuppressWarnings("unchecked")
    public List<HCProvider> findAll() {
        return sessionFactory.getCurrentSession().createQuery(
                "FROM HCProvider " +
                        "ORDER BY id")
                .list();
    }

    public void save(HCProvider HCProvider) {
        sessionFactory.getCurrentSession().merge(HCProvider);

    }

    public List<HCProvider> findByPincode(String pincode) {
        return (List<HCProvider>) sessionFactory.getCurrentSession().createQuery("from HCProvider u " +
                "WHERE u.pincode = :pincode");
    }

}
