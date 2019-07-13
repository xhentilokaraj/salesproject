package db;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-13T21:45:49")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, Date> arrivaldate;
    public static volatile SingularAttribute<Products, Integer> quantityavl;
    public static volatile SingularAttribute<Products, Integer> productid;
    public static volatile SingularAttribute<Products, BigDecimal> price;
    public static volatile SingularAttribute<Products, String> productname;
    public static volatile SingularAttribute<Products, String> manufacturer;

}