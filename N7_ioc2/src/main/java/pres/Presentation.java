package pres;

import dao.DaoImpl;
import ext.DaoImpl2;
import metier.IMetierImpl;

public class Presentation {
    public static void main(String[] args){
        DaoImpl2 dao = new DaoImpl2();
        IMetierImpl metier = new IMetierImpl();
        metier.setDao(dao);
        System.out.println(metier.calcul());
    }
}
