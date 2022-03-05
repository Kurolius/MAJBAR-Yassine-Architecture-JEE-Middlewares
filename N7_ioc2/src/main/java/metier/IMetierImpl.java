package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IMetierImpl implements IMetier {
    //couplage faible
    @Autowired
    private IDao dao;
    @Override
    public double calcul(){
        double tmp=dao.getData();
        double res = tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
    public void setDao(IDao dao){
        this.dao = dao;
    }
}
