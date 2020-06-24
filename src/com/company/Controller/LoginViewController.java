package com.company.Controller;

import com.company.App.Login;
import com.company.App.User;
import com.company.Domain.CapaDatos;
import com.company.MVC.Controller;
import com.company.Model.Usuario;
import com.company.View.AdminView;
import com.company.View.LoginView;
import com.company.View.UserView;

import java.util.ArrayList;
import java.util.List;

public class LoginViewController implements Controller {

    private Login login;

    public LoginViewController(Login login) {
        this.login = login;
    }



    //si es usuario lo manda al menu de usuario
    //si es admin lo manda al menu de admin
    @Override
    public boolean execute(String command) {
        if (login.getUser().isEmpty()){
            String user = command;
            List<Usuario> arrayUser  = new ArrayList<>();
            arrayUser = CapaDatos.getUsersList();
            for (Usuario usuario: arrayUser
            ) {
                if (usuario.getUser().equals(user)){
                    login.setUser(user);
                }
            }
            if (login.getUser().isEmpty()){
                System.out.println("Usuario inexistente, ingrese nuevamente.");
                login.changed();
            }
        }else {
            String pass = command;
            List<Usuario> arrayUser  = new ArrayList<>();
            arrayUser = CapaDatos.getUsersList();
            for (Usuario usuario: arrayUser
            ) {
                if (usuario.getPass().equals(pass)){
                    login.setPass(pass);
                    Usuario.getUsuario(usuario.getUser(), usuario.getPass());
                    System.out.println("\nInicio de sesion completado\n");
                    User user = new User();
                    UserViewController userViewController = new UserViewController(user);
                    UserView userView = new UserView(userViewController, user);
                    userView.show();
                }
            }
            if (login.getPass().isEmpty()){
                System.out.println("Contraseña incorrecta, ingrese nuevamente.");
            }
        }
        return true;
    }
}
