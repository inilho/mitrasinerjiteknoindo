package mitrasinerjiteknoindo.departemenproduksi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mitrasinerjiteknoindo.departemenproduksi.Repository.SalesRepository;
import mitrasinerjiteknoindo.departemenproduksi.model.entity.Sales;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;

    // Mendapatkan semua penjualan
    @GetMapping
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    // Mendapatkan penjualan berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Sales> getSalesById(@PathVariable(value = "id") Integer salesId) {
        Optional<Sales> sales = salesRepository.findById(salesId);
        if (sales.isPresent()) {
            return ResponseEntity.ok().body(sales.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Membuat penjualan baru
    @PostMapping
    public Sales createSales(@RequestBody Sales sales) {
        return salesRepository.save(sales);
    }

    // Memperbarui penjualan berdasarkan ID
    @PutMapping("/{id}")
    public ResponseEntity<Sales> updateSales(
            @PathVariable(value = "id") Integer salesId, @RequestBody Sales salesDetails) {
        Optional<Sales> optionalSales = salesRepository.findById(salesId);
        if (optionalSales.isPresent()) {
            Sales sales = optionalSales.get();
            sales.setKode(salesDetails.getKode());
            sales.setTgl(salesDetails.getTgl());
            sales.setHargaBandrol(salesDetails.getHargaBandrol());
            sales.setDiskonPct(salesDetails.getDiskonPct());
            sales.setDiskonNilai(salesDetails.getDiskonNilai());
            sales.setOngkir(salesDetails.getOngkir());
            sales.setTotalBayar(salesDetails.getTotalBayar());
            return ResponseEntity.ok().body(salesRepository.save(sales));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Menghapus penjualan berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSales(@PathVariable(value = "id") Integer salesId) {
        Optional<Sales> sales = salesRepository.findById(salesId);
        if (sales.isPresent()) {
            salesRepository.delete(sales.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
