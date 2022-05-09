package be.technifutur.client.repositories;

import be.technifutur.client.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional <Client> findByrefClient(UUID reference);
}
