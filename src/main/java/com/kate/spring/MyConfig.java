package com.kate.spring;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("com.kate.spring")
@PropertySource("classpath:appProperties.properties")
public class MyConfig {

    @Bean
    @Scope("singleton")
    public Pet catBean()
    {
        return new Cat();
    }

    @Bean
    public Person personBean()
    {
        return new Person(catBean());
    }


}
