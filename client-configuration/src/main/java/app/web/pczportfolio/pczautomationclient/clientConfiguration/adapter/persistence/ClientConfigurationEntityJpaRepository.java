package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ClientConfigurationEntityJpaRepository extends JpaRepository<ClientConfigurationEntity, Long> {
}
