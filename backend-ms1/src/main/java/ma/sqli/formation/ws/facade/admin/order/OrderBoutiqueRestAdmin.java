package  ma.sqli.formation.ws.facade.admin.order;

import io.swagger.v3.oas.annotations.Operation;
import ma.sqli.formation.bean.core.order.OrderBoutique;
import ma.sqli.formation.dao.criteria.core.order.OrderBoutiqueCriteria;
import ma.sqli.formation.service.facade.admin.order.OrderBoutiqueAdminService;
import ma.sqli.formation.ws.converter.order.OrderBoutiqueConverter;
import ma.sqli.formation.ws.dto.order.OrderBoutiqueDto;
import ma.sqli.formation.zynerator.controller.AbstractController;
import ma.sqli.formation.zynerator.dto.FileTempDto;
import ma.sqli.formation.zynerator.util.PaginatedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/admin/orderBoutique/")
public class OrderBoutiqueRestAdmin  extends AbstractController<OrderBoutique, OrderBoutiqueDto, OrderBoutiqueCriteria, OrderBoutiqueAdminService, OrderBoutiqueConverter> {

    @Operation(summary = "Exporte pdf")
    @PostMapping("exportPdf/")
    public HttpEntity<byte[]> createPdf(@RequestBody OrderBoutiqueDto dto) throws Exception{
        return service.createPdf(dto);
    }
    @Operation(summary = "upload one orderBoutique")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple orderBoutiques")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all orderBoutiques")
    @GetMapping("")
    public ResponseEntity<List<OrderBoutiqueDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all orderBoutiques")
    @GetMapping("optimized")
    public ResponseEntity<List<OrderBoutiqueDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a orderBoutique by id")
    @GetMapping("id/{id}")
    public ResponseEntity<OrderBoutiqueDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }

    @Operation(summary = "Finds a orderBoutique by reference")
    @GetMapping("reference/{reference}")
    public ResponseEntity<OrderBoutiqueDto> findByReference(@PathVariable String reference, String[] includes, String[] excludes) throws Exception {
        return super.findByReferenceEntity(new OrderBoutique(reference), includes, excludes);
    }

    @Operation(summary = "Saves the specified  orderBoutique")
    @PostMapping("")
    public ResponseEntity<OrderBoutiqueDto> save(@RequestBody OrderBoutiqueDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  orderBoutique")
    @PutMapping("")
    public ResponseEntity<OrderBoutiqueDto> update(@RequestBody OrderBoutiqueDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of orderBoutique")
    @PostMapping("multiple")
    public ResponseEntity<List<OrderBoutiqueDto>> delete(@RequestBody List<OrderBoutiqueDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified orderBoutique")
    @DeleteMapping("")
    public ResponseEntity<OrderBoutiqueDto> delete(@RequestBody OrderBoutiqueDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified orderBoutique")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple orderBoutiques by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by orderStatus id")
    @GetMapping("orderStatus/id/{id}")
    public List<OrderBoutiqueDto> findByOrderStatusId(@PathVariable Long id){
        return findDtos(service.findByOrderStatusId(id));
    }
    @Operation(summary = "delete by orderStatus id")
    @DeleteMapping("orderStatus/id/{id}")
    public int deleteByOrderStatusId(@PathVariable Long id){
        return service.deleteByOrderStatusId(id);
    }
    @Operation(summary = "Finds a orderBoutique and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<OrderBoutiqueDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds orderBoutiques by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<OrderBoutiqueDto>> findByCriteria(@RequestBody OrderBoutiqueCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated orderBoutiques by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody OrderBoutiqueCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports orderBoutiques by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody OrderBoutiqueCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets orderBoutique data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody OrderBoutiqueCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public OrderBoutiqueRestAdmin (OrderBoutiqueAdminService service, OrderBoutiqueConverter converter) {
        super(service, converter);
    }




}
