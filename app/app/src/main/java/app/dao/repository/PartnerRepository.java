package app.dao.repository;

import app.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    // Método ajustado para buscar por el ID del usuario
    Partner findByUserId_Id(Long userId); // Busca por el ID del User

    // Método adicional para buscar por el nombre de usuario del User relacionado
    Partner findByUserId_UserName(String userName); // Busca por el nombre de usuario del User

    long countByType(String type);
}
