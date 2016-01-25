dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "com.mysql.jdbc.Driver"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
}

//environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost/tflb"
            username = "root"
            //password = "mysecretadminpassword"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://tlfbsystem.tch.harvard.edu:3306/tflb?autoReconnect=true"
            properties {
              testOnBorrow = true
              testWhileIdle = true
              testOnReturn = false
              validationQuery = "SELECT 1"
              timeBetweenEvictionRunsMillis=60000
            }
            username = "tlfbmysql"
            password = "lSz0xcoplV8F"
        }
    }
}
