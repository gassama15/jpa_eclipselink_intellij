import com.groupeisi.entities.Role;
import com.groupeisi.entities.User;
import com.groupeisi.repository.IRole;
import com.groupeisi.repository.IUser;
import com.groupeisi.repository.RoleImpl;
import com.groupeisi.repository.UserImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        IRole iRole = new RoleImpl();
        IUser iUser = new UserImpl();

        Role role = new Role();
        role.setId(1);
        role.setNom("ROLE_SUPERADMIN");

        User user = new User();
        user.setId(1);
        user.setPrenom("Sanoussy");
        user.setNom("GASSAMA");
        user.setEmail("sanoussy.gassama@gmail.com");
        user.setPassword("passer");
        user.setEtat(1);

        int result = iUser.saisie(user);

        iRole.terminate();
        iUser.terminate();

        if(result == 1)
            System.out.println("Insertion avec succés.");
        else
            System.out.println("Insertion avec échouée.");;
        EntityManager em;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaEclipseLink_IntelliJ");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.persist(role);
        em.getTransaction().commit();
        em.close();

    }
}