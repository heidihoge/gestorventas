/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package is2.seguridad;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

@ManagedBean
@Named("loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String username;
    private boolean logueado = false;

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    public boolean isLogueado() {
        return logueado;
    }
    private String password;
    
    @PersistenceContext(unitName = "gestorVentasPU")
    private EntityManager em;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String validateUsernamePassword() {
        boolean valid = validate(username, password);
        if (valid) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", username);
            logueado = true;
            return "/index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Usuario y Contraseña invalida",
                            "Por favor ingrese Usuario y Contraseña"));
            return "/index?faces-redirect=true";
        }
    }

    private boolean validate(String username, String password) {

        try {
            Query getUserQuery = em.createNativeQuery("Select nombre, "
                    + "password "
                    + "from usuarios "
                    + "where nombre = ? and password = ?");
            
            getUserQuery.setParameter(1, username);
            getUserQuery.setParameter(2, password);

            Object singleResult = getUserQuery.getSingleResult();
            return singleResult != null;
            
        } catch (Exception ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } 
        return false;
    }

    //logout
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "/index?faces-redirect=true";
    }
}