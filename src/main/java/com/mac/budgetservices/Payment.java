/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.budgetservices;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MacDerson
 */
@Entity
@Table(name = "payment", catalog = "finance", schema = "budget")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentId", query = "SELECT p FROM Payment p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "Payment.findByPaymentDueDate", query = "SELECT p FROM Payment p WHERE p.paymentDueDate = :paymentDueDate"),
    @NamedQuery(name = "Payment.findByPaymentFilingDate", query = "SELECT p FROM Payment p WHERE p.paymentFilingDate = :paymentFilingDate"),
    @NamedQuery(name = "Payment.findByPaymentLastNotificationDate", query = "SELECT p FROM Payment p WHERE p.paymentLastNotificationDate = :paymentLastNotificationDate"),
    @NamedQuery(name = "Payment.findByPaymentPaidDate", query = "SELECT p FROM Payment p WHERE p.paymentPaidDate = :paymentPaidDate")})
public class Payment implements Serializable {
    @Size(max = 2147483647)
    @Column(name = "payment_qrcode_location", length = 2147483647)
    private String paymentQrcodeLocation;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "payment_id")
    private String paymentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_due_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "payment_filing_date")
    @Temporal(TemporalType.DATE)
    private Date paymentFilingDate;
    @Column(name = "payment_last_notification_date")
    @Temporal(TemporalType.DATE)
    private Date paymentLastNotificationDate;
    @Column(name = "payment_paid_date")
    @Temporal(TemporalType.DATE)
    private Date paymentPaidDate;
    @JoinColumn(name = "payment_bill_id", referencedColumnName = "bill_id")
    @ManyToOne(optional = false)
    private Bill paymentBillId;
    @JoinColumn(name = "payment_user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User paymentUserId;

    public Payment() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        if (Objects.isNull(this.paymentId) || this.paymentId.isEmpty()) {
            this.paymentId = paymentId;
        }
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
        generateId();
    }

    public Date getPaymentFilingDate() {
        return paymentFilingDate;
    }

    public void setPaymentFilingDate(Date paymentFilingDate) {
        this.paymentFilingDate = paymentFilingDate;
    }

    public Date getPaymentLastNotificationDate() {
        return paymentLastNotificationDate;
    }

    public void setPaymentLastNotificationDate(Date paymentLastNotificationDate) {
        this.paymentLastNotificationDate = paymentLastNotificationDate;
    }

    public Date getPaymentPaidDate() {
        return paymentPaidDate;
    }

    public void setPaymentPaidDate(Date paymentPaidDate) {
        this.paymentPaidDate = paymentPaidDate;
    }

    @XmlTransient
    public Bill getPaymentBillId() {
        return paymentBillId;
    }

    public void setPaymentBillId(Bill paymentBillId) {
        this.paymentBillId = paymentBillId;
        generateId();
    }

    @XmlTransient
    public User getPaymentUserId() {
        return paymentUserId;
    }

    public void setPaymentUserId(User paymentUserId) {
        this.paymentUserId = paymentUserId;
    }

    @Override
    public int hashCode() {
        HashFunction hf = Hashing.md5();
        HashCode hc = hf.newHasher().putString(paymentId, Charsets.UTF_8).hash();
        return hc.asInt();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        return Objects.equals(this.paymentId, other.paymentId);
    }

    @Override
    public String toString() {
        return "com.mac.budgetmanager.pojo.entities.Payment[ paymentId=" + paymentId + " ]";
    }

    private void generateId() {
        if (Objects.nonNull(paymentDueDate) && Objects.nonNull(paymentBillId)
                && Objects.nonNull(paymentBillId.getBillId())
                && !paymentBillId.getBillId().isEmpty()
                && Objects.nonNull(paymentBillId.getBillOwner())
                && Objects.nonNull(paymentBillId.getBillOwner().getUserId())
                && !paymentBillId.getBillOwner().getUserId().isEmpty()) {
            HashFunction hf = Hashing.md5();
            HashCode hc = hf.newHasher()
                    .putLong(paymentDueDate.getTime())
                    .putString(paymentBillId.getBillId(), Charsets.UTF_8)
                    .putString(paymentBillId.getBillOwner().getUserId(), Charsets.UTF_8).hash();
            this.paymentId = hc.toString();
        }
    }
    
    public String getPaymentQrcodeLocation() {
        return paymentQrcodeLocation;
    }

    public void setPaymentQrcodeLocation(String paymentQrcodeLocation) {
        this.paymentQrcodeLocation = paymentQrcodeLocation;
    }
}
