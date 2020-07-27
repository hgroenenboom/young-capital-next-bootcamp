package com.harold.app;

/*

// Trein
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
// Train repository
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
// TreinService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TrainEndPoint
//import javax.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// JerseyConfig
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

// SimpleCORSFilter
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

public class DataBaseTest {

}

@Entity
class Trein {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String merk;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}
}

// Is a repository containing Trein(s)
@Repository
interface TreinRepository extends JpaRepository<Trein, Long>{

}

// Has a TreinRepository
@Service
@Transactional
class TreinService {
	
	@Autowired
	private TreinRepository treinRepository;

	public Trein save(Trein trein){
		return treinRepository.save(trein);
	}
	
	public Trein findById(Long id) {
		return treinRepository.findById(id).get();
	}

	public Iterable <Trein> findAll(){
		Iterable <Trein> result = treinRepository.findAll();
		return result;
	}
}


@Path("trein")
@Component
class TreinEndpoint {
	
	@Autowired
	private TreinService treinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listGroep(){
		Iterable <Trein> treinen = treinService.findAll();
		return Response.ok(treinen).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response postTrein(Trein trein){
		Trein result = treinService.save(trein);
		return Response.accepted(result.getId()).build();	
	}

}

@Component
@ApplicationPath("/api")
class JerseyConfig extends ResourceConfig {
	public JerseyConfig(){
		register(TreinEndpoint.class);
	}
}



@Component
class SimpleCORSFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "36000");
        response.setHeader("Access-Control-Allow-Headers", "origin, content-type, accept");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

}


*/

