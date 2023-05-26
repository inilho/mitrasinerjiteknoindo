package mitrasinerjiteknoindo.departemenproduksi.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mitrasinerjiteknoindo.departemenproduksi.model.entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Integer> {
    // Mencari penjualan berdasarkan kode
    Sales findByKode(String kode);

    // Mencari penjualan berdasarkan tanggal
    List<Sales> findByTglBetween(Date startDate, Date endDate);

}