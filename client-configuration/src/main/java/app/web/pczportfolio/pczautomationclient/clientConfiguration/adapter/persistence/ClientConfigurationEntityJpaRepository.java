package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface ClientConfigurationEntityJpaRepository extends JpaRepository<ClientConfigurationEntity, Long> {

    @Query("select count(c) > 0 from ClientConfigurationEntity c")
    boolean configurationExists();

}
