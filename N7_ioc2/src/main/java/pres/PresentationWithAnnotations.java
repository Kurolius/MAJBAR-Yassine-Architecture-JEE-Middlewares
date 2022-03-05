package pres;

import metier.IMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PresentationWithAnnotations {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("dao","metier");
        IMetier metier = context.getBean(IMetier.class);
        System.out.println("version Annotation = "+metier.calcul());
    }
}
