package io.github.prittspadelord.config;

import io.github.prittspadelord.services.GenshinDatabaseService;
import io.github.prittspadelord.services.impl.GenshinDatabaseServiceImpl;

import org.aopalliance.aop.Advice;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
@ComponentScan(basePackages = "io.github.prittspadelord.advices")
public class SpringAppConfig {

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public Advisor validateCharacterForInsertCharacterMethodPointcutAdvisor(@Autowired Advice advice) {
        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor();
        advisor.setAdvice(advice);
        advisor.addMethodName("insertCharacter");

        return advisor;
    }

    @Bean
    public GenshinDatabaseService databaseService(@Autowired Advisor advisor) throws ClassNotFoundException {
        ProxyFactoryBean pf = new ProxyFactoryBean();
        pf.setTarget(new GenshinDatabaseServiceImpl());
        pf.addAdvisor(advisor);
        pf.setProxyInterfaces(new Class[] { GenshinDatabaseService.class });

        return (GenshinDatabaseService) pf.getObject();
    }
}