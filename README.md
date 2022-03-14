# Spring boot crud 기본 api 보일러 플레이트 

# spring boot mybatis 초기 설정시 주의사항
마이바티스 sql 작성 xml 파일을 매핑할때 간혹 application.properties 에 설정해도 잘 안되서 main function 에 설정하여 자바 application 실행시 설정 하도록 해주었다.
이점은 참고하도록
``` java

package com.mybootapp.mybootapp;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MybootappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootappApplication.class, args);
	}
	@Autowired
	private ApplicationContext applicationContext;
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}



```

위를 보면 

sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*.xml")); 

이부분이 중요하다. 저것을 빼먹으면 mybatis 매핑이 되지않는다.

# create
데이터를 간단하게 생성한다.
http Method : post 
<img width="501" alt="스크린샷 2022-03-14 오후 3 50 19" src="https://user-images.githubusercontent.com/69393030/158119614-0058e558-9e60-4bb5-a66d-61400ccaba36.png">

이때 body 의 값은 @RequestBody 로 받고 , 그에 맞는 dto , vo 를 샛엉하여 parameter 에 따른 타입을 설정한다.
# update 
http Method : put 
데이터를 수정한다. 

<img width="501" alt="스크린샷 2022-03-14 오후 3 50 58" src="https://user-images.githubusercontent.com/69393030/158119708-7b74f058-51d8-4458-9c5e-67509befe4dd.png">

# delete 
데이터를 삭제한다.
@pathVariable 어노테이션을 통해 삭제할 컨텐츠의 index 를 path 에서 변수로 받아올수있다.
http Method : delete 
<img width="501" alt="스크린샷 2022-03-14 오후 3 51 41" src="https://user-images.githubusercontent.com/69393030/158119782-a7d51b40-9a11-4459-8f54-408054a5c29b.png">

# read 
데이터를 조회한다.
http Method : get , post ( 상황에 따라 ) 
<img width="517" alt="스크린샷 2022-03-14 오후 3 53 21" src="https://user-images.githubusercontent.com/69393030/158120012-24b56a4e-74a7-4e84-b087-ec140f6d5dc4.png">

오라클에서 페이징 처리하여 데이터를 조회할때 

RowNumber 와 subquery 를 이용하여 페이징 처리를한다 
mysql 은 limit offset 사용 
``` sql
SELECT * FROM (
			SELECT row_number() over(ORDER BY t1.rdate ASC) num ,
			board_num AS boardNum,
			userId as userId,
			boardtopic as boardTopic,
			rdate as rDate
			FROM BOARD t1
		)
		where num between #{start} AND #{end}

```
