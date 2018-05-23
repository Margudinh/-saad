package com.app.saad.entidades;

import com.app.saad.entidades.Adoptante;
import com.app.saad.entidades.AnimalesDomesticos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T19:52:19")
@StaticMetamodel(Adopcion.class)
public class Adopcion_ { 

    public static volatile SingularAttribute<Adopcion, Date> fecha;
    public static volatile SingularAttribute<Adopcion, Integer> folioAdopcion;
    public static volatile SingularAttribute<Adopcion, AnimalesDomesticos> idAnimal;
    public static volatile SingularAttribute<Adopcion, Adoptante> idAdoptante;

}