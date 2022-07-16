package moveApplication.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import moveApplication.springboot.model.Deplacement;

@Repository
public interface DeplacementRepository extends JpaRepository<Deplacement, Long> {

//	public List<Deplacement> findOneByEmployee(Employee employee);

}
