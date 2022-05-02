package be.technifutur.commands.data.repo;

import be.technifutur.commands.models.entities.Clients;
import be.technifutur.commands.models.entities.Commands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clients, Long> {
}
