package repository;

import model.Office;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ADIN on 3/11/2017.
 */
public interface OfficeRepository extends JpaRepository<Office,Integer>,OfficeRepositoryCustom{
}
