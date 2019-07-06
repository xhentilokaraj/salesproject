package db;

import db.Sales;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-06T11:51:27")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, Date> arrivaldate;
    public static volatile CollectionAttribute<Products, Sales> salesCollection;
    public static volatile SingularAttribute<Products, Integer> quantityavl;
    public static volatile SingularAttribute<Products, Integer> productid;
    public static volatile SingularAttribute<Products, BigDecimal> price;
    public static volatile SingularAttribute<Products, String> productname;
    public static volatile SingularAttribute<Products, String> manufacturer;

}