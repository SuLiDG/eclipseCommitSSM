package com.df.ssm.commons;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * Bean id 采用 全类名(含包名和类名)
 * 默认采用只是类名
 * 解决不同包不同模块下相同类名的问题
 * @author J.L.Zhou
 *
 */
public class FullBeanNameGenerator extends AnnotationBeanNameGenerator {

	@Override
	protected String buildDefaultBeanName(BeanDefinition definition) {
		return definition.getBeanClassName();
	}
}
