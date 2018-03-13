package datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSource1
{
    private MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSource1()
    {
        dataSource.setServerName("46.101.210.44");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("cupcake");
        dataSource.setUser("ruben1234");
        dataSource.setPassword("1234");
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}
