/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CRS
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s")
    , @NamedQuery(name = "Sales.findBySalesid", query = "SELECT s FROM Sales s WHERE s.salesid = :salesid")
    , @NamedQuery(name = "Sales.findBySalesdate", query = "SELECT s FROM Sales s WHERE s.salesdate = :salesdate")
    , @NamedQuery(name = "Sales.findByTotalamount", query = "SELECT s FROM Sales s WHERE s.totalamount = :totalamount")
    , @NamedQuery(name = "Sales.findByNrofitems", query = "SELECT s FROM Sales s WHERE s.nrofitems = :nrofitems")})
public class Sales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "salesid")
    private Integer salesid;
    @Column(name = "salesdate")
    @Temporal(TemporalType.DATE)
    private Date salesdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalamount")
    private BigDecimal totalamount;
    @Column(name = "nrofitems")
    private Integer nrofitems;
    @JoinColumn(name = "productid", referencedColumnName = "productid")
    @ManyToOne
    private Products productid;

    public Sales() {
    }

    public Sales(Integer salesid) {
        this.salesid = salesid;
    }

    public Integer getSalesid() {
        return salesid;
    }

    public void setSalesid(Integer salesid) {
        this.salesid = salesid;
    }

    public Date getSalesdate() {
        return salesdate;
    }

    public void setSalesdate(Date salesdate) {
        this.salesdate = salesdate;
    }

    public BigDecimal getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(BigDecimal totalamount) {
        this.totalamount = totalamount;
    }

    public Integer getNrofitems() {
        return nrofitems;
    }

    public void setNrofitems(Integer nrofitems) {
        this.nrofitems = nrofitems;
    }

    public Products getProductid() {
        return productid;
    }

    public void setProductid(Products productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesid != null ? salesid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.salesid == null && other.salesid != null) || (this.salesid != null && !this.salesid.equals(other.salesid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "db.Sales[ salesid=" + salesid + " ]";
    }
    
}
