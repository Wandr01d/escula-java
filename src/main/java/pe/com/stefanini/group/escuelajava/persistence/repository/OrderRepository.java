package pe.com.stefanini.group.escuelajava.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.stefanini.group.escuelajava.persistence.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	@Query(value = "{call  SP_ReporteOrdenesAtendidasStatus2()}", nativeQuery = true)
	List<Order>  findByReporteOrdenesAtendidasStatus2();
	
	@Query(value = "select * from ViewReportOrderPendientesUltimosTresMesSatado1", nativeQuery = true)
	List<Order> findByViewReportOrderPendientesUltimosTresMesSatado1();

}
