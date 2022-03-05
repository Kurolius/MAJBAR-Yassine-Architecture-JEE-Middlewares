package pres;

import dao.IDao;
import metier.IMetier;
import metier.IMetierImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner scanner=new Scanner(new File("config.txt"));

        String daoClassName=scanner.nextLine();
        Class cDao=Class.forName(daoClassName);
        IDao dao=(IDao)cDao.newInstance();

        String metierClassName=scanner.nextLine();
        Class cmetier=Class.forName(metierClassName);
        IMetier metier=(IMetier)cmetier.newInstance();

        Method method= cmetier.getMethod("setDao",IDao.class);
        method.invoke(metier,dao);

        System.out.println(metier.calcul());
    }
}
