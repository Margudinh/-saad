package com.app.saad.entidades;

import com.app.saad.entidades.Adopcion;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-31T02:27:27")
@StaticMetamodel(Adoptantes.class)
public class Adoptantes_ { 

    public static volatile SingularAttribute<Adoptantes, String> password;
    public static volatile SingularAttribute<Adoptantes, Integer> idAdoptante;
    public static volatile SingularAttribute<Adoptantes, String> correo;
    public static volatile ListAttribute<Adoptantes, Adopcion> adopcionList;
    public static volatile SingularAttribute<Adoptantes, String> nombreCompleto;
    public static volatile SingularAttribute<Adoptantes, String> telefono;

}