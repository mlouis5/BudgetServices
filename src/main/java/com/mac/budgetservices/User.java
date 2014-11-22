/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.budgetservices;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MacDerson
 */
@Entity
@Table(name = "user", catalog = "finance", schema = "budget")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserId", query = "SELECT u FROM User u WHERE u.userId = :userId"),
    @NamedQuery(name = "User.findByUserFname", query = "SELECT u FROM User u WHERE u.userFname = :userFname"),
    @NamedQuery(name = "User.findByUserLname", query = "SELECT u FROM User u WHERE u.userLname = :userLname"),
    @NamedQuery(name = "User.findByUserPhone", query = "SELECT u FROM User u WHERE u.userPhone = :userPhone"),
    @NamedQuery(name = "User.findByUserEmail", query = "SELECT u FROM User u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "User.findByUserPreferredContact", query = "SELECT u FROM User u WHERE u.userPreferredContact = :userPreferredContact")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "user_fname")
    private String userFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "user_lname")
    private String userLname;
    @Size(max = 10)
    @Column(name = "user_phone")
    private String userPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "user_email")
    private String userEmail;
    @Size(max = 5)
    @Column(name = "user_preferred_contact")
    private String userPreferredContact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incomeUserId")
    private Collection<Income> incomeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "billOwner")
    private Collection<Bill> billCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentUserId")
    private Collection<Payment> paymentCollection;
    @JoinColumn(name = "user_address", referencedColumnName = "address_id")
    @ManyToOne
    private Address userAddress;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paycheckOwner")
    private Collection<Paycheck> paycheckCollection;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String userFname, String userLname, String userEmail) {
        this.userId = userId;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPreferredContact() {
        return userPreferredContact;
    }

    public void setUserPreferredContact(String userPreferredContact) {
        this.userPreferredContact = userPreferredContact;
    }

    //@XmlTransient
    public Collection<Income> getIncomeCollection() {
        return incomeCollection;
    }

    public void setIncomeCollection(Collection<Income> incomeCollection) {
        this.incomeCollection = incomeCollection;
    }

    //@XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
    }

    @XmlTransient
    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    public Address getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(Address userAddress) {
        this.userAddress = userAddress;
    }

    //@XmlTransient
    public Collection<Paycheck> getPaycheckCollection() {
        return paycheckCollection;
    }

    public void setPaycheckCollection(Collection<Paycheck> paycheckCollection) {
        this.paycheckCollection = paycheckCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mac.budgetservices.User[ userId=" + userId + " ]";
    }
    
}
