package com.arrobaciencia.app;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.arrobaciencia.app.models.AppUser;
import com.arrobaciencia.app.models.Event;
import com.arrobaciencia.app.models.Role;
import com.arrobaciencia.app.repositories.IAppUserRepo;
import com.arrobaciencia.app.repositories.IEventRepo;
import com.arrobaciencia.app.repositories.IRoleRepo;

@Component
public class InicializarDb {

	@Autowired
    private IAppUserRepo appUserRepo;
	@Autowired
	private IEventRepo eventUserRepo;
	@Autowired
	private IRoleRepo roleRepo;
   
    @EventListener(ContextRefreshedEvent.class)
    public void doOnStartup() throws IOException {
    	
    	Role admin = new Role(1L,"ADMIN");
    	roleRepo.save(admin);
    	
    	ArrayList<Role> rolesDeJose = new ArrayList<Role>();
    	rolesDeJose.add(admin);
    	
    	AppUser usuario = new AppUser(null,"Jose","jose123","$2a$12$Vq1Y.wnb.Pndk7.7ZTwq7OSBXuPCJ3qcsxJzBNveIGgaZ3K3r1.Wy",rolesDeJose);
    	AppUser usuario2 = new AppUser(null,"Pablo","pablo124","$2a$12$Vq1Y.wnb.Pndk7.7ZTwq7OSBXuPCJ3qcsxJzBNveIGgaZ3K3r1.Wy",null);
    	Event fecha = new Event(1L,"01","08","1992",2,1000,true);
    	
    	appUserRepo.save(usuario);
    	appUserRepo.save(usuario2);
    	eventUserRepo.save(fecha);
     
    }
 

}
