package mitrasinerjiteknoindo.departemenproduksi.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mitrasinerjiteknoindo.departemenproduksi.Service.BarangService;
import mitrasinerjiteknoindo.departemenproduksi.model.entity.Barang;

@RestController
@RequestMapping("/api/barang")
public class BarangController {

    private BarangService barangService;

    @GetMapping("/barang")
    public String displayBarang(Model model) {
        List<Barang> daftarBarang = barangService.getAllBarang();
        model.addAttribute("barangs", daftarBarang);
        return "barang-list";
    }

    public BarangController(BarangService barangService) {
        this.barangService = barangService;
    }

    @GetMapping
    public ResponseEntity<List<Barang>> getAllBarang() {
        List<Barang> daftarBarang = barangService.getAllBarang();
        return ResponseEntity.ok(daftarBarang);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Barang> getBarangById(@PathVariable Integer id) {
        Barang barang = barangService.getBarangById(id);
        if (barang != null) {
            return ResponseEntity.ok(barang);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Barang> createBarang(@RequestBody Barang barang) {
        Barang createdBarang = barangService.createBarang(barang);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBarang);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barang> updateBarang(@PathVariable Integer id, @RequestBody Barang barang) {
        Barang updatedBarang = barangService.updateBarang(id, barang);
        if (updatedBarang != null) {
            return ResponseEntity.ok(updatedBarang);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBarang(@PathVariable Integer id) {
        barangService.deleteBarang(id);
        return ResponseEntity.noContent().build();
    }
}
