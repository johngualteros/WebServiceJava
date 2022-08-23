/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import model.CuentaDao;

/**
 *
 * @author Aprendiz
 */
@WebService(serviceName = "NewWebService")
@Stateless()
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "consultingAcount")
    public int consultingAcount(@WebParam(name = "numerocuenta") int numerocuenta) {
        int saldo = 0;
        try{
            CuentaDao cuentaDao = new CuentaDao();
            saldo = cuentaDao.queryBalance(numerocuenta);
            return saldo;
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return saldo;
    }
}
