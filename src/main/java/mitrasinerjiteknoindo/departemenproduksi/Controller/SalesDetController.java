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

import mitrasinerjiteknoindo.departemenproduksi.Repository.SalesDetRepository;
import mitrasinerjiteknoindo.departemenproduksi.model.entity.SalesDet;

@RestController
@RequestMapping("/api/sales-det")
public class SalesDetController {

    @Autowired
    private SalesDetRepository salesDetRepository;

    // Mendapatkan semua detail penjualan
    @GetMapping
    public List<SalesDet> getAllSalesDet() {
        return salesDetRepository.findAll();
    }

    // Mendapatkan detail penjualan berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<SalesDet> getSalesDetById(@PathVariable(value = "id") Integer salesDetId) {
        Optional<SalesDet> salesDet = salesDetRepository.findById(salesDetId);
        if (salesDet.isPresent()) {
            return ResponseEntity.ok().body(salesDet.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Membuat detail penjualan baru
    @PostMapping
    public SalesDet createSalesDet(@RequestBody SalesDet salesDet) {
        return salesDetRepository.save(salesDet);
    }

    // Memperbarui detail penjualan berdasarkan ID
    @PutMapping("/{id}")
    public ResponseEntity<SalesDet> updateSalesDet(
            @PathVariable(value = "id") Integer salesDetId, @RequestBody SalesDet salesDetDetails) {
        Optional<SalesDet> optionalSalesDet = salesDetRepository.findById(salesDetId);
        if (optionalSalesDet.isPresent()) {
            SalesDet salesDet = optionalSalesDet.get();
            salesDet.setQty(salesDetDetails.getQty());
            salesDet.setSubtotal(salesDetDetails.getSubtotal());
            salesDet.setHargaDiskon(salesDetDetails.getHargaDiskon());
            return ResponseEntity.ok().body(salesDetRepository.save(salesDet));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Menghapus detail penjualan berdasarkan ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesDet(@PathVariable(value = "id") Integer salesDetId) {
        Optional<SalesDet> salesDet = salesDetRepository.findById(salesDetId);
        if (salesDet.isPresent()) {
            salesDetRepository.delete(salesDet.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
