package UserMvc;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
	/*To configure EntityManager which is managed by Spring container
	 *Further persistence name "dev" is mapped 
	 *This class must be annotated by Configuration for indicating a Bean is present
	 *Other packages must be base package from this package
	 *EntityManager is used to manage entity by providing methods for CRUD operations
	 */
	@Bean
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("dev").createEntityManager();

	}
}
