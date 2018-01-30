package com.wisely.specs;

import static com.google.common.collect.Iterables.toArray;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;
/*
 * Provide a general method to query according to an entity given, considering a part of the entity fields' value given, type of string or others.
 * */
public class CustomerSpecs {

	public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example) { //1

		final Class<T> type = (Class<T>) example.getClass();//2

		return new Specification<T>() {

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicates = new ArrayList<>(); //3
				
				EntityType<T> entityType = entityManager.getMetamodel().entity(type);//4 We can get entity attributes from entityType
				
				for (Attribute<T, ?> attr : entityType.getDeclaredAttributes()) {//5
					Object attrValue = getValue(example, attr); //6 Get value of an attribute
					if (attrValue != null) {
						if (attr.getJavaType() == String.class) { //7
							if (!StringUtils.isEmpty(attrValue)) { //8  If the field type is String, build as like %xxx%.
								predicates.add(cb.like(root.get(attribute(entityType, attr.getName(), String.class)),
										pattern((String) attrValue))); //9
							}
						} else {
							predicates.add(cb.equal(root.get(attribute(entityType, attr.getName(), attrValue.getClass())),
									attrValue)); //10  If the field type is not string ,build as equal xxx
						}
					}

				}
				return predicates.isEmpty() ? cb.conjunction() : cb.and(toArray(predicates, Predicate.class));//11
			}

			/**
			 * 12
			 */
			private <T> Object getValue(T example, Attribute<T, ?> attr) {
				return ReflectionUtils.getField((Field) attr.getJavaMember(), example);
			}
			
			/**
			 * 13
			 */
			private <E, T> SingularAttribute<T, E> attribute(EntityType<T> entity, String fieldName,
					Class<E> fieldClass) { 
				return entity.getDeclaredSingularAttribute(fieldName, fieldClass);
			}

		};

	}
	
	/**
	 * 14
	 */
	static private String pattern(String str) {
		return "%" + str + "%";
	}

}
