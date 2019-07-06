package db;

import db.Products;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-07-06T11:51:27")
@StaticMetamodel(Sales.class)
public class Sales_ { 

    public static volatile SingularAttribute<Sales, Integer> salesid;
    public static volatile SingularAttribute<Sales, BigDecimal> totalamount;
    public static volatile SingularAttribute<Sales, Products> productid;
    public static volatile SingularAttribute<Sales, Date> salesdate;
    public static volatile SingularAttribute<Sales, Integer> nrofitems;

}