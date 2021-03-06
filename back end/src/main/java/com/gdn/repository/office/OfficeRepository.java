package com.gdn.repository.office;

import com.gdn.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dias on 3/30/2017.
 */
@Repository
public interface OfficeRepository extends JpaRepository<Office, String>, OfficeRepositoryCustom {
}
