package com.app.saad.entidades;

import com.app.saad.entidades.Adopcion;
import com.app.saad.entidades.DetallesAd;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-22T18:12:19")
@StaticMetamodel(AnimalesDomesticos.class)
public class AnimalesDomesticos_ { 

    public static volatile SingularAttribute<AnimalesDomesticos, String> especie;
    public static volatile SingularAttribute<AnimalesDomesticos, Integer> idAnimal;
    public static volatile ListAttribute<AnimalesDomesticos, DetallesAd> detallesAdList;
    public static volatile ListAttribute<AnimalesDomesticos, Adopcion> adopcionList;
    public static volatile SingularAttribute<AnimalesDomesticos, String> sexo;
    public static volatile SingularAttribute<AnimalesDomesticos, String> nombre;

}