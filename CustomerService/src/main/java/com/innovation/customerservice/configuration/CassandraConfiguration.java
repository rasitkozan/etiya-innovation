package com.innovation.customerservice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;


@Configuration
@EnableCassandraRepositories
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${innovation.cassandra.contact.point}")
    private String contactPoint;

    @Value("${innovation.cassandra.keyspace.name}")
    private String keySpaceName;

    @Value("${innovation.cassandra.port}")
    private int port;

    @Value("${innovation.cassandra.username}")
    private String getUserName;

    @Value("${innovation.cassandra.password}")
    private String getUserPassword;


    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }

    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.innovation.customerservice"};
    }


    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setUsername(getUserName);
        clusterFactoryBean.setPassword(getUserPassword);
        return clusterFactoryBean;
    }
  /*  @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cassandraSession = super.cassandraSession();
        cassandraSession.setUsername(getUserName);
        cassandraSession.setPassword(getUserPassword);
        return cassandraSession;
    }*/
}
