package javaclub.library.config;

import javaclub.library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component  //id = annotatedBean - по-умолчанию
//@Component("qqqqErdflgk")  - определить
public class AnnotatedBean {
    @Autowired
    Author author;

}
