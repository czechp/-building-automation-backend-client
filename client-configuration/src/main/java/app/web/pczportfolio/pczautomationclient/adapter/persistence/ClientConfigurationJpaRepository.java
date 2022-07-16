package app.web.pczportfolio.pczautomationclient.adapter.persistence;

import app.web.pczportfolio.pczautomationclient.domain.ClientConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ClientConfigurationJpaRepository extends JpaRepository<ClientConfiguration, Long> {
    
}
