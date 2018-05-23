package com.app.saad.entidades;

import com.app.saad.entidades.Adopcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T18:12:19")
@StaticMetamodel(Adoptante.class)
public class Adoptante_ { 

    public static volatile SingularAttribute<Adoptante, String> apellidoPaterno;
    public static volatile SingularAttribute<Adoptante, Integer> idAdoptante;
    public static volatile SingularAttribute<Adoptante, String> correo;
    public static volatile ListAttribute<Adoptante, Adopcion> adopcionList;
    public static volatile SingularAttribute<Adoptante, String> telefono;
    public static volatile SingularAttribute<Adoptante, String> nombre;
    public static volatile SingularAttribute<Adoptante, String> apellidoMaterno;

}