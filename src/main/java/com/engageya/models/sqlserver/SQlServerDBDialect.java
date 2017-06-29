package com.engageya.models.sqlserver;

import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.type.StandardBasicTypes;

import java.sql.Types;

/**
 * Created by DANIEL on 1/8/2017
 * see: http://stackoverflow.com/questions/27039300/jpa-sql-server-no-dialect-mapping-for-jdbc-type-9
 * <p>
 * Important: if you change this class name, or move it, don't forget to update application.properties.
 */
public class SQlServerDBDialect extends SQLServerDialect {

    public SQlServerDBDialect() {
        super();
        registerHibernateType(Types.NCHAR, StandardBasicTypes.CHARACTER.getName());
        registerHibernateType(Types.NCHAR, 1, StandardBasicTypes.CHARACTER.getName());
        registerHibernateType(Types.NCHAR, 255, StandardBasicTypes.STRING.getName());
        registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
        registerHibernateType(Types.LONGNVARCHAR, StandardBasicTypes.TEXT.getName());
        registerHibernateType(Types.NCLOB, StandardBasicTypes.CLOB.getName());

    }
}