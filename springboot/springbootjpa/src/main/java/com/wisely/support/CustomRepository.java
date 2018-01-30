package com.wisely.support;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
//To enable Specification the interface must extends JpsSpecificationExecutor
@NoRepositoryBean //This annotation infers that this class is not an interface of the domain class(e.g. PersonRepository extends JpaRepository-> i.e CustomRepository is not like PersonRepository)
public interface CustomRepository<T, ID extends Serializable>extends JpaRepository<T, ID> ,JpaSpecificationExecutor<T>{
	
	Page<T> findByAuto(T example,Pageable pageable);
	

}
